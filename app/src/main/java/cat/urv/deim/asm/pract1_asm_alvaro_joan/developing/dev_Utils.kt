package cat.urv.deim.asm.pract1_asm_alvaro_joan.developing

import android.util.Log
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.User
import cat.urv.deim.asm.pract1_asm_alvaro_joan.persistence.UserDao
import java.util.*
import java.util.concurrent.Executors

class dev_Utils {
    companion object{

    fun insertUser(userDao: UserDao,user: User){
        Executors.newSingleThreadExecutor().execute(Runnable {
            userDao.insert(user)
        })
    }
        fun getUsers(userDao: UserDao) {
            var users: List<User> = LinkedList<User>()

            Executors.newSingleThreadExecutor().execute(Runnable {
                users = userDao.getAll()
                for (user in users) {
                    Log.d(
                        dev_Utils::class.java.simpleName,
                        "User: (%d) %s %s".format(user.uid, user.firstName, user.lastName)
                    )
                }
            })
        }
    }

}