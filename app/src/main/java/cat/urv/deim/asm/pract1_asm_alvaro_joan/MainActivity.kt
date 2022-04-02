package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    //Prueba

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(5000)
        setTheme(R.style.Theme_Pract1_ASM_Alvaro_Joan)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inicio_session_button = findViewById<Button>(R.id.inicio_session)
        inicio_session_button.setOnClickListener{
            val intent = Intent(this,MainActivity2 startActivity(intent))}
        }
    }
}