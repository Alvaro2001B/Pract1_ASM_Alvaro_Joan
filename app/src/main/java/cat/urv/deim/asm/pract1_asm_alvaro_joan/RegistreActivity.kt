package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class RegistreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registre)

            findViewById<Button>(R.id.BotoRegistrar).setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, PatinetesActivity::class.java)
            this.startActivity(intent)
        }
    }
    }
