package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.perfil

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(PerfilViewModel::class.java)

        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val sharedPref : SharedPreferences = binding.root.context.getSharedPreferences(
            getString(R.string.userdb), Context.MODE_PRIVATE)
        val editor= sharedPref.edit()
        binding.nameUserR.text = sharedPref.getString("Nom","")
        binding.telUserR.text=sharedPref.getString("Tel","")
        binding.cognomsUserR.text=sharedPref.getString("Cognoms","")
        binding.mailUserR.text=sharedPref.getString("Correo","")
        binding.kmUserR.text=sharedPref.getString("km","")
        binding.dniUserR.text=sharedPref.getString("DNI","")
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}