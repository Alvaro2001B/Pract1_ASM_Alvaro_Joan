package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Taula_Rent")
data class Rent(
    @PrimaryKey(autoGenerate = true) val RentId: Int,
    @ColumnInfo(name = "ID Scooter") val IDScooter: Int?,
    @ColumnInfo(name = "Nom") val Nom: String?,
    @ColumnInfo(name = "Cognoms") val Cognoms: String?,
    @ColumnInfo(name = "Nivell de Bateria") val NivellBateria: String?,
)