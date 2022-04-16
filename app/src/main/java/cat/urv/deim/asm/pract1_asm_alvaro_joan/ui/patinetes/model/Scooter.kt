package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model

import android.provider.ContactsContract
import java.time.Year
import java.util.*

class Scooter(val name: String, val uuid: String,val longitud: Double,val latitud: Double,val nivel_bateria:Int,val km_recorreguts : Double,val año:Int,val mes: Int,val dia:Int, val estat :String) {
    val data_manteniment = Date(año, mes, dia)
 }
