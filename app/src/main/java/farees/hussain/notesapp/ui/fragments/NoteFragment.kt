package farees.hussain.notesapp.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import farees.hussain.notesapp.R
import farees.hussain.notesapp.database.Note
import farees.hussain.notesapp.databinding.FragmentNoteBinding
import farees.hussain.notesapp.ui.activities.MainActivity
import farees.hussain.notesapp.ui.activities.MainViewModel
import kotlinx.android.synthetic.main.fragment_note.*

class NoteFragment : Fragment() {
    private lateinit var binding : FragmentNoteBinding
    private lateinit var viewModel : MainViewModel
    var note:Note ?= null
    val args : NoteFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_note,container,false)
        viewModel = (activity as MainActivity).viewModel
        var shouldUpdate = false
        note = args.updateNote
        requireActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setHasOptionsMenu(true)
        if(note!=null){
            binding.etTitletext.setText(note!!.title)
            binding.etNotes.setText(note!!.note)
            shouldUpdate = true
        }
        binding.fab.setOnClickListener {
            if(etTitletext.text.toString().isEmpty()){
                etTitletext.error = "add a title"
                etTitletext.requestFocus()
                return@setOnClickListener
            }
            if(etNotes.text.toString().isEmpty()){
                etNotes.error = "add a note"
                etNotes.requestFocus()
                return@setOnClickListener
            }
            if(shouldUpdate){
                update()
            }else{
                insert()
            }
            findNavController().popBackStack()
        }
        return binding.root
    }
    fun insert(){
        var note:Note = Note(etTitletext.text.toString(),etNotes.text.toString())
        viewModel.addNote(note)
    }
    fun update(){
        var note:Note = Note(etTitletext.text.toString(),etNotes.text.toString())
        viewModel.deleteNote(this.note!!)
        viewModel.addNote(note)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        if(note!=null)
            inflater.inflate(R.menu.delete_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_note -> {
                viewModel.deleteNote(note!!)
                findNavController().popBackStack()
            }
        }
        return false
    }
}