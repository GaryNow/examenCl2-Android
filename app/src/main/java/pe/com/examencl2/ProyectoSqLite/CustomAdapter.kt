package pe.com.examencl2.ProyectoSqLite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.com.examencl2.R

class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val autor : TextView = ItemView.findViewById(R.id.lbl_autor)
        val libro: TextView = ItemView.findViewById(R.id.lbl_libro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_preg1,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Si deseo alguna conexión podría ser aquí(BD, Servicios web, etc)
        val itemViewModel = mList[position]
        holder.autor.text = itemViewModel.autor
        holder.libro.text = itemViewModel.libro
    }

}