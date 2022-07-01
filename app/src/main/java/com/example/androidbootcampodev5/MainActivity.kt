package com.example.androidbootcampodev5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidbootcampodev5.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)

        var sonuc = ""
        var toplam = 0
        var operatorKullanildi = false

        val rakamlar = ArrayList<Int>()
        rakamlar.add(1)
        rakamlar.add(2)
        rakamlar.add(3)
        rakamlar.add(4)
        rakamlar.add(5)
        rakamlar.add(6)
        rakamlar.add(7)
        rakamlar.add(8)
        rakamlar.add(9)
        rakamlar.add(0)

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
                Snackbar.make(it,"Bir Sayı Giriniz ardından operatöre basınız!",Snackbar.LENGTH_SHORT).show()
            }else if (!operatorKullanildi){
                sonuc += "+"
                tasarim.textView.text =sonuc
                var topla = sonuc.split("+")
                //Log.e("topla","topla: $topla")
                for (t in topla){
                    Log.e("topla","t: $t")
                    if (t != "")
                        toplam += t.toInt()
                }
                //Log.e("topla","toplam: $toplam")
                sonuc = "$toplam+"
                tasarim.textView.text = sonuc
                operatorKullanildi = true
                Log.e("topla","sonuc: $sonuc")
            }else if (operatorKullanildi){
                Snackbar.make(it,"Bir Sayı Giriniz ardından operatöre basınız!",Snackbar.LENGTH_SHORT).show()

            }
        }

        tasarim.buttonEsittir.setOnClickListener {
            var topla = sonuc.split("+")
            Log.e("topla","topla: $topla")
            for (t in topla){
                Log.e("topla","t: $t")
                if (t != "")
                    toplam += t.toInt()
            }
            Log.e("topla","toplam: $toplam")
            tasarim.textView.text = toplam.toString()
            sonuc = ""
        }
        setContentView(tasarim.root)
    }
}