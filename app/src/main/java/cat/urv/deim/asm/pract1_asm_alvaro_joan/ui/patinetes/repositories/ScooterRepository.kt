package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import cat.urv.deim.asm.pract1_asm_alvaro_joan.developing.dev_Utils
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.Scooter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.ScooterDao
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.base.AppConfig
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.ScooterParser
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.util.*


class ScooterRepository {
    companion object {

        fun activeScooterList(context: Context, resource: String): List<Scooter> {
            val scooters: Scooters = ScooterRepository.activeScooters(context, resource)
            return scooters.scooters
        }

        fun activeScooters(context: Context, resource: String): Scooters {
            val scooters: Scooters
            val jsonResource: String? = AssetsProvider.getJsonDataFromRawAsset(context, resource)
            jsonResource.let {
                scooters = ScooterParser.parseFromJson(context)
            }
            return scooters
        }
        fun getAllScooters(context: Context, scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.getAll()
        }

        fun deleteAllScooters(context: Context,  scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {
            return@async scooterDao.deleteAll()
        }

        fun insertScooters(context: Context,  scooterDao: ScooterDao) = CoroutineScope(Dispatchers.Default).async {

            val scooter:Scooters=ScooterParser.parseFromJson(context)

            for(scooterP in scooter.scooters){
                var scooter = Scooter(scooterP.uuid,scooterP.name,scooterP.longitude.toString(),scooterP.latitude.toString(),scooterP.battery_level.toString(),scooterP.km_use.toString(),scooterP.date_last_maintenance,scooterP.state,scooterP.on_rent)
                dev_Utils.insertScooter(scooter)
            }
            return@async true
        }

        fun activeScooters(context: Context): Scooters {
            val resource: String = AppConfig.DEFAULT_SCOOTER_RAW_JSON_FILE
            return ScooterRepository.activeScooters(context, resource)
        }

        fun activeScooters(): Scooters {
            val scooters: Scooters = Scooters()
            val uuidList: Array<String> =AppConfig.DEFAULT_SCOOTERS_ID_ARRAY
            var scooter: Scooter
            uuidList.forEach {
                scooter = Scooter(uuid = it, name = it, longitude = it, latitude = it, battery_level = it, km_use = it, date_last_maintenance=it,state=it,on_rent=it)
                scooters.scooters.add(scooter)
            }

            return scooters
        }
    }
}