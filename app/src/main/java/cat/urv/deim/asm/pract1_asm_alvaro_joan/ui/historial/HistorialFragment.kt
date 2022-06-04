package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.historial

import RentRecyclerViewAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentHistorialBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentPatinetsBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.Rent
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.base.AppConfig
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories.ScooterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistorialFragment : Fragment() {

    private var _binding: FragmentHistorialBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(HistorialViewModel::class.java)

        _binding = FragmentHistorialBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val rentList: List<Rent> = dev_Utils.rentList
        val layoutManager = LinearLayoutManager(context)
        binding.rentRecyclerView.layoutManager = layoutManager
        binding.rentRecyclerView.setHasFixedSize(true)
        binding.rentRecyclerView.layoutManager = layoutManager
        val adapter: RentRecyclerViewAdapter = RentRecyclerViewAdapter()
        binding.rentRecyclerView.adapter = adapter
        updateRentRecycleView(adapter)
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentHistorialBinding.inflate(layoutInflater)
        val view = binding.root

        val adapter: RentRecyclerViewAdapter = RentRecyclerViewAdapter()
        binding.rentRecyclerView.adapter = adapter
        adapter.onAttachedToRecyclerView(binding.rentRecyclerView)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun updateRentRecycleView(adapter: RentRecyclerViewAdapter){
        GlobalScope.launch() {
            val rents = withContext(Dispatchers.IO) {
                dev_Utils.getRent()
                dev_Utils.rentList
            }
            adapter.updateRent(rents)
        }
    }

}