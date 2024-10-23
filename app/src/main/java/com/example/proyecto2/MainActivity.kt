package com.example.proyecto2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyecto2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.inicializarEventos()
    }
    fun inicializarEventos() {
        binding.btnSeleccionarCurso.setOnClickListener {
            val curso = binding.spiCurso.selectedItem.toString()
            val asignaturas: List<String> = this.getAsignaturas(curso)
            binding.txtAsignaturas.text = this.darFormato(asignaturas)

        }
        binding.btnEnviar.setOnClickListener {
            Toast.makeText(
                this, //La ventana se muestra encima de mainActivity
                getString(R.string.mensajeToast, binding.txtObservaciones.text.toString()),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    fun getAsignaturas(curso: String): List<String> =
        when (curso) {
            "1º DAM" -> listOf(
                "programacion",
                "sistemas",
                "lenguaje de marca",
                "base de datos",
                "entorno"
            )

            "2º DAM" -> listOf(
                "moviles",
                "interfaces",
                "acceso a datos",
                "servicios y progresos",
                "gestion empresarial"
            )

            else -> throw Exception("curso no admitido")
        }
    /*
    fun getAsignaturas(curso:String):List<String> =
        if (curso.equals("1º DAM")){
            listOf("programacion","sistemas", "lenguaje de marcas","base de datos", "entorno")
        }else{
            listOf("moviles","interfaces", "acceso a datos","servicios y progresos", "gestion empresarial")
        }


    fun getAsignaturas(curso:String):List<String>{
        var lista:List<String> = listOf()
        if (curso.equals("1º DAM")){
            lista = listOf("programacion","sistemas", "lenguaje de marcas","base de datos", "entorno")
        }else if (curso.equals("2º DAM")){
            lista = listOf("moviles","interfaces", "acceso a datos","servicios y progresos", "gestion empresarial")
        }
    }
    */

    fun darFormato(lista: List<String>): String =
        lista
            .map { asignatura -> "- ${asignatura}\n" }
            .joinToString("")
    /*
        fun darFormato(lista: List<String>): String {

            var resultado = ""
            for (asignaturas in lista) {
                resultado += "- ${asignaturas}\n"
            }

            return resultado
        }
        */



}






