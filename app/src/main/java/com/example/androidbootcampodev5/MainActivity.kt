package com.example.androidbootcampodev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidbootcampodev5.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)

        var sonuc = ""
        var toplam : Long = 0
        var operatorKullanildi = false

        tasarim.buttonBir.setOnClickListener   {
            sonuc+="1"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonIki.setOnClickListener   {
            sonuc += "2"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonUc.setOnClickListener    {
            sonuc += "3"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonDort.setOnClickListener  {
            sonuc += "4"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonBes.setOnClickListener   {
            sonuc += "5"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonAlti.setOnClickListener  {
            sonuc += "6"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonYedi.setOnClickListener  {
            sonuc += "7"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonSekiz.setOnClickListener {
            sonuc += "8"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonDokuz.setOnClickListener {
            sonuc += "9"
            tasarim.textView.text = sonuc
            operatorKullanildi = false
        }
        tasarim.buttonSifir.setOnClickListener {
            if (tasarim.textView.text == "0"){
                tasarim.textView.text = "0"
            }else{
                sonuc += "0"
                tasarim.textView.text = sonuc
            }
            operatorKullanildi = false
        }
        tasarim.buttonSil.setOnClickListener{
            tasarim.textView.text = "0"
            sonuc = ""
            toplam = 0
            operatorKullanildi = false
        }

        tasarim.buttonTopla.setOnClickListener {


                var operator = sonuc.split(" ")
                Log.e("topla","operator: $operator")
                if (sonuc == ""){
                    Snackbar.make(it,"Bir Sayı Giriniz Ardından Operatöre Basınız!",Snackbar.LENGTH_SHORT).show()
                }
                else if (!operatorKullanildi){
                    sonuc += "+"
                    tasarim.textView.text =sonuc
                    try {
                        var topla = sonuc.split("+")
                        for (t in topla){
                            if (t != "")
                                toplam += t.toLong()
                        }
                        sonuc = "$toplam+"
                        tasarim.textView.text = sonuc
                        operatorKullanildi = true
                    }catch (e : Exception){
                        Snackbar.make(it,"Görünüşe Bakılırsa Bir HATA Var : Sayı Sınırlarını Zorlamayalım :D",Snackbar.LENGTH_SHORT).show()
                    }
                }
                else if (operatorKullanildi){
                    Snackbar.make(it,"Bir Sayı Giriniz Ardından Operatöre Basınız!",Snackbar.LENGTH_SHORT).show()
                }

        }

        tasarim.buttonEsittir.setOnClickListener {

            try {
                var topla = sonuc.split("+")
                for (t in topla){
                    if (t != "")
                        toplam += t.toLong()
                }
                tasarim.textView.text = toplam.toString()
                sonuc = "$toplam+"
            }catch (e : Exception){
                Snackbar.make(it,"Görünüşe Bakılırsa Bir HATA Var : Sayı Sınırlarını Zorlamayalım :D",Snackbar.LENGTH_SHORT).show()
            }

        }
        setContentView(tasarim.root)
    }
}