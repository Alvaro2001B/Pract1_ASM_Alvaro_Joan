package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityIniciarBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class IniciarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIniciarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar)
        binding = ActivityIniciarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var find: Boolean = false
        dev_Utils.getUsers()
        val userList:List<User> = dev_Utils.userList
        binding.buttonIniciar.setOnClickListener {
        Log.i("Info",userList.toString())
            val DNI: String = binding.edittxtiniciar.text.toString()
            val pass: String = binding.editTextTextPassword.text.toString()
            lateinit var user:User
        Log.i("Info", "$DNI   $pass")
            for(users in userList){
                if(users.DNI==DNI && users.Contrasenya==pass && !find){
                    find=true
                    user=users
                }
            }
            if(find){
                val intent: Intent = Intent()
                intent.setClass(this, NavegacioActivity::class.java)
                val sharedPref :SharedPreferences =this.getSharedPreferences(
                    getString(R.string.userdb), Context.MODE_PRIVATE)
                val edit = sharedPref.edit()
                edit.putString("Nom", user.Nom)
                edit.putString("Cognoms", user.Cognoms)
                edit.putString("Correo",user.Correu)
                edit.putString("DNI", user.DNI)
                edit.putString("Tel", user.Telèfon)
                edit.putString("km",user.KmRecorreguts.toString() )
                edit.apply()
                this.startActivity(intent)
            } else {
                    Toast.makeText(applicationContext,R.string.error, Toast.LENGTH_LONG).show()
                    /*val intent: Intent = Intent()
                    intent.setClass(this, IniciarActivity::class.java)
                    this.startActivity(intent)*/

                }

            }
        }
    }


