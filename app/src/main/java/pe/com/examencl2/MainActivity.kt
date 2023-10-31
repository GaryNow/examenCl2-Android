package pe.com.examencl2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPregunta1 = findViewById<Button>(R.id.btnPreg1);
        val btnPregunta2 = findViewById<Button>(R.id.btnPreg2);

        btnPregunta1.setOnClickListener{
            var pregunta1Screen = Intent(this, Pregunta1Activity::class.java)
            startActivity(pregunta1Screen)
        }

        btnPregunta2.setOnClickListener{
            var pregunta2Screen = Intent(this, Pregunta2Activity::class.java)
            startActivity(pregunta2Screen)
        }

    }
}