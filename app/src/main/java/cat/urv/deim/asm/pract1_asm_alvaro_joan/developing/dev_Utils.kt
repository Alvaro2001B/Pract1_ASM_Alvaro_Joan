package cat.urv.deim.asm.pract1_asm_alvaro_joan.developing

import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.*
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.ScooterParser
import cat.urv.deim.asm.pract1_asm_alvaro_joan.ui.patinetes.model.Scooters
import java.util.concurrent.Executors

class dev_Utils {
    companion object {
        lateinit var userDao: UserDao
        lateinit var scooterDao: ScooterDao
        lateinit var rentDao: RentDao
        var userList: List<User> = emptyList()
        var scooterList: List<Scooter> = emptyList()
        var rentList:List<Rent> = emptyList()

        fun initDaos(userDao: UserDao, scooterDao: ScooterDao, rentDao: RentDao) {
            this.userDao = userDao
            this.scooterDao = scooterDao
            this.rentDao = rentDao
            val scooter:Scooters=ScooterParser.parseFromJson("scooters.json")

            for(scooterP in scooter.scooters){
                var scooter:Scooter= Scooter(scooterP.uuid,scooterP.name,scooterP.longitude.toString(),scooterP.latitude.toString(),scooterP.battery_level.toString(),scooterP.km_use.toString(),scooterP.date_last_maintenance,scooterP.state)
                insertScooter(scooter)
            }
            getUsers()
            getScooter()
            getRent()
        }

        fun insertUser(user: User) {
            Executors.newSingleThreadExecutor().execute(Runnable {
                userDao.insert(user)
            })
        }
        fun insertRent(rent: Rent) {
            Executors.newSingleThreadExecutor().execute(Runnable {
                rentDao.insert(rent)
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

        }
        fun getScooter() {
            Executors.newSingleThreadExecutor().execute(Runnable {
                scooterList = scooterDao.getAll()

            })
        }
        fun getRent() {
            Executors.newSingleThreadExecutor().execute(Runnable {
                rentList = rentDao.getAll()

            })
        }

        fun deleteAll() {
            Executors.newSingleThreadExecutor().execute(Runnable {
                rentDao.deleteAll()
                userDao.deleteAll()
                scooterDao.deleteAll()
            })
        }
        fun deleteRent(rent: Rent) {
            Executors.newSingleThreadExecutor().execute(Runnable {
                    rentDao.delete(rent)

            })
        }
  }
}