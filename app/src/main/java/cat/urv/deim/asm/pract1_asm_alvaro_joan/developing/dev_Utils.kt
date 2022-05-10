package cat.urv.deim.asm.pract1_asm_alvaro_joan.developing

import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.User
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.UserDao
import java.util.concurrent.Executors

class dev_Utils {
    companion object{

    fun insertUser(userDao: UserDao,user: User){
        Executors.newSingleThreadExecutor().execute(Runnable {
            userDao.insert()
        })
    }

    }

}