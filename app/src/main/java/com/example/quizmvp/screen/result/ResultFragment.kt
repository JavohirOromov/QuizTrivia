package com.example.quizmvp.screen.result
import AppRepository
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quizmvp.R
import com.example.quizmvp.databinding.FragmentResultBinding
import com.example.quizmvp.screen.test.TestFragmentArgs

/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class ResultFragment: Fragment(R.layout.fragment_result) {

    private val binding: FragmentResultBinding by viewBinding(FragmentResultBinding::bind)
    private val repository by lazy { AppRepository.getInstance() }
    private val totalQuestionCount = 10
    private val args: TestFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadViews()
        initProgressBar()
        addClickEvents()
    }
    private fun addClickEvents(){
        binding.retry.setOnClickListener {
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToTestFragment(args.id))
        }
        binding.quit.setOnClickListener {
            findNavController().navigate(ResultFragmentDirections.actionResultFragmentToMenuFragment())
        }
    }
    private fun loadViews(){
        binding.allText.text = totalQuestionCount.toString()
        binding.correctText.text = repository.correctCount.toString()
        binding.wrongText.text = repository.wrongCount.toString()
    }
    private fun initProgressBar(){
        binding.progressView.setProgress(repository.correctCount,totalQuestionCount)
        val progress = (repository.correctCount * 100) / totalQuestionCount
        binding.progressText.text = "$progress%"
    }
}