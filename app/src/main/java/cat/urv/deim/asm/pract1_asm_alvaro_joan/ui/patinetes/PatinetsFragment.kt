package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentPatinetsBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.Scooter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.base.AppConfig
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories.ScooterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PatinetsFragment : Fragment() {
    private var _binding:FragmentPatinetsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(PatinetsViewModel::class.java)

        _binding = FragmentPatinetsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textView
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentPatinetsBinding.inflate(layoutInflater)
        val view = binding.root
        //val scooters: Scooters = ScooterRepository.activeScooters(requireContext(), AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE)
        val scooter:List<Scooter> = emptyList()
        val adapter: ScooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(scooter)
        binding.scooterRecyclerView.adapter = adapter
        updateScooterRecycleView(adapter)

        }

    fun updateScooterRecycleView(adapter: ScooterRecyclerViewAdapter){
        GlobalScope.launch() {
            val scooters = withContext(Dispatchers.IO) {
                dev_Utils.scooterList
            }
            adapter.updateScooters(scooters)
        }
    }
    }





