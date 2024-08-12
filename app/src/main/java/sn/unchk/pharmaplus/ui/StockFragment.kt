package sn.unchk.pharmaplus.ui

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import sn.unchk.pharmaplus.R

class StockFragment : Fragment() {

    companion object {
        fun newInstance() = StockFragment()
    }

    private val viewModel: StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_stock, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.idProduit)

        // Création de données fictives
        val dummyStockItems = listOf(
            VenteItem("Paracétamol", 100, "Comprimé", "500mg", 50, "2023-01-01", "2025-01-01"),
            VenteItem("Ibuprofène", 200, "Comprimé", "200mg", 30, "2023-02-01", "2025-02-01"),
            VenteItem("Amoxicilline", 150, "Capsule", "250mg", 20, "2023-03-01", "2025-03-01"),
            VenteItem("Aspirine", 50, "Comprimé", "300mg", 40, "2023-04-01", "2025-04-01"),
            VenteItem("Clarithromycine", 120, "Comprimé", "500mg", 15, "2023-05-01", "2025-05-01"),
            VenteItem("Azithromycine", 80, "Comprimé", "250mg", 25, "2023-06-01", "2025-06-01"),
            VenteItem("Ciprofloxacine", 60, "Comprimé", "500mg", 10, "2023-07-01", "2025-07-01"),
            VenteItem("Loratadine", 90, "Comprimé", "10mg", 35, "2023-08-01", "2025-08-01"),
            VenteItem("Métronidazole", 130, "Comprimé", "250mg", 45, "2023-09-01", "2025-09-01"),
            VenteItem("Oméprazole", 70, "Capsule", "20mg", 50, "2023-10-01", "2025-10-01"),
            VenteItem("Esoméprazole", 110, "Capsule", "20mg", 28, "2023-11-01", "2025-11-01"),
            VenteItem("Pantoprazole", 95, "Comprimé", "40mg", 18, "2023-12-01", "2025-12-01"),
            VenteItem("Furosemide", 200, "Comprimé", "40mg", 60, "2024-01-01", "2026-01-01"),
            VenteItem("Metformine", 180, "Comprimé", "500mg", 70, "2024-02-01", "2026-02-01"),
            VenteItem("Glibenclamide", 170, "Comprimé", "5mg", 80, "2024-03-01", "2026-03-01"),
            VenteItem("Lisinopril", 140, "Comprimé", "10mg", 90, "2024-04-01", "2026-04-01"),
            VenteItem("Atorvastatine", 160, "Comprimé", "20mg", 100, "2024-05-01", "2026-05-01"),
            VenteItem("Simvastatine", 100, "Comprimé", "20mg", 110, "2024-06-01", "2026-06-01"),
            VenteItem("Rosuvastatine", 130, "Comprimé", "10mg", 120, "2024-07-01", "2026-07-01"),
            VenteItem("Dexaméthasone", 190, "Comprimé", "0.5mg", 130, "2024-08-01", "2026-08-01"),
            VenteItem("Hydrocortisone", 170, "Comprimé", "10mg", 140, "2024-09-01", "2026-09-01"),
            VenteItem("Prednisolone", 150, "Comprimé", "5mg", 150, "2024-10-01", "2026-10-01"),
            VenteItem("Cortisone", 200, "Comprimé", "25mg", 160, "2024-11-01", "2026-11-01"),
            VenteItem("Triamcinolone", 80, "Comprimé", "4mg", 170, "2024-12-01", "2026-12-01"),
            VenteItem("Doxycycline", 90, "Capsule", "100mg", 180, "2025-01-01", "2027-01-01")
        )

        // Utilisation de l'adaptateur personnalisé
        val adapter = StockAdapter(requireContext(), dummyStockItems)
        listView.adapter = adapter


    }
}
class VenteItem (
    val Nom: String? = null,
    val Prix: Int? = null,
    val Forme: String? = null,
    val Dosage: String? = null,
    val Quantite: Int? = null,
    val Date_creation: String? = null,
    val Date_expiration: String? = null,
)


class StockAdapter(context: Context, stockItems: List<VenteItem>) :
    ArrayAdapter<VenteItem>(context, 0, stockItems) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_stock, parent, false)

        val item = getItem(position)

        val itemName = view.findViewById<TextView>(R.id.itemName)
        val itemDetails = view.findViewById<TextView>(R.id.itemDetails)


        itemName.text = item?.Nom
        itemDetails.text = "Quantité : ${item?.Quantite}"

        return view
    }
}