package pe.com.examencl2.ProyectoREST

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import pe.com.examencl2.R

class CustomAdapterLibro(private var mList: List<Book>) : RecyclerView.Adapter<CustomAdapterLibro.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        val imageView: ImageView = ItemView.findViewById(R.id.img_libro)
        val tituloLibro: TextView = ItemView.findViewById(R.id.lbl_nombre_libro)
        val precioLibro: TextView = ItemView.findViewById(R.id.lbl_precio_libro)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_preg2, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Si deseo alguna conexión podría ser aquí(BD, Servicios web, etc)
        val itemViewModel = mList[position]

        Glide.with(holder.imageView.context)
            .load(itemViewModel.image)
            .into(holder.imageView)
        holder.tituloLibro.text = itemViewModel.title
        holder.precioLibro.text = itemViewModel.price
    }

    // Función para actualizar los datos del adaptador
    fun setData(newList: List<Book>) {
        mList = newList
        notifyDataSetChanged()
    }

}