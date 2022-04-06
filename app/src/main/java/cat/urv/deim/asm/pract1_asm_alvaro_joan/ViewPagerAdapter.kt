package cat.urv.deim.asm.pract1_asm_alvaro_joan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView



class ViewPagerAdapter(private val boardList: List<Board>):RecyclerView.Adapter<ViewPagerAdapter.BoardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.board_item,parent,false)
        return BoardViewHolder(view)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.bind(boardList[position])
    }

    override fun getItemCount(): Int {
        return boardList.size
    }

    inner class BoardViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){
        private val container = itemView.container
        private val image = itemView.imageView
        private val descripcion = itemView.descripcion
        private val boton = itemView.siguiente
        fun bind(board:Board){

        }
    }

}