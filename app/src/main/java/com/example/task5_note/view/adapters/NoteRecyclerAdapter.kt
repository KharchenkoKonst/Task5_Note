package com.example.task5_note.view.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.task5_note.databinding.FragmentTitleBinding
import com.example.task5_note.databinding.RecyclerItemBinding
import com.example.task5_note.viewmodel.TitleNotesViewModel

class NoteRecyclerAdapter {

    inner class ViewHolder(private val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root)
    fun bind (viewModel: TitleNotesViewModel, position: Int){

    }

}