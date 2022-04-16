package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.repositories

import android.content.Context
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.base.AppConfig
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooter
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.ScooterParser
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters


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
                scooters = ScooterParser.parseFromJson(jsonResource!!)
            }
            return scooters
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
                scooter = Scooter(uuid = it, name = it, longitud = it.toDouble(), latitud = it.toDouble(), nivel_bateria = it.toInt(), km_recorreguts = it.toDouble(), año = it.toInt(), mes = it.toInt(), dia = it.toInt(),estat=it)
                scooters.scooters.add(scooter)
            }

            return scooters
        }
    }
}