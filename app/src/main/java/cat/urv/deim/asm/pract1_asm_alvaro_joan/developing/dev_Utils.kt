package cat.urv.deim.asm.pract1_asm_alvaro_joan.developing

import android.util.Log
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.*
import java.util.*
import java.util.concurrent.Executors

class dev_Utils {
    companion object {
        lateinit var userDao: UserDao
        lateinit var scooterDao: ScooterDao
        lateinit var rentDao: RentDao
        var userList: List<User> = emptyList()
        var scooterList: List<Scooter> = emptyList()

        fun initDaos(userDao: UserDao, scooterDao: ScooterDao, rentDao: RentDao) {
            this.userDao = userDao
            this.scooterDao = scooterDao
            this.rentDao = rentDao
            getUsers()
        }

        fun insertUser(user: User) {
            Executors.newSingleThreadExecutor().execute(Runnable {
                userDao.insert(user)
            })
        }

        fun insertScooter(scooter: Scooter) {
            Executors.newSingleThreadExecutor().execute(Runnable {
                scooterDao.insert(scooter)
            })
        }


        fun getUsers() {
            Executors.newSingleThreadExecutor().execute(Runnable {
                userList = userDao.getAll()

            })
            fun getUsers() {
                Executors.newSingleThreadExecutor().execute(Runnable {
                    scooterList = scooterDao.getAll()

                })
        }

    }
  }
}