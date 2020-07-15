package farees.hussain.notesapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import farees.hussain.notesapp.R
import farees.hussain.notesapp.adapter.NotesAdapter
import farees.hussain.notesapp.databinding.FragmentHomeBinding
import farees.hussain.notesapp.ui.activities.MainActivity
import farees.hussain.notesapp.ui.activities.MainViewModel


class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private lateinit var viewModel : MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        viewModel = (activity as MainActivity).viewModel
        binding.fab.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToNoteFragment())
        }
        binding.rvSavedNotes.setHasFixedSize(true)
        binding.rvSavedNotes.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        viewModel.getallNotes().observe(viewLifecycleOwner, Observer { notes->
            Log.i("note","recently added note is ${notes.size}")
            binding.rvSavedNotes.adapter = NotesAdapter(notes)
        })

        return binding.root
    }

}