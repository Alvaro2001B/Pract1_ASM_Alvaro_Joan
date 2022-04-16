package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentBlankBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.base.AppConfig
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories.ScooterRepository

class BlankFragment : Fragment() {
    private var _binding:FragmentBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(PatinetsViewModel::class.java)

        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    _binding = FragmentBlankBinding.inflate(layoutInflater)
        val view = binding.root

        }

    override fun onResume() {
        super.onResume()

    val scooters: Scooters = ScooterRepository.activeScooters(requireContext(), AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE)
        binding.scooterRecyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(requireContext())
        binding.scooterRecyclerView.setLayoutManager(layoutManager)

        val adapter: ScooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(scooters)
        binding.scooterRecyclerView.adapter = adapter

    }
    }



