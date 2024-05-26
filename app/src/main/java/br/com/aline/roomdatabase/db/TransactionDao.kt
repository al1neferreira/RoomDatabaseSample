package br.com.aline.roomdatabase.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(transaction: Transaction)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(transaction: Transaction)

    @Query("DELETE FROM all_transactions WHERE id =:id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM all_transactions")
    suspend fun deleteAll(transaction: Transaction)

    //get all saved transaction list
    @Query("SELECT * FROM all_transactions")
    fun getAllTransactions(): Flow<List<List<Transaction>>>


    //get all income or expense list
    @Query("SELECT * FROM all_transactions WHERE category == :category")
    fun getTransaction(category:String): Flow<List<List<Transaction>>>


}