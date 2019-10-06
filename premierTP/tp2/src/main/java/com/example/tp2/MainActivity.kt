package com.example.tp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tp2.fragment.ArticlesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragment = ArticlesFragment()
        //créer un transaction sur le fragment manager
        supportFragmentManager.beginTransaction().apply {
        // replacer le précédent fragment, s'il existe
        replace(R.id.fragment_container, fragment)
        // ajouter la transaction dans la stack
         addToBackStack(null)}.commit()
        // finalement, on valide la transaction

    }
}
