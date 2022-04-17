package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityAyuda3Binding

class AyudaActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityAyuda3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyuda3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.siguiente.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            this.startActivity(intent)
        }

            binding.saltar.setOnClickListener{
            val intent2: Intent = Intent()
            intent2.setClass(this, MainActivity::class.java)
            this.startActivity(intent2)
        }
    }
}