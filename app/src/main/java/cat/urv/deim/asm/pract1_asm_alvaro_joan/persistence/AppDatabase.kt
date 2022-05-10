package cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//TODO: add entity Scooter::class
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    //abstract fun scooterDao(): ScooterDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        public fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE user "
                        + " ADD COLUMN last_update INTEGER");
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                AppDatabase::class.java, "user_db.db")
                //.addMigrations(MIGRATION_1_2)
                .build()
    }
}