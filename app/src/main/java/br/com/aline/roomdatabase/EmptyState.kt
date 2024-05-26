package br.com.aline.roomdatabase

import androidx.lifecycle.Observer
import androidx.room.Transaction

private fun listFromDataBase() {
    val listObserver = Observer<List<Transaction>> { listTransaction ->
        if (listTransaction.isEmpty()) {
            //.visibiity = view.VISIBLE

        }else{
            //.visibility = View.GONE

        }
        //adapter.submitlist(listTransaction)

    }
    //viewModel.taskListLiveData.observe(this, listObserver)
}

