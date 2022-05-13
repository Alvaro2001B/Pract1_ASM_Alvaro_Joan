package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE UserId IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE Nom LIKE :first AND " +
            "Cognoms LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insert(vararg users: User)

    @Delete
    fun delete(user: User)

    @Query ("DELETE FROM user")
    fun deleteAll()
}