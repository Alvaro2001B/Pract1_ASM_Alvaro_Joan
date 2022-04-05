package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IniciarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar)

        val iniciar= findViewById<Button>(R.id.button_iniciar)
        iniciar.setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, PatinetesActivity::class.java)
            this.startActivity(intent)
        }
    }
    }
