package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RentDao {

    @Query("SELECT * FROM taula_rent")
    fun getAll(): List<Scooter>

    @Insert
    fun insertAll(vararg scooters: Scooter)

    @Delete
    fun delete(scooter: Scooter)
}