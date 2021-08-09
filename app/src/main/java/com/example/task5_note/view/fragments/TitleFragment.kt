package com.example.task5_note.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.task5_note.R
import com.example.task5_note.databinding.FragmentTitleBinding
import com.example.task5_note.model.models.Note
import com.example.task5_note.repository.RepositoryImpl
import com.example.task5_note.utils.NOTE_DATA
import com.example.task5_note.view.activities.MainActivity
import com.example.task5_note.view.adapters.NoteRecyclerAdapter
import com.example.task5_note.viewmodel.TitleNotesViewModel
import com.example.task5_note.viewmodel.TitleNotesViewModelFactory

class TitleFragment : Fragment() {

    private val viewModelFactory: TitleNotesViewModelFactory by lazy {
        TitleNotesViewModelFactory(
            RepositoryImpl(requireContext())
        )
    }
    private val viewModel: TitleNotesViewModel by viewModels { viewModelFactory }
    private lateinit var binding: FragmentTitleBinding
    private lateinit var adapter: NoteRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        bindInit()
        subscribeToVM()

        return binding.root
    }

    private fun bindInit() {
        binding.lifecycleOwner = this
        binding.newNoteBtn.setOnClickListener {
            (requireActivity() as MainActivity).navController.navigate(R.id.action_titleFragment_to_noteContentFragment)
        }

        adapter = NoteRecyclerAdapter(requireContext()) { note ->
            openNote(note)
        }
        binding.recycler.adapter = adapter
    }

    private fun subscribeToVM() {
        viewModel.getAllNotes().observe(viewLifecycleOwner, { notes ->
            adapter.setData(notes)
        })
    }

    private fun openNote(note: Note) {
        val bundle = Bundle().apply { putParcelable(NOTE_DATA, note) }
        (requireActivity() as MainActivity).navController.navigate(
            R.id.action_titleFragment_to_noteContentFragment,
            bundle
        )
    }

}