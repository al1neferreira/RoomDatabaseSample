package br.com.aline.roomdatabase.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import br.com.aline.roomdatabase.model.Transaction
import br.com.aline.roomdatabase.repo.TransactionRepo
import kotlinx.coroutines.launch

class TransactionViewModel(application:Application, private val transactionRepo: TransactionRepo): AndroidViewModel(application) {


    fun insertTransaction(transaction: Transaction) = viewModelScope.launch {
        transactionRepo.createTransaction(transaction)
    }

    fun deleteTransaction(transaction: Transaction) = viewModelScope.launch {
        transactionRepo.deleteTransaction(transaction)
    }

    fun iupdateTransaction(transaction: Transaction) = viewModelScope.launch {
        transactionRepo.updateTransaction(transaction)
    }

    init {
        viewModelScope.launch {
            transactionRepo.getAllTransactions().collect{ result->


            }
        }

    }

}