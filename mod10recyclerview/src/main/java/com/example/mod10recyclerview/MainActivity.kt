package com.example.mod10recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val alMinistres = arrayListOf(
            Ministre("Elisabeth","Borne", "1er",61,
                "Renaissance","https://upload.wikimedia.org/wikipedia/commons/thumb/e/eb/Elisabeth_Borne_November_2022_close-up.jpg/800px-Elisabeth_Borne_November_2022_close-up.jpg"),
            Ministre("Christophe", "Bechu", "Ministre de la transition énergétique",
            48,"UMP puis Renaissance","https://upload.wikimedia.org/wikipedia/commons/thumb/b/bd/Christophe_B%C3%89CHU.jpg/800px-Christophe_B%C3%89CHU.jpg"),
            Ministre("Clément","Beaune","Ministre des transports",41,"Renaissance","https://upload.wikimedia.org/wikipedia/commons/d/dc/Cl%C3%A9ment_Beaune.jpg"),
            Ministre("Patrick","Roy","Député",53,"PS","https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Patrick_Roy_-_2010.jpg/1024px-Patrick_Roy_-_2010.jpg"),
            Ministre("Jean-Yves", "Le Drian", "Ministre de l'Europe et des Affaires étrangères", 74, "PS", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Jean-Yves_Le_Drian_%28cropped%29.jpg/800px-Jean-Yves_Le_Drian_%28cropped%29.jpg"),
            Ministre("Eric", "Dupond-Moretti", "Garde des Sceaux, ministre de la Justice", 60, "LREM", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fd/Eric_Dupond-Moretti_July_2020.jpg/800px-Eric_Dupond-Moretti_July_2020.jpg"),
            Ministre("Roselyne", "Bachelot", "Ministre de la Culture", 74, "UMP puis LREM", "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f2/Roselyne_Bachelot-Narquin.jpg/800px-Roselyne_Bachelot-Narquin.jpg"),
            Ministre("Olivier", "Véran", "Ministre des Solidarités et de la Santé", 42, "LREM", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2e/Olivier_V%C3%A9ran_2022.jpg/800px-Olivier_V%C3%A9ran_2022.jpg"),
            Ministre("Frédérique", "Vidal", "Ministre de l'Enseignement supérieur, de la Recherche et de l'Innovation", 57, "LREM", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/72/Fr%C3%A9d%C3%A9rique_Vidal_%28cropped%29.jpg/800px-Fr%C3%A9d%C3%A9rique_Vidal_%28cropped%29.jpg"),
         )
        val rvMinistre : RecyclerView = findViewById(R.id.recyclerViewMinistres)
        val adapter = MinistreAdapter(alMinistres,{ministre->
            print(ministre.toString())
        })
        //Indiquer à la recyclerView comment sont affichés les éléments de notre liste
        rvMinistre.layoutManager = LinearLayoutManager(this)
        //adapter.setOnMinistreClickListener { ministre->
        //    print(ministre.toString())
        //}
        rvMinistre.adapter = adapter

    }
}