package sn.unchk.pharmaplus.ui.vente

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VenteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is vente Fragment"
    }
    val text: LiveData<String> = _text
}