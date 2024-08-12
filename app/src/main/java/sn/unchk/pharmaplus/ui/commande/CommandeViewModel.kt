package sn.unchk.pharmaplus.ui.commandezo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sn.unchk.pharmaplus.ui.commande.CommandeItem

class CommandeViewModel : ViewModel() {

    private val _commandes = MutableLiveData<List<CommandeItem>>().apply {
        value = listOf(
            CommandeItem("Paracetamol", 10, 1500.0),
            CommandeItem("Aspirine", 5, 2000.0),
            CommandeItem("Ibuprofène", 8, 1800.0),
            CommandeItem("Triamcinolone", 8, 1800.0),
            CommandeItem("Cortisone", 8, 1800.0),
            CommandeItem("Doxycycline", 8, 1800.0),
            CommandeItem("Loratadine", 8, 1800.0),
            CommandeItem("Aspirine", 8, 6800.0),
            CommandeItem("Amoxicilline", 8, 8100.0),
        )
    }
    val commandes: LiveData<List<CommandeItem>> = _commandes
}
