package com.recyclerviewkotlincs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.blackpanther,
                "Black Panther",
                "Black panther memiliki kuku tajam untuk mengalahkan penjahat diluar sana"
            ),
            Superhero(
                R.drawable.captainamr,
                "Captain Amerika",
                "Dengan perisai ikonik miliknya dia berani membela kebenaran dan membasmi kejahatan"
            ),
            Superhero(
                R.drawable.deadpool,
                "Deadpool",
                "Dengan ciri khas topeng merah ia tidak bisa dibunuh dengan cara biasaa"
            ),
            Superhero(
                R.drawable.hulk,
                "Hulk",
                "hulk adalah pahlawan besar berwarna hijau siap membantu"
            ),
            Superhero(
                R.drawable.ironman,
                "Iron Man",
                "Iron man menjadi tokoh utama dan memiliki kekuatan berupa laser ditangannya"
            ),
            Superhero(
                R.drawable.spiderman,
                "Spiderman",
                "Spiderman terkenal dengan kemampuannya untuk mengeluarkan jaring dari tanggannya dan memanjat dinding"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rvHero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this,superheroList){
            val intent = Intent(this,DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE,it)
            startActivity(intent)

        }
    }
}