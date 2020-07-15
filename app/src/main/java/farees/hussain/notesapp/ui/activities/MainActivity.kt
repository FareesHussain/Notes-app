package farees.hussain.notesapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import farees.hussain.notesapp.R
import farees.hussain.notesapp.database.NoteDatabase
import farees.hussain.notesapp.databinding.ActivityMainBinding
import farees.hussain.notesapp.repository.NoteRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        val noteRepository = NoteRepository(NoteDatabase(this))
        val viewModelFactory = MainViewModelFactory(noteRepository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)


        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this,R.id.fragment),
            null
        )
    }

}