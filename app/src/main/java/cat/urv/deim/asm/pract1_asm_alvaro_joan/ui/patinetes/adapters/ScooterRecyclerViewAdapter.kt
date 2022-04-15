package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import cat.urv.deim.asm.pract1_asm_alvaro_joan.R
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters


class ScooterRecyclerViewAdapter(private val scooters: Scooters) :
        RecyclerView.Adapter<ScooterRecyclerViewAdapter.ViewHolder>() {

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val textView: TextView = view.findViewById(R.id.textView)
            val root: View = view

            init {
                // Define click listener for the ViewHolder's View.
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
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        override fun getItemCount() = scooters.scooters.size

    }
