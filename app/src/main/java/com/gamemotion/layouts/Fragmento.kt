package com.gamemotion.layouts

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragmento.*

//Constantes para guardar el ID de los parámetros que vamos a recibir en el Fragment
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class Fragmento : Fragment() {

    //Variables en las que vamos a recibir los parámetros
    var param1: String? = null
    var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_fragmento, container, false)
    }

    //Estado del Fragment en el cuál está activo
    override fun onResume() {
        super.onResume()

        texto1.setText(param1)
        texto2.setText(param2)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            Fragmento().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}