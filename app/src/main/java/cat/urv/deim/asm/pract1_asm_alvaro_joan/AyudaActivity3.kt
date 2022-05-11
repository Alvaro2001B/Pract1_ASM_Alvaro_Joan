package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityAyuda3Binding

class AyudaActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityAyuda3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAyuda3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.siguiente.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            this.startActivity(intent)
        }

            binding.saltar.setOnClickListener{
            val intent2: Intent = Intent()
            intent2.setClass(this, MainActivity::class.java)
            this.startActivity(intent2)
        }
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
                intent.setClass(this, MainActivity::class.java)
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