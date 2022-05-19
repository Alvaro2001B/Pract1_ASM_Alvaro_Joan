package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityRegistreBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.AppDatabase
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.User
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.UserDao

class RegistreActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegistreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registre)
        binding=ActivityRegistreBinding.inflate(layoutInflater)
        setContentView(binding.root)
           binding.enrere.setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
            insertar()

        }
    }

    fun insertar(){
        val nom: String? = binding.nameUserR.text.toString()
        val cognom: String? = binding.cognomsUserR.text.toString()
        val dni: String = binding.dniUserR.text.toString()
        val mail: String? = binding.mailUserR.text.toString()
        val tel: String? = binding.telUserR.text.toString()
        val pass: String? = binding.kmUserR.text.toString()

        val sharedPref : SharedPreferences =this.getSharedPreferences(
            getString(R.string.userdb), Context.MODE_PRIVATE)
        val edit = sharedPref.edit()
        edit.putString("Nom", nom)
        edit.putString("Cognoms", cognom)
        edit.putString("Correo",mail)
        edit.putString("DNI", dni)
        edit.putString("Tel", tel)
        edit.putString("km",0.0.toString())
        edit.apply()

        val user:User= User(dni,nom,cognom,mail,tel,0.0,pass)

        dev_Utils.insertUser(user)
    }
    }

