package com.stglucosa.sosaw.stach.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stglucosa.sosaw.stach.R
import kotlinx.android.synthetic.main.fragment_alimentacion.*


class MedicamentosFragment : Fragment() {



    companion object {
        fun newInstance(): Fragment {
            return MedicamentosFragment()
        }
    }

    /**
     * Método utilizado para escuchar click de los recyclers
     * @param item Elemento enviado por el recycler
     */


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_medicamento, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}

