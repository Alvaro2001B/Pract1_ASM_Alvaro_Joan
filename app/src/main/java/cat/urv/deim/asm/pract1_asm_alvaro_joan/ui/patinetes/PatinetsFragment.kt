package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import cat.urv.deim.asm.pract1_asm_alvaro_joan.MainActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.databinding.ActivityMainBinding
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.adapters.ScooterRecyclerViewAdapter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.base.AppConfig
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories.ScooterRepository


class PatinetsFragment : AppCompatActivity() {

    private lateinit var binding: PatinetsFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //MVC
        //setContentView(R.layout.activity_main)

        //Binding MVVM o MVP
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onResume() {
        super.onResume()

        //val scooters:Scooters  = ScooterRepository.activeScooters()

        //Scooters from json file. To access to the file raw/scooters.json:
        val scooters:Scooters  = ScooterRepository.activeScooters(this,
            AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE)

        // Increase performance when the size is static
        binding.scooterRecyclerView.setHasFixedSize(true)


        // Our RecyclerView is using the linear layout manager
        val layoutManager = LinearLayoutManager(applicationContext)
        binding.scooterRecyclerView.setLayoutManager(layoutManager)

        val adapter:ScooterRecyclerViewAdapter = ScooterRecyclerViewAdapter(scooters)
        binding.scooterRecyclerView.adapter = adapter
    }

}