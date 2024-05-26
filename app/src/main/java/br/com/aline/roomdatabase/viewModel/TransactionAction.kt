package br.com.aline.roomdatabase.viewModel

import androidx.room.Transaction
import java.io.Serializable

enum class ActionType {
    DELETE,
    UPDATE,
    CREATE,
    DELETE_ALL
}

data class TransactionAction(
    val transaction: Transaction,
    val actionType: String,
    val id: Int
): Serializable

