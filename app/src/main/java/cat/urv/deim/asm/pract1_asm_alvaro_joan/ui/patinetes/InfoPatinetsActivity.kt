package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.pract1_asm_alvaro_joan.MainActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.NavegacioActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityInfoPatinetsBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories.PatinetLlogatActivity

class InfoPatinetsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityInfoPatinetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPatinetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref : SharedPreferences = binding.root.context.getSharedPreferences(
            getString(R.string.scooterdb), Context.MODE_PRIVATE)
        val editor= sharedPref.edit()
        binding.textView19.text=sharedPref.getString("Longitud","")
        binding.textView20.text=sharedPref.getString("Latitud","")
        binding.textView21.text=sharedPref.getString("bt_level","")
        binding.textView23.text=sharedPref.getString("Estado","")
        binding.textView24.text=sharedPref.getString("data","")

        binding.enrere.setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
        }
        binding.alquilar.setOnClickListener{
            val intent:Intent = Intent()
            intent.setClass(this, PatinetLlogatActivity::class.java)
            this.startActivity(intent)
        }
    }
}