package br.com.aline.roomdatabase.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Transaction
import br.com.aline.roomdatabase.db.TransactionDao
import kotlinx.coroutines.launch

class TransactionDetailViewModel(
    private val transactionDao: TransactionDao
) : ViewModel() {


    fun execute(transactionAction: TransactionAction) {

        when (transactionAction.actionType) {
            ActionType.CREATE.name -> insertIntoDatabase(transactionAction.transaction)
            ActionType.UPDATE.name -> updateIntoDatabase(transactionAction.transaction)
            ActionType.DELETE_ALL.name -> deleteAll(transactionAction.transaction)
            ActionType.DELETE.name -> deleteById(transactionAction.id)

        }

    }
     private fun deleteById(id: Int) {
        viewModelScope.launch {
            transactionDao.deleteById(id)
        }
    }

    private fun insertIntoDatabase(transaction: Transaction) {
        viewModelScope.launch {
            transactionDao.insert(transaction)
        }
    }

    private fun updateIntoDatabase(transaction: Transaction) {
        viewModelScope.launch {
            transactionDao.update(transaction)
        }
    }

    private fun deleteAll(transaction: Transaction) {
        viewModelScope.launch {
            transactionDao.deleteAll(transaction)
        }
    }


}