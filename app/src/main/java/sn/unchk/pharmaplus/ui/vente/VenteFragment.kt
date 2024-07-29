package sn.unchk.pharmaplus.ui.vente

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import sn.unchk.pharmaplus.databinding.FragmentVenteBinding

class VenteFragment : Fragment() {

    private var _binding: FragmentVenteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val venteViewModel=
            ViewModelProvider(this).get(VenteViewModel::class.java)

        _binding = FragmentVenteBinding.inflate(inflater, container, false)
        val root: View = binding.root


        venteViewModel.text.observe(viewLifecycleOwner) {

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}