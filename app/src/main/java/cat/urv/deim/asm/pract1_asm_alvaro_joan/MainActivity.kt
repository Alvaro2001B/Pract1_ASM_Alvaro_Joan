package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    //Prueba
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.Registrar_se).setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, RegistreActivity::class.java)
            this.startActivity(intent)
        }

        findViewById<Button>(R.id.inicio_session).setOnClickListener{
                val intent2: Intent = Intent()
                intent2.setClass(this, IniciarActivity::class.java)
                this.startActivity(intent2)
            }
        }

    }
