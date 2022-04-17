package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityAyuda2Binding

class AyudaActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityAyuda2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyuda2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.siguiente.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, AyudaActivity3::class.java)
            this.startActivity(intent)
        }
            binding.saltar.setOnClickListener{
            val intent2: Intent = Intent()
            intent2.setClass(this, MainActivity::class.java)
            this.startActivity(intent2)
        }
    }
}