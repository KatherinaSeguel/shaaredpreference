package com.example.shaaredpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.fragment_first.*

private  const val SHARED_PREFERENCE_NAME="com.example.shaaredpreference"//PAso 1

private const val  USER_KEY = "USER_KEY"//1.1

class MainActivity : AppCompatActivity() {


    lateinit var mSharedPreference: SharedPreferences//Paso 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))


        mSharedPreference= getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)//Paso 3

//mSharedPreference.edit().putString("key","katherinaseguel@gmail.com").commit()//escribe directsmente en la carretera principal
        mSharedPreference.edit().putString(USER_KEY ,"prueba de otra forma").apply()//son 2 modos de hacer,se va por la berma.
        mSharedPreference.edit().putString(USER_KEY ,"katherinaseguel@gmail.com").apply()//actualicé

        mSharedPreference.edit().clear().apply()// elimina todos los datos de la SHARED debe ir aplay

        mSharedPreference.edit().remove(USER_KEY).apply()//elimna por key. siempre lleva el apply
//lee el sharedpre
        val user=mSharedPreference.getString(USER_KEY,"No encontrado")//si no encuentra el archivo lo reemplaza por lo escrito

        Log.d("TEST", user.toString())

        //textview_first.text=user//se traspasan datos

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}