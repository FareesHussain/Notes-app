package farees.hussain.notesapp.repository

import farees.hussain.notesapp.database.Note
import farees.hussain.notesapp.database.NoteDatabase

class NoteRepository(
    val db:NoteDatabase
) {

    suspend fun addNote(note:Note) = db.getNoteDao().insert(note)
    fun getNotes() = db.getNoteDao().getAllnotes()
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().update(note)

}