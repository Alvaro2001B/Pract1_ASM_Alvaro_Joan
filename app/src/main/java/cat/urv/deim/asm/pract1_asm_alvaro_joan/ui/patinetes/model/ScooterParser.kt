package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model
import com.google.gson.Gson

class ScooterParser {
    companion object{
        fun parseFromJson( json: String):Scooters{
            val gson: Gson = Gson()

            var scooters: Scooters
            json.let {
                scooters = gson.fromJson<Scooters>(json, Scooters::class.java)
            }
            return scooters
        }
    }
}