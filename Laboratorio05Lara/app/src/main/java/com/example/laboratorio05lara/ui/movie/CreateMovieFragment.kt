package com.example.laboratorio05lara.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05lara.R
import com.example.laboratorio05lara.data.ViewModels.MovieModel
import com.google.android.material.textfield.TextInputEditText

class CreateMovieFragment : Fragment() {
    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    private lateinit var name: TextInputEditText
    private lateinit var category: TextInputEditText
    private lateinit var description: TextInputEditText
    private lateinit var calification: TextInputEditText
    private lateinit var action: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)

        action.setOnClickListener{
            createMovie()
        }
    }

    private fun bind(view: View){
        name = view.findViewById(R.id.textInput_name)
        category = view.findViewById(R.id.textInput_category)
        description = view.findViewById(R.id.textInput_description)
        calification = view.findViewById(R.id.textInput_calification)
        action = view.findViewById(R.id.button_submit)
    }

    private fun createMovie(){
        val newMoview = MovieModel(
            name.toString(),
            category.toString(),
            description.toString(),
            calification.toString()
        )
        viewModel.addMovies(newMoview)

        Log.d("APP TAG", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }
}