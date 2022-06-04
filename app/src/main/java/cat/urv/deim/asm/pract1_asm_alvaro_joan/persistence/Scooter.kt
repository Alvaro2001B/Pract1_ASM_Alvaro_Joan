package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (tableName = "Taula_Scooters")
data class Scooter(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name = "Name") val name: String?,
    @ColumnInfo(name = "Longitud") val longitude: String?,
    @ColumnInfo(name = "Latitud") val latitude: String?,
    @ColumnInfo(name = "Nivell de bateria") val battery_level: String?,
    @ColumnInfo(name = "Km recorreguts") val km_use: String?,
    @ColumnInfo(name = "Darrera Data De Manteniment") val date_last_maintenance: String?,
    @ColumnInfo(name = "Estat") val state: String?
)