package farees.hussain.notesapp.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note):Long

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllnotes():LiveData<List<Note>>

    @Update
    suspend fun update(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}