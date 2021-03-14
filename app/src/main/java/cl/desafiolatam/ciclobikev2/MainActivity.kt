package cl.desafiolatam.ciclobikev2

import ListaAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.desafiolatam.Ciclovia
import cl.desafiolatam.SetupCiclovias

class MainActivity : AppCompatActivity() {

    var lista: ArrayList<Ciclovia>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonFiltrar = findViewById(R.id.button_filtrar) as Button
        val buttonNoFiltrar = findViewById(R.id.button_no_filtrar) as Button
        val listaCiclovias = findViewById(R.id.lista_ciclovias) as RecyclerView
        setupCiclovias()
        listaCiclovias.layoutManager = LinearLayoutManager(this)
        val listaAdapter = ListaAdapter(this)
        listaCiclovias.adapter = listaAdapter
        listaAdapter.setupData(lista!!)

        buttonFiltrar.setOnClickListener {
            val listaAux: ArrayList<Ciclovia>? = ArrayList()
            lista!!.forEach {
                when (it.comuna) {
                    "Las Condes" -> listaAux!!.add(it)
                }
            }
            listaAdapter.setupData(listaAux!!)
        }
        buttonNoFiltrar.setOnClickListener { listaAdapter.setupData(lista!!) }
    }

    private fun setupCiclovias() {
        val setupCiclovias = SetupCiclovias()
        lista = setupCiclovias.init()
    }

   // val spinner: Spinner = findViewById(R.id.spinner)



}
