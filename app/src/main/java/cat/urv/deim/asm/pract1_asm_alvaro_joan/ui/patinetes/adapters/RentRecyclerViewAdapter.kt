

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.InfoPatinetsActivity
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters


class RentRecyclerViewAdapter(private val scooters:Scooters) : RecyclerView.Adapter<RentRecyclerViewAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.textView)
            // val item:FrameLayout=view.findViewById(R.id.frame)
            val root: View = view

            init {
                /* item.setOnClickListener{
                     val intent : Intent=Intent()
                     intent.setClass(view.context,BlankFragment::class.java)
                     view.context.startActivity(intent)
                 }*/


            }
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
                val intent: Intent = Intent()
                intent.setClass(viewHolder.root.context , InfoPatinetsActivity::class.java)
                viewHolder.root.context.startActivity(intent)
            }

        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = scooters.scooters.size


}

