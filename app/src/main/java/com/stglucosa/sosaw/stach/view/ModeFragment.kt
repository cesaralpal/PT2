package com.stglucosa.sosaw.stach.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stglucosa.sosaw.stach.R
import com.ederdoski.simpleble.utils.BluetoothLEHelper
import android.widget.Toast
import android.bluetooth.BluetoothGattCharacteristic
import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothProfile
import android.util.Log
import com.ederdoski.simpleble.interfaces.BleCallback
import java.util.*
import kotlinx.android.synthetic.main.fragment_modo.*
import android.support.v4.app.ActivityCompat.startActivityForResult
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import com.polidea.rxandroidble2.RxBleClient
import com.stglucosa.sosaw.stach.model.Contactos


class ModeFragment : Fragment() {

    var ble: BluetoothLEHelper? = null
    var contacto:Contactos? = null
    var callback = object : BleCallback() {

        override fun onBleConnectionStateChange(gatt: BluetoothGatt?, status: Int, newState: Int) {
            super.onBleConnectionStateChange(gatt, status, newState)

            if (newState == BluetoothProfile.STATE_CONNECTED) {
                activity!!.runOnUiThread {
                    Toast.makeText(activity, "Connected to GATT server.", Toast.LENGTH_SHORT).show()
                }
            }

            if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                activity!!.runOnUiThread {
                    Toast.makeText(activity, "Disconnected from GATT server.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onBleServiceDiscovered(gatt: BluetoothGatt?, status: Int) {
            super.onBleServiceDiscovered(gatt, status)
            if (status != BluetoothGatt.GATT_SUCCESS) {
                Log.e("Ble ServiceDiscovered", "onServicesDiscovered received: $status")
            }
        }

        override fun onBleCharacteristicChange(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?) {
            super.onBleCharacteristicChange(gatt, characteristic)
            Log.i("BluetoothLEHelper", "onCharacteristicChanged Value: " + Arrays.toString(characteristic!!.value))
        }

        override fun onBleRead(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int) {
            super.onBleRead(gatt, characteristic, status)

            if (status == BluetoothGatt.GATT_SUCCESS) {
                Log.i("TAG", Arrays.toString(characteristic!!.value))
                activity!!.runOnUiThread {
                    Toast.makeText(
                        activity,
                        "onCharacteristicRead : " + Arrays.toString(characteristic.value),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        override fun onBleWrite(gatt: BluetoothGatt?, characteristic: BluetoothGattCharacteristic?, status: Int) {
            super.onBleWrite(gatt, characteristic, status)
            activity!!.runOnUiThread {
                Toast.makeText(
                    activity,
                    "onCharacteristicWrite Status : $status",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        fun newInstance(): Fragment {
            return ModeFragment()
        }
    }

    /**
     * Método utilizado para escuchar click de los recyclers
     * @param item Elemento enviado por el recycler
     */


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_modo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rxBleClient = RxBleClient.create(activity!!)
        val enableBtIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
        val REQUEST_ENABLE_BT = 1
        activity!!.startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
        setData()
    }
fun setData(){
    btnScan.setOnClickListener {
        scann()
    }
    }


    fun savecontacts(){
        btnScan.setOnClickListener {
            contacto?.name = "Wendolyne Sosa"
            contacto?.tel = 12342144.toDouble()
            contacto?.flagKindContacta = true
        }

    }
    private fun scann(){
        ble = BluetoothLEHelper(activity)



        if (ble!!.isReadyForScan) {

            Log.d("listo", "estoy listo para escanear")

        }
        else             Log.d("listo", "no estoy listo")

    }

}