package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.adapters


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.Scooter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.InfoPatinetsActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters


class ScooterRecyclerViewAdapter(private var scooters: Scooters) :
        RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {


        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.textView)
           // val item:FrameLayout=view.findViewById(R.id.frame)
            val root: View = view


        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.scooter_item_list, viewGroup, false)

            return ViewHolder(view)
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.textView.text = scooters.scooters.get(position).uuid
            viewHolder.root.setOnClickListener {
                Toast.makeText(viewHolder.root.context,
                    "Row selected %d".format(position),
                    Toast.LENGTH_LONG).show()
                dev_Utils.getScooter()
                val scooterList:Scooters = dev_Utils.scooterList
                var scooter: Scooter? = null
                var find:Boolean=false
                Log.i("info", scooterList.toString())
                for(scooters in scooterList.scooters){
                    if(scooters.uuid == this.scooters.scooters.get(position).uuid && !find){
                        Log.i("info",this.scooters.scooters.get(position).uuid)
                        scooter=scooters
                        find=true
                    }
                }
                val sharedPref : SharedPreferences =viewHolder.root.context.getSharedPreferences("datosScooter", Context.MODE_PRIVATE)
                val edit = sharedPref.edit()
                edit.putString("uuid", scooter!!.uuid)
                edit.putString("Longitud", scooter.longitude.toString())
                edit.putString("Latitud",scooter.latitude.toString())
                edit.putString("bt_level", scooter.battery_level.toString())
                edit.putString("km", scooter.km_use.toString())
                edit.putString("data",scooter.date_last_maintenance )
                edit.putString("Estado",scooter.state)
                edit.apply()

                val intent:Intent = Intent()
                intent.setClass(viewHolder.root.context , InfoPatinetsActivity::class.java)
                viewHolder.root.context.startActivity(intent)
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = scooters.scooters.size

        fun updateScooters(scooters: Scooters) {
        this.scooters = scooters.scooters
        this.notifyDataSetChanged()
        }
    }
