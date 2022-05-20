package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Taula_Rent")
data class Rent(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "DNI") val DNI: String?,
    @ColumnInfo(name = "IDScooter") val IDScooter: String?,
)