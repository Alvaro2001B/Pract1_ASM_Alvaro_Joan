package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model


import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.AppDatabase
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.Scooter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.UserDao
import kotlinx.coroutines.withContext
import java.time.Year
import java.util.*

class Scooter(val uuid: String, val name: String,val longitude: Double,val latitude: Double,val battery_level:Int,val km_use : Double,val date_last_maintenance: String, val state :String,val on_rent:String) {

}
