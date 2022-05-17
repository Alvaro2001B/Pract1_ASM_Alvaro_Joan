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
        val db= Room.databaseBuilder(
            applicationContext, AppDatabase::class.java,"ASM_db"
        ).build()
        val userDao:UserDao= db.userDao()


           binding.enrere.setOnClickListener{
            val intent: Intent = Intent()
            intent.setClass(this, NavegacioActivity::class.java)
            this.startActivity(intent)
               insertar(userDao)
        }
    }

    fun insertar(userDao:UserDao){
        val nom: String? = binding.nameUserR.text.toString()
        val cognom: String? = binding.cognomsUserR.text.toString()
        val dni: String? = binding.dniUserR.text.toString()
        val mail: String? = binding.mailUserR.text.toString()
        val tel: String? = binding.telUserR.text.toString()
        val pass: String? = binding.PasswordUserR.text.toString()

        val user:User= User(0,nom,cognom,dni,mail,tel,0.0,pass)

        dev_Utils.insertUser(userDao, user)
    }
    }

