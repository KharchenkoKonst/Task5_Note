package com.example.task5_note.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.task5_note.R
import com.example.task5_note.databinding.FragmentNoteContentBinding
import com.example.task5_note.repository.RepositoryImpl
import com.example.task5_note.utils.NOTE_DATA
import com.example.task5_note.viewmodel.NoteContentViewModel
import com.example.task5_note.viewmodel.NoteContentViewModelFactory

class NoteContentFragment : Fragment() {

    private val contentViewModelFactory: NoteContentViewModelFactory by lazy {
        NoteContentViewModelFactory(
            RepositoryImpl(requireContext()), arguments?.getParcelable(NOTE_DATA)
        )
    }
    private val viewModel: NoteContentViewModel by viewModels {
        contentViewModelFactory
    }
    private lateinit var binding: FragmentNoteContentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_note_content, container, false)
        binding.viewModel = viewModel
        binding.saveNoteBtn.setOnClickListener {
            viewModel.saveNote()
        }
        subscribeToVM()
        return binding.root
    }

    private fun subscribeToVM() {
        viewModel.onErrorSaveNote.observe(viewLifecycleOwner, {
            Toast.makeText(
                requireContext(),
                getString(R.string.empty_note_toast),
                Toast.LENGTH_LONG
            ).show()
        })
        viewModel.onSaveNoteSuccessful.observe(viewLifecycleOwner, {
            Toast.makeText(
                requireContext(),
                getString(R.string.empty_note_toast),
                Toast.LENGTH_LONG
            ).show()
        })
    }
}
