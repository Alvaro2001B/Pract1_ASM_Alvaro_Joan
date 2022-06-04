package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityMainBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.*
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories.ScooterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
        updateListaScooters(this, scooterDao)
        dev_Utils.initDaos(applicationContext,userDao,scooterDao,rentDao)
    }
    fun updateListaScooters(context:Context, scooterDao: ScooterDao){
        CoroutineScope(Dispatchers.Main).launch {
            val deleteResult: Deferred<Unit> = ScooterRepository.deleteAllScooters(context, scooterDao)
            deleteResult.await()
            val insertResult: Deferred<Any> = ScooterRepository.insertScooters(context, scooterDao)
            insertResult.await()
            val scooterDeferred: Deferred<List<Scooter>> = ScooterRepository.getAllScooters(context, scooterDao)
            val scooter: List<Scooter> = scooterDeferred.await()
            println("Update list... "+scooter.toString())
        }
    }
}
