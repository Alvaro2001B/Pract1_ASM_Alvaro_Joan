package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.*

@Dao
interface ScooterDao {
    @Query("SELECT * FROM taula_scooters")
    fun getAll(): List<Scooter>

    @Insert(onConflict = OnConflictStrategy.IGNORE )
    fun insert(vararg scooters: Scooter)

    @Delete
    fun delete(scooter: Scooter)
}