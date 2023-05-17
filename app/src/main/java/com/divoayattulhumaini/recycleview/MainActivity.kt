package com.divoayattulhumaini.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.divoayattulhumaini.recycleview.adapter.AdapterTeamBola
import com.divoayattulhumaini.recycleview.databinding.ActivityMainBinding
import com.divoayattulhumaini.recycleview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Andri Tany",R.drawable.Andri,"Penjaga Gawang","1.71m","Jakarta","26 Des 1991"))
        listPemain.add(Pemain("Muhammad Ferarri",R.drawable.Ferari,"Bek Tengah","1.81m","Jakarta","21 Jun 2003"))
        listPemain.add(Pemain("Rio Fahmi",R.drawable.Rio,"Bek Kanan","1.70m","Banjarnegara","6 Okt 2001"))
        listPemain.add(Pemain("Rizky Ridho",R.drawable.Rizky,"Bek Tengah","1.83m","Surabaya","21 Nov 2001"))
        listPemain.add(Pemain("Hanif Sjahbandi",R.drawable.Sjahbandi,"Gelandang Bertahan","1.81m","Bandung","7 Apr 1997"))

        binding.list.adapter = AdapterTeamBola(this,listPemain,object : AdapterTeamBola.OnClickListener{
            override fun detailData(item: Pemain?) {
                TODO("Not yet implemented")
            }

        })
    }
}