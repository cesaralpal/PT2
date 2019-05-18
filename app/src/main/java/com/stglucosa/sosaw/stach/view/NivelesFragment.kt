package com.stglucosa.sosaw.stach.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stglucosa.sosaw.stach.R


class NivelesFragment : Fragment() {



    companion object {
        fun newInstance(): Fragment {
            return NivelesFragment()
        }
    }

    /**
     * Método utilizado para escuchar click de los recyclers
     * @param item Elemento enviado por el recycler
     */


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_niveles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)


    }}

