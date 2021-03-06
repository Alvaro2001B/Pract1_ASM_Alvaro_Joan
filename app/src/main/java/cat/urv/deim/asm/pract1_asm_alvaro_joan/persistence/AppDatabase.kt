package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [User::class,Scooter::class,Rent::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun scooterDao(): ScooterDao
    abstract fun RentDao(): RentDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        public fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }


        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "ASM_db.db")
                .build()
    }
}