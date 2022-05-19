package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Taula_Scooters")
data class Scooter(
    @PrimaryKey val ScooterID: String,
    @ColumnInfo(name = "Longitud") val Longitud: Double?,
    @ColumnInfo(name = "Latitud") val Latitud: Double?,
    @ColumnInfo(name = "Nivell de bateria") val NivellBateria: Int?,
    @ColumnInfo(name = "Km recorreguts") val KmRecorreguts: Double?,
    @ColumnInfo(name = "Darrera Data De Manteniment") val DarrerManteniment: String?,
    @ColumnInfo(name = "Estat") val Estat: String?
)