package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentPatinetsBinding

class PatinetsFragment : Fragment() {

    private var _binding: FragmentPatinetsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(PatinetsViewModel::class.java)

        _binding = FragmentPatinetsBinding.inflate(inflater, container, false)
        val root: View = binding.root

      /*  val textView: TextView = binding.textView
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}