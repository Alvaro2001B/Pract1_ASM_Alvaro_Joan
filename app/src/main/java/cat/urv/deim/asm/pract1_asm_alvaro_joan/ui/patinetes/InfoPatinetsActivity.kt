package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.pract1_asm_alvaro_joan.MainActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.NavegacioActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityInfoPatinetsBinding

class InfoPatinetsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityInfoPatinetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoPatinetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.enrere.setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
        }
        binding.alquilar.setOnClickListener{

        }
    }
}