package cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model
import android.content.Context
import com.google.gson.Gson

class ScooterParser {
    companion object {
        fun parseFromJson(context : Context): Scooters {
            val gson: Gson = Gson()
            var json = context.getResources().openRawResource(
                context.resources.getIdentifier("scooters",
                    "raw", context.packageName)).bufferedReader().use { it.readText() }
            var scooters : Scooters
            json.let {
                scooters = gson.fromJson<Scooters>(json, Scooters::class.java)
            }
            return scooters
        }
    }
}