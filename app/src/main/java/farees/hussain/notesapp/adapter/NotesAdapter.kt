package farees.hussain.notesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import farees.hussain.notesapp.R
import farees.hussain.notesapp.database.Note
import farees.hussain.notesapp.ui.fragments.HomeFragmentDirections
import kotlinx.android.synthetic.main.note_item.view.*

class NotesAdapter(val notes:List<Note>): RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.note_item,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.view.tvTitle.text = notes[position].title
        holder.view.tvDescription.text = notes[position].note

        holder.view.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToNoteFragment(notes[position]))
        }
    }

    inner class NotesViewHolder(val view:View): RecyclerView.ViewHolder(view)


}