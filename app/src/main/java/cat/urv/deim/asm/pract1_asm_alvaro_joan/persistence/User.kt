package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.intellij.lang.annotations.Identifier

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "dni") val dni:String?,
    @ColumnInfo(name = "mail") val mail:String?,
    @ColumnInfo(name = "tel") val tel:String?,
    @ColumnInfo(name = "pass") val pass:String?,
    @ColumnInfo(name = "pass1") val pass1:String?
)
