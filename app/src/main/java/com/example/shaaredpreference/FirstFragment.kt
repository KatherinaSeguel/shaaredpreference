package com.example.shaaredpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

private  const val SHARED_PREFERENCE_NAME="com.example.shaaredpreference"//PAso 1

private const val  USER_KEY = "USER_KEY"//1.1


class FirstFragment : Fragment() {

    lateinit var mSharedPreference: SharedPreferences//Paso 2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //En los fragmentos hay que anteponerle al getSharedpreference activity. luego agregar ? y
        //luego botón rojo y que acepte los NULL
        mSharedPreference= activity?.getSharedPreferences(SHARED_PREFERENCE_NAME, Context.MODE_PRIVATE)!!//Paso 3

//mSharedPreference.edit().putString("key","katherinaseguel@gmail.com").commit()//escribe directsmente en la carretera principal
        mSharedPreference.edit().putString(USER_KEY ,"prueba de otra forma").apply()//son 2 modos de hacer,se va por la berma.
        mSharedPreference.edit().putString(USER_KEY ,"katherinaseguel@gmail.com").apply()//actualicé

        mSharedPreference.edit().clear().apply()// elimina todos los datos de la SHARED debe ir aplay

        mSharedPreference.edit().remove(USER_KEY).apply()//elimna por key. siempre lleva el apply
//lee el sharedpre
        val user=mSharedPreference.getString(USER_KEY,"No encontrado")//si no encuentra el archivo lo reemplaza por lo escrito

        Log.d("TEST", user.toString())

        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}