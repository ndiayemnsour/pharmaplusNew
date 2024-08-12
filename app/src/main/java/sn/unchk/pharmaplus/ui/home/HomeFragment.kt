package sn.unchk.pharmaplus.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sn.unchk.pharmaplus.R
import sn.unchk.pharmaplus.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView: ListView = view.findViewById(R.id.homeListView)

        // Création de données fictives
        val dummyItems = listOf(
            HomeItem("Paracétamol", 200),
            HomeItem("Ibuprofène", 130),
            HomeItem("Amoxicilline", 100),
            HomeItem("Doxycycline", 80),
            HomeItem("Aspirine", 30),
        )

        val adapter = HomeAdapter(requireContext(), dummyItems)
        listView.adapter = adapter
    }
}

//model
data class HomeItem(val nom: String, val quantite: Int)
//adapter
class HomeAdapter(context: Context, items: List<HomeItem>) : ArrayAdapter<HomeItem>(context, 0, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_home, parent, false)

        val item = getItem(position)

        val itemName = view.findViewById<TextView>(R.id.itemName)
        val itemQuantity = view.findViewById<TextView>(R.id.itemQuantity)

        itemName.text = item?.nom
        itemQuantity.text = item?.quantite.toString()

        return view
    }
}