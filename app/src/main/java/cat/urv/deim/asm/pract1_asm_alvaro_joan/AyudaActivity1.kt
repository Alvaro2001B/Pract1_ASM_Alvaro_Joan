package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AyudaActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(5000)
        setTheme(R.style.Theme_Pract1_ASM_Alvaro_Joan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda1)



        val siguiente: Button =findViewById<Button>(R.id.siguiente)
        siguiente.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, AyudaActivity2::class.java)
            this.startActivity(intent)
        }

        val saltar= findViewById<Button>(R.id.saltar)
        saltar.setOnClickListener{
            val intent2: Intent = Intent()
            intent2.setClass(this, MainActivity::class.java)
            this.startActivity(intent2)
        }
    }
}