package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityMainBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.AppDatabase
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.RentDao
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.ScooterDao
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.UserDao

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RegistrarSe.setOnClickListener {
            val intent: Intent = Intent()
            intent.setClass(this, RegistreActivity::class.java)
            this.startActivity(intent)
        }

        binding.inicioSession.setOnClickListener{
                val intent2: Intent = Intent()
                intent2.setClass(this, IniciarActivity::class.java)
                this.startActivity(intent2)
            }
        }

    override fun onStart() {
        super.onStart()
        val db= Room.databaseBuilder(
            applicationContext,AppDatabase::class.java,"ASM_db"
        ).build()
        val userDao: UserDao = db.userDao()
        val scooterDao: ScooterDao =db.scooterDao()
        val rentDao: RentDao =db.RentDao()
        dev_Utils.initDaos(userDao,scooterDao,rentDao)
    }
}
