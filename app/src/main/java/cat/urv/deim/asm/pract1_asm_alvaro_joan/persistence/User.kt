package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Identifier
import java.util.*

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "Nom") val Nom: String?,
    @ColumnInfo(name = "Cognoms") val Cognoms: String?,
    @ColumnInfo(name = "Correu") val Correu:String?,
    @ColumnInfo(name = "Telèfon") val Telèfon:String?,
    @ColumnInfo(name = "DNI") val DNI:String?,
    @ColumnInfo(name = "Km Recorreguts") val KmRecorreguts:Double?,
    @ColumnInfo(name = "Contrasenya") val Contrasenya:String?
)
