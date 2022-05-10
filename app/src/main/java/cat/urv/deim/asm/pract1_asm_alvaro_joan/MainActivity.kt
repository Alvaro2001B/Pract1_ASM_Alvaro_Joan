package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.room.Room
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityMainBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityNavegacioBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.AppDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RegistrarSe.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, RegistreActivity::class.java)
            this.startActivity(intent)
        }

        binding.inicioSession.setOnClickListener{
                val intent2: Intent = Intent()
                intent2.setClass(this, IniciarActivity::class.java)
                this.startActivity(intent2)
            }
        }


}
