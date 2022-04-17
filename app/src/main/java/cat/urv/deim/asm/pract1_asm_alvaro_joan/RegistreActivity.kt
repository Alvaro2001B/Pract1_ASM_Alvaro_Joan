package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityRegistreBinding

class RegistreActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegistreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registre)
        binding=ActivityRegistreBinding.inflate(layoutInflater)
        setContentView(binding.root)
           binding.enrere.setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
        }
    }
    }
