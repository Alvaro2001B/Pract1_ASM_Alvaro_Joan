package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityAyuda1Binding


class AyudaActivity1 : AppCompatActivity() {
    private lateinit var binding:ActivityAyuda1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(5000)
        setTheme(R.style.Theme_Pract1_ASM_Alvaro_Joan)
        super.onCreate(savedInstanceState)
        binding = ActivityAyuda1Binding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.siguiente.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, AyudaActivity2::class.java)
            this.startActivity(intent)
        }

            binding.saltar.setOnClickListener{
            val intent2: Intent = Intent()
            intent2.setClass(this, MainActivity::class.java)
            this.startActivity(intent2)
        }
    }

}