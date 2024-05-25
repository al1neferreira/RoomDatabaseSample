package br.com.aline.roomdatabase.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: br.com.aline.roomdatabase.model.Transaction)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTransaction(transaction: br.com.aline.roomdatabase.model.Transaction)

    @Delete()
    suspend fun deleteTransaction(transaction: br.com.aline.roomdatabase.model.Transaction)

    //get all saved transaction list
    @Query("SELECT * FROM all_transactions")
    fun getAllTransactions(): Flow<List<List<Transaction>>>


    //get all income or expense list
    @Query("SELECT * FROM all_transactions WHERE category == :category")
    fun getTransaction(category:String): Flow<List<List<Transaction>>>


}