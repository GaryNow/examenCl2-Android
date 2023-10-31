package pe.com.examencl2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pe.com.examencl2.ProyectoREST.CustomAdapterLibro
import pe.com.examencl2.ProyectoREST.ItBookAPI
import pe.com.examencl2.ProyectoREST.RetrofitHelper

class Pregunta2Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomAdapterLibro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta2)

        recyclerView = findViewById(R.id.rv_list_libros)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CustomAdapterLibro(emptyList()) // Inicializa el adaptador con una lista vacía
        recyclerView.adapter = adapter

        val itBookAPI = RetrofitHelper.getRetroFitInstance().create(ItBookAPI::class.java)

        GlobalScope.launch {
            val response = itBookAPI.getBooks()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    val results = body.books
                    runOnUiThread {
                        adapter.setData(results) // Actualiza los datos en el adaptador
                    }
                }
            } else {
                Log.e("REST error", "Status code: ${response.code()}")
            }
        }
    }
}