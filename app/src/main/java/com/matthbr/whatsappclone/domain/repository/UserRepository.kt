package com.matthbr.whatsappclone.domain.repository

import com.matthbr.whatsappclone.data.dao.UserDao
import com.matthbr.whatsappclone.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserRepository {
    suspend fun insertUser(user: User)
    suspend fun searchUsers(): List<User>
}

class UserRepositoryImpl(
    val userDao: UserDao
):UserRepository{
    override suspend fun insertUser(user: User) = withContext(Dispatchers.IO){
        userDao.insertUser(user)
    }

    override suspend fun searchUsers(): List<User> = withContext(Dispatchers.IO){
        userDao.getAllUsers()
    }

}
