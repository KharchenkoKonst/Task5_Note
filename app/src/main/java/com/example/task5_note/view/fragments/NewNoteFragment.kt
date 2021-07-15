package com.example.task5_note.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.task5_note.R
import com.example.task5_note.databinding.FragmentNewNoteBinding
import com.example.task5_note.repository.RepositoryImpl
import com.example.task5_note.view.activities.MainActivity
import com.example.task5_note.viewmodel.NewNoteViewModel
import com.example.task5_note.viewmodel.NewNoteViewModelFactory

class NewNoteFragment : Fragment() {

    private val viewModelFactory: NewNoteViewModelFactory by lazy {
        NewNoteViewModelFactory(RepositoryImpl(requireContext()))
    }
    private val viewModel: NewNoteViewModel by viewModels {
        viewModelFactory
    }
    private lateinit var binding: FragmentNewNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_note, container, false)
        subscribeToVM()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.saveNoteBtn.setOnClickListener {
            viewModel.tryToSaveNote(
                binding.titleInputField.text.toString(),
                binding.contentInputField.text.toString()
            )
        }

    }

    private fun subscribeToVM() {
        viewModel.onAttemptSaveEmptyNote.observe(this, {
            Toast.makeText(requireContext(), "Заголовок или текст отсутствует", Toast.LENGTH_LONG)
                .show()
        })
        viewModel.onSaveSuccessEvent.observe(this, {
            (requireActivity() as MainActivity).navController.navigate(R.id.action_newNoteFragment_to_titleFragment)
        })
    }
}
