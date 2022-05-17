package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityAyuda1Binding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.AppDatabase


class AyudaActivity1 : AppCompatActivity() {
    private lateinit var binding:ActivityAyuda1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(3000)
        val sharedPref = this.getSharedPreferences(
            getString(R.string.benvingut), Context.MODE_PRIVATE)
        val benvingut: Boolean = sharedPref.getBoolean(getString(R.string.benvingut),false)
        sharedPref.edit().putBoolean(getString(R.string.benvingut),true).apply()
        if (benvingut) {
            Toast.makeText(applicationContext,R.string.Benvingut, Toast.LENGTH_LONG).show()
            sharedPref.edit().putBoolean(getString(R.string.benvingut),false).apply()
        }
        setTheme(R.style.Theme_Pract1_ASM_Alvaro_Joan)
        super.onCreate(savedInstanceState)
        binding = ActivityAyuda1Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        val db= Room.databaseBuilder(
            applicationContext,AppDatabase::class.java,"ASM_db"
        ).build()
    }

    override fun onResume() {
        super.onResume()
        val sharedPref = this.getSharedPreferences(
            getString(R.string.inciar), Context.MODE_PRIVATE)
        val skipTutorial: Boolean = sharedPref.getBoolean(getString(R.string.inciar),false)
        sharedPref.edit().putBoolean(getString(R.string.inciar),false).apply()
        if (skipTutorial){
            val intent: Intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            this.startActivity(intent)
        }
        else{
            binding.siguiente.setOnClickListener {
                val intent: Intent = Intent()
                intent.setClass(this, AyudaActivity2::class.java)
                this.startActivity(intent)
            }

            binding.saltar.setOnClickListener{
                val alertDialogBuilder = AlertDialog.Builder(this)
                alertDialogBuilder.setTitle("Atenció !!!")
                alertDialogBuilder.setMessage("Vols que se't torni a mostrar el tutorial?").setCancelable(false).setPositiveButton("No") { dialog, id ->
                    val intent2: Intent = Intent()
                    intent2.setClass(this, MainActivity::class.java)
                    this.startActivity(intent2)
                    //SharedPreference
                 sharedPref.edit().putBoolean(getString(R.string.inciar),true).apply()
                }
                    .setNegativeButton(
                        "Si"
                    ) { dialog, id ->
                        val intent2: Intent = Intent()
                        intent2.setClass(this, MainActivity::class.java)
                        this.startActivity(intent2)
                    }.create().show()

            }
        }

    }

}


