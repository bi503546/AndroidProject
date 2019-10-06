package com.example.tp2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp2.ArticleAdapter
import com.example.tp2.R
import com.example.tp2.adaptateur.Article
import com.example.tp2.network.repository.ArticleRepository

class ArticlesFragment : Fragment()
{
    lateinit var spinner: Spinner
    lateinit var adapter: ArrayAdapter<String>
    lateinit var recyclerView: RecyclerView
    /**   * Ici, on associe le layout à afficher dans le fragment    */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?   ): View? {
        return inflater.inflate(R.layout.fragmentlayout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindView(view)
    }

    private fun bindView(root:View) {
        //recupérer une liste de string depuis les ressources
        var planetes = resources.getStringArray(R.array.planetes)
        //recupérer l'instance du spinner dans la vue
        spinner = root.findViewById(R.id.spinner)
        //instancier l'adapteur
        adapter = ArrayAdapter(root.context, android.R.layout.simple_spinner_item, planetes)
        //associer l'adapter au spinner
        spinner.adapter = adapter
        //Listener quand l'utilisateur selectionne un élément
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(root.context, "Vous n'avez rien selectionné", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    root.context,
                    "Vous avez selectionné ${planetes[position]}",
                    Toast.LENGTH_LONG
                ).show()
                println("${planetes[position]} choisi !!!!!!!!!!!!!!!!!!!!!")
            }
        }
        recyclerView = root.findViewById(R.id.reycler_view)
        // créer une liste d'articles
        val articles = listOf<Article>(
            Article("cccc",
                "Jupiter is the fifth planet from the Sun and the largest in the Solar System. It is a gas giant with a mass one-thousandth that of the Sun, but two-and-a-half times that of all the other planets in the Solar System combined. Jupiter has been known to astronomers since antiquity."
            ),
            Article(
                "Earth",
                "Earth is the third planet from the Sun and the only astronomical object known to harbor life."
            )
            ,
            Article("toto", "toto toot totot tot t")
        )

        //instance du recycler

        // créer une instance de l'adapteur
        var adapterRecycler = ArticleAdapter(articles)
        // définir l'orientation des élements (vertical)
        recyclerView.layoutManager = LinearLayoutManager(root.context)
        // associer l'adapter à la recyclerview
        recyclerView.adapter = adapterRecycler
        }


    }

