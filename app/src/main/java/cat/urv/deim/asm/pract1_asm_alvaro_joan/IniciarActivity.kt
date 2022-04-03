package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IniciarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar)

        val inicio_session_button= findViewById<Button>(R.id.button_iniciar)
        inicio_session_button.setOnClickListener{
            val intent2: Intent = Intent()
            intent2.setClass(this, PatinetesActivity::class.java)
            this.startActivity(intent2)
        }
    }
}