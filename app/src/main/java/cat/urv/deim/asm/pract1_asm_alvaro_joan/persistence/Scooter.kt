package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (tableName = "Taula_Scooters")
data class Scooter(
    @PrimaryKey val uuid: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "longitude") val longitude: String?,
    @ColumnInfo(name = "latitude") val latitude: String?,
    @ColumnInfo(name = "battery_level") val battery_level: String?,
    @ColumnInfo(name = "km_use") val km_use: String?,
    @ColumnInfo(name = "date_last_maintenance") val date_last_maintenance: String?,
    @ColumnInfo(name = "state") val state: String?,
    @ColumnInfo(name = "on_rent") val on_rent: String?
)