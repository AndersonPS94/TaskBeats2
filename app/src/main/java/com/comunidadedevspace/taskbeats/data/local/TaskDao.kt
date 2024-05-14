package com.comunidadedevspace.taskbeats.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Query("Select * from task")
    fun getAll(): LiveData<List<Task>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(task: Task)

    //Delete encontrar por ID
    @Query("DELETE from task")
    suspend fun deleteAll()

    //Deletando pelo ID
    @Query("Delete from task where id =:id")
    suspend fun deleteById(id: Int)
}