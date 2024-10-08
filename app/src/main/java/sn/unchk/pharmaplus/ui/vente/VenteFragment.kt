package sn.unchk.pharmaplus.ui.vente

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import sn.unchk.pharmaplus.R

class VenteFragment : Fragment() {

    private val viewModel: VenteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_vente, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.ventelist)

        // Données fictives
        val dummyVenteItems = listOf(
            VenteItem("Paracétamol", 100, "Comprimé", "500mg", 50, "2023-01-01", "2025-01-01"),
            VenteItem("Ibuprofène", 200, "Comprimé", "200mg", 30, "2023-02-01", "2025-02-01"),
            VenteItem("Amoxicilline", 150, "Capsule", "250mg", 20, "2023-03-01", "2025-03-01"),
            VenteItem("Doxycycline", 90, "Capsule", "100mg", 180, "2025-01-01", "2027-01-01")
        )

        val adapter = VenteAdapter(requireContext(), dummyVenteItems)
        listView.adapter = adapter
    }
}


data class VenteItem(
    val nom: String,
    val prix: Int,
    val forme: String,
    val dosage: String,
    val quantite: Int,
    val dateCreation: String,
    val dateExpiration: String
)

class VenteAdapter(context: Context, venteItems: List<VenteItem>) :
    ArrayAdapter<VenteItem>(context, 0, venteItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_vente, parent, false)

        val item = getItem(position)

        val nomTextView = view.findViewById<TextView>(R.id.nomTextView)
        val formeDosageTextView = view.findViewById<TextView>(R.id.formeDosageTextView)
        val prixTextView = view.findViewById<TextView>(R.id.prixTextView)
        val quantiteTextView = view.findViewById<TextView>(R.id.quantiteTextView)

        nomTextView.text = item?.nom
        formeDosageTextView.text = "Forme : ${item?.forme}, Dosage : ${item?.dosage}"
        prixTextView.text = "${item?.prix} FCFA"
        quantiteTextView.text = "Quantité : ${item?.quantite}"

        return view
    }
}

