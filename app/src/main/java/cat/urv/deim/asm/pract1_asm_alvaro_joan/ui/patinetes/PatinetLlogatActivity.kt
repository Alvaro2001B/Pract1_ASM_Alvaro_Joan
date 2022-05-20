package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.NavegacioActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.historial.HistorialFragment

class PatinetLlogatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patinet_llogat)

        findViewById<Button>(R.id.acceptar).setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
    }
        findViewById<Button>(R.id.historial_boto).setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, HistorialFragment::class.java)
            this.startActivity(intent)
        }
    }
}