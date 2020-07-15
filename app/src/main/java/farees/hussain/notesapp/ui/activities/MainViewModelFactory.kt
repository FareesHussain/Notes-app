package farees.hussain.notesapp.ui.activities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import farees.hussain.notesapp.repository.NoteRepository

class MainViewModelFactory(
    val noteRepository: NoteRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(noteRepository) as T
    }
}