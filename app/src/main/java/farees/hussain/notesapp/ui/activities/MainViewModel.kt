package farees.hussain.notesapp.ui.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import farees.hussain.notesapp.database.Note
import farees.hussain.notesapp.repository.NoteRepository
import kotlinx.coroutines.launch

class MainViewModel (
    val noteRepository: NoteRepository
): ViewModel() {

    fun addNote(note:Note) = viewModelScope.launch {
        noteRepository.addNote(note)
    }
    fun getallNotes() = noteRepository.getNotes()
    fun deleteNote(note: Note) = viewModelScope.launch {
        noteRepository.deleteNote(note)
    }
    fun updateNote(note : Note) = viewModelScope.launch {
        noteRepository.updateNote(note)
    }


}