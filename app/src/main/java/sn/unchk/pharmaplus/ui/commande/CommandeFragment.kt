package sn.unchk.pharmaplus.ui.commande

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sn.unchk.pharmaplus.R
import sn.unchk.pharmaplus.ui.commandezo.CommandeViewModel

class CommandeFragment : Fragment() {

    private lateinit var commandeViewModel: CommandeViewModel
    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_commande, container, false)
        listView = root.findViewById(R.id.listView)

        commandeViewModel = ViewModelProvider(this).get(CommandeViewModel::class.java)

        commandeViewModel.commandes.observe(viewLifecycleOwner) { commandes ->
            val adapter = CommandeAdapter(requireContext(), commandes)
            listView.adapter = adapter
        }

        return root
    }
}


data class CommandeItem(
    val nom: String,
    val quantite: Int,
    val prix: Double
)

class CommandeAdapter(private val context: Context, private val dataSource: List<CommandeItem>) : BaseAdapter(),
    ListAdapter {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int = dataSource.size

    override fun getItem(position: Int): CommandeItem = dataSource[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.item_commande, parent, false)
        val nomTextView = view.findViewById<TextView>(R.id.nomTextView)
        val quantiteTextView = view.findViewById<TextView>(R.id.quantiteTextView)
        val prixTextView = view.findViewById<TextView>(R.id.prixTextView)

        val commande = getItem(position)

        nomTextView.text = commande.nom
        quantiteTextView.text = "Quantité: ${commande.quantite}"
        prixTextView.text = "${commande.prix} FCFA"

        return view
    }
}
