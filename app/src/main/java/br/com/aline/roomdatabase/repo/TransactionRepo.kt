package br.com.aline.roomdatabase.repo

import br.com.aline.roomdatabase.db.AppDatabase
import br.com.aline.roomdatabase.model.Transaction


class TransactionRepo(private val db:AppDatabase) {

    suspend fun createTransaction(transaction: Transaction) = db.getTransactionDao().insertTransaction(transaction)
    suspend fun updateTransaction(transaction: Transaction) = db.getTransactionDao().updateTransaction(transaction)
    suspend fun deleteTransaction(transaction: Transaction) = db.getTransactionDao().deleteTransaction(transaction)

    fun getAllTransactions()= db.getTransactionDao().getAllTransactions()

    fun getSingleTransaction(transactionCategory: String) = db.getTransactionDao().getTransaction(transactionCategory)




}