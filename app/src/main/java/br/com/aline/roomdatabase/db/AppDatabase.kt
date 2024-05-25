package br.com.aline.roomdatabase.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.aline.roomdatabase.model.Transaction

@Database(
    entities = [Transaction::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun getTransactionDao(): TransactionDao


    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) =
            instance ?: synchronized(LOCK) {
                createDatabase(context).also {
                    instance = it
                }
            }


        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "transaction_db"
            ).build()

    }


}