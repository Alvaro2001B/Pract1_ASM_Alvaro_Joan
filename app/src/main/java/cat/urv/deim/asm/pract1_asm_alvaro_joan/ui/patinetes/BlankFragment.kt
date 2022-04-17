package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentBlankBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentPatinetsBinding

class BlankFragment : Fragment() {

    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = FragmentBlankBinding.inflate(layoutInflater)
        val view = binding.root
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val root: View = binding.root
    return root
    }

}
