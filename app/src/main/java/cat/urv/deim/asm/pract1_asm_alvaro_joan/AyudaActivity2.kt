package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AyudaActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda2)

        findViewById<Button>(R.id.siguiente).setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, AyudaActivity3::class.java)
            this.startActivity(intent)
        }

            findViewById<Button>(R.id.saltar).setOnClickListener{
            val intent2: Intent = Intent()
            intent2.setClass(this, MainActivity::class.java)
            this.startActivity(intent2)
        }
    }
}