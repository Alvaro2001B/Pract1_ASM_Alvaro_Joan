package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Taula_Scooters")
data class Scooter(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name = "Longitud") val longitude: Double?,
    @ColumnInfo(name = "Latitud") val latitude: Double?,
    @ColumnInfo(name = "Nivell de bateria") val battery_level: Int?,
    @ColumnInfo(name = "Km recorreguts") val km_use: Double?,
    @ColumnInfo(name = "Darrera Data De Manteniment") val date_last_maintenance: String?,
    @ColumnInfo(name = "Estat") val state: String?
)