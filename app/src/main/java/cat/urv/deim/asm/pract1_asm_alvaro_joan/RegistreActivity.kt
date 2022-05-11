package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
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
        }
    }

    fun insertar(userDao:UserDao){
        val nom: String? = binding.nameUserR.text.toString()
        val cognom: String? = binding.cognomsUserR.text.toString()
        val dni: String? = binding.dniUserR.text.toString()
        val mail: String? = binding.mailUserR.text.toString()
        val tel: String? = binding.telUserR.text.toString()
        val pass: String? = binding.PasswordUserR.text.toString()
        val pass1: String? = binding.PasswordRepeatUserR.text.toString()

        val user:User= User(0,nom,cognom,dni,mail,tel,pass,pass1)

        dev_Utils.insertUser(userDao, user)
    }
    }

