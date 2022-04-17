package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityIniciarBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityMainBinding

class IniciarActivity : AppCompatActivity() {
    private lateinit var binding:ActivityIniciarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar)
            binding = ActivityIniciarBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.buttonIniciar.setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
        }
    }
    }
