package sn.unchk.pharmaplus.ui.commande

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommandeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is commande Fragment"
    }
    val text: LiveData<String> = _text
}