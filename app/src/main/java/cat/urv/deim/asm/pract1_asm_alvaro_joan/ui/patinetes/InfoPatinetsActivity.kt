package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import cat.urv.deim.asm.pract1_asm_alvaro_joan.NavegacioActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityInfoPatinetsBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.Rent

class InfoPatinetsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityInfoPatinetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPatinetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref : SharedPreferences = binding.root.context.getSharedPreferences(
            getString(R.string.scooterdb), Context.MODE_PRIVATE)
        val editor= sharedPref.edit()

        val sharedPref1 : SharedPreferences = binding.root.context.getSharedPreferences(
            getString(R.string.userdb), Context.MODE_PRIVATE)
        val editor1= sharedPref1.edit()

        val DNI:String? = sharedPref1.getString("DNI","")

            dev_Utils.getRent()


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
            val scooterID:String? = sharedPref.getString("uuid","")
                dev_Utils.getRent()

            val rent: Rent =Rent(0,DNI,scooterID)
            Log.i("Info",rent.toString())
            dev_Utils.insertRent(rent)
            val intent:Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
        }
    }
}