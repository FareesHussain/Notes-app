package farees.hussain.notesapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import farees.hussain.notesapp.R
import farees.hussain.notesapp.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {

    private lateinit var binding : FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_note,container,false)



        return binding.root
    }

}