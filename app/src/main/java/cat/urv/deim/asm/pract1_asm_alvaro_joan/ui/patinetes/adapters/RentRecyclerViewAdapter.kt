

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.pract1_asm_alvaro_joan.NavegacioActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.Rent
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.adapters.ScooterRecyclerViewAdapter


class RentRecyclerViewAdapter() : RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {
    var rentList:List<Rent> = emptyList()
    lateinit var context:Context
    init {
        rentList=dev_Utils.rentList
    }
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.textView)
            val root: View = view

        }

        // Create new views (invoked by the layout manager)
        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ScooterRecyclerViewAdapter.ViewHolder {
            // Create a new view, which defines the UI of the list item
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.scooter_item_list, viewGroup, false)

            return ScooterRecyclerViewAdapter.ViewHolder(view)
        }
        override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
            super.onAttachedToRecyclerView(recyclerView)
            context = recyclerView.context
        }

        // Replace the contents of a view (invoked by the layout manager)
        override fun onBindViewHolder(viewHolder: ScooterRecyclerViewAdapter.ViewHolder, position: Int) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.textView.text = rentList.get(position).IDScooter
            viewHolder.root.setOnClickListener {
                Toast.makeText(viewHolder.root.context,
                    "Row selected %d".format(position),
                    Toast.LENGTH_LONG).show()
                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setTitle("Fi del alquiler")
                alertDialogBuilder.setMessage("Vols deixar el patient?").setCancelable(false).setPositiveButton("No") { dialog, id ->
                }
                    .setNegativeButton(
                        "Si"
                    ) { dialog, id ->
                        dev_Utils.deleteRent(rentList[position])
                        val intent: Intent = Intent()
                        intent.setClass(viewHolder.root.context , NavegacioActivity::class.java)
                        viewHolder.root.context.startActivity(intent)
                    }.create().show()

            }
        }



        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = rentList.size


}


