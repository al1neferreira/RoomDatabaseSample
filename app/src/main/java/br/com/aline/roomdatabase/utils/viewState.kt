package br.com.aline.roomdatabase.utils

import androidx.constraintlayout.motion.utils.ViewState
import br.com.aline.roomdatabase.model.Transaction

class viewState {
    object Loading: ViewState()
    object Empty: ViewState()
    data class Success(val transaction: List<Transaction>):ViewState()
    data class Error(val exception: Throwable): ViewState()

}