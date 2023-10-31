package pe.com.examencl2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.com.examencl2.ProyectoSqLite.BDHelper
import pe.com.examencl2.ProyectoSqLite.CustomAdapter
import pe.com.examencl2.ProyectoSqLite.ItemsViewModel

class Pregunta1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta1)

        val btnGrabar: Button = findViewById(R.id.btnCrear)
        val btnLimpiar: Button = findViewById(R.id.btnLimpiar)

        btnGrabar.setOnClickListener {
            val inputAutor: EditText = findViewById(R.id.txtAutor)
            val inputLibro: EditText = findViewById(R.id.txtLibro)

            val autor = inputAutor.text.toString()
            val libro = inputLibro.text.toString()

            val db = BDHelper(this, null)

            db.CrearRegistro(autor, libro)
            Toast.makeText(this, "Se registró de manera exitosa", Toast.LENGTH_LONG).show()

            limpiarCajas()
            cargarDatos()
        }

        btnLimpiar.setOnClickListener {
            limpiarCajas()
        }


        cargarDatos()
    }

    fun cargarDatos(){
        val bdHelper = BDHelper(this, null)
        val data = bdHelper.ListarTodosRegistros()

        val autoresRecycler : RecyclerView = findViewById(R.id.rv_list_autores)
        autoresRecycler.layoutManager = LinearLayoutManager(this)

        val adapter = CustomAdapter(data)
        autoresRecycler.adapter = adapter
    }

    fun limpiarCajas() {
        val inputAutor: EditText = findViewById(R.id.txtAutor)
        val inputLibro: EditText = findViewById(R.id.txtLibro)

        inputAutor.text.clear()
        inputLibro.text.clear()
    }

}