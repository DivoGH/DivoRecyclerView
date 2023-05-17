package com.divoayattulhumaini.recycleview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)

                    val posisi = this.findViewById<TextView>(R.id.txtPosisi)
                    val tinggi = this.findViewById<TextView>(R.id.txtTinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txtTempatLahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggalLahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }

        })
    }
}