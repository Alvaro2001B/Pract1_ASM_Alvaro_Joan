package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Identifier

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val UserId: Int,
    @ColumnInfo(name = "Nom") val Nom: String?,
    @ColumnInfo(name = "Cognoms") val Cognoms: String?,
    @ColumnInfo(name = "Correu") val Correu:String?,
    @ColumnInfo(name = "Telèfon") val Telèfon:Int?,
    @ColumnInfo(name = "DNI") val DNI:String?,
    @ColumnInfo(name = "Km Recorreguts") val KmRecorreguts:Double?,
)
