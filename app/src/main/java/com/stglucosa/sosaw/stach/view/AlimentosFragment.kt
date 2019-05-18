package com.stglucosa.sosaw.stach.view

import android.app.AliasActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.stglucosa.sosaw.stach.R
import kotlinx.android.synthetic.main.fragment_alimentacion.*

class AlimentosFragment : Fragment(){

    companion object {
        fun newInstance(): Fragment {
            return AlimentosFragment()
        }
    }

    /**
     * Método utilizado para escuchar click de los recyclers
     * @param item Elemento enviado por el recycler
     */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_alimentacion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDesayuno()
    }

    fun getDesayuno(): String = spineruno.selectedItem.toString()
    fun getComida(): String = spinerdos.selectedItem.toString()
    fun getCena(): String = spinertres.selectedItem.toString()

    fun setDesayuno() {
        val array = activity!!.resources.getStringArray(R.array.itm_desayuno)
        val adapter = SpinnerAdapter(array)
        spineruno.adapter = adapter
    }


}