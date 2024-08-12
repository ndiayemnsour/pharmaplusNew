package sn.unchk.pharmaplus.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class StockViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _stockItems = MutableLiveData<List<VenteItem>>()
    val stockItems: LiveData<List<VenteItem>> get() = _stockItems

    init {
        loadStockItems()
    }

    private fun loadStockItems() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("stockItems")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val items = mutableListOf<VenteItem>()
                for (snapshot in dataSnapshot.children) {
                    val item = snapshot.getValue(VenteItem::class.java)
                    item?.let { items.add(it) }
                }
                _stockItems.value = items
            }

            override fun onCancelled(error: DatabaseError) {
                // Log ou gestion de l'erreur
            }
        })
    }
}