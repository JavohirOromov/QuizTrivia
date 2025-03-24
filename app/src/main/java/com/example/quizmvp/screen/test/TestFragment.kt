package com.example.quizmvp.screen.test
import TimeOutDialog
import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quizmvp.R
import com.example.quizmvp.databinding.FragmentTestBinding
import com.example.quizmvp.model.QuestionData
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class TestFragment: Fragment(R.layout.fragment_test), TestContract.View {
    private val binding: FragmentTestBinding by viewBinding(FragmentTestBinding::bind)
    private lateinit var presenter: TestContract.Presenter
    private lateinit var questionText: TextView
    private lateinit var lines: List<AppCompatButton>
    private lateinit var buttonNext: AppCompatButton
    private val args: TestFragmentArgs by navArgs()
    private var dialogTime: TimeOutDialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = TestPresenter(this)
        val id = args.id
        loadViews()
        addClickEvents()
        presenter.setExtraValue(id)
    }
    private fun loadViews() {
        dialogTime = TimeOutDialog(requireContext())
        questionText = binding.textQuestion
        buttonNext = binding.btnNext
        lines = listOf(binding.variant1, binding.variant2, binding.variant3, binding.variant4)
    }
    private fun addClickEvents() {
        buttonNext.setOnClickListener {
            presenter.clickNextButton()
        }

        lines.forEachIndexed { index, button ->
            button.setOnClickListener {
                val userAnswer = button.text.toString()
                presenter.selectUserAnswer(index, userAnswer)
            }
        }
        dialogTime?.setBtnClickListener {
            presenter.clickDialogBtn()
        }
        binding.btnShare.setOnClickListener {
            val questions = questionText.text
            val options = listOf(binding.variant1.text,binding.variant2.text,binding.variant3.text,binding.variant4.text)
            presenter.clickShareBtn(questions.toString(),options)
        }
    }

    override fun showTestAnimation(data: QuestionData) {
        val duration = 200L
        fun animateIn(index: Int) {
            if (index < 0) return
            val line = lines[index]
            val scaleUpX = ObjectAnimator.ofFloat(line, "scaleX", 1f)
            val scaleUpY = ObjectAnimator.ofFloat(line, "scaleY", 1f)
            val fadeIn = ObjectAnimator.ofFloat(line, "alpha", 1f)

            AnimatorSet().apply {
                playTogether(scaleUpX, scaleUpY, fadeIn)
                this.duration = duration
                addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        animateIn(index - 1)
                    }
                })
                start()
            }
        }
        fun animateQuestionIn() {
            val scaleUpX = ObjectAnimator.ofFloat(questionText, "scaleX", 1f)
            val scaleUpY = ObjectAnimator.ofFloat(questionText, "scaleY", 1f)
            val fadeIn = ObjectAnimator.ofFloat(questionText, "alpha", 1f)

            AnimatorSet().apply {
                playTogether(scaleUpX, scaleUpY, fadeIn)
                this.duration = duration
                start()
            }
        }
        fun animateOut(index: Int) {
            if (index >= lines.size) {
                val scaleDownX = ObjectAnimator.ofFloat(questionText, "scaleX", 0f)
                val scaleDownY = ObjectAnimator.ofFloat(questionText, "scaleY", 0f)
                val fadeOut = ObjectAnimator.ofFloat(questionText, "alpha", 0f)

                AnimatorSet().apply {
                    playTogether(scaleDownX, scaleDownY, fadeOut)
                    this.duration = duration
                    addListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator) {
                            questionText.text = data.question
                            lines[0].text = data.variant1
                            lines[1].text = data.variant2
                            lines[2].text = data.variant3
                            lines[3].text = data.variant4

                            animateIn(lines.size - 1)
                            animateQuestionIn()
                        }
                    })
                    start()
                }
                return
            }

            val line = lines[index]
            val scaleDownX = ObjectAnimator.ofFloat(line, "scaleX", 0f)
            val scaleDownY = ObjectAnimator.ofFloat(line, "scaleY", 0f)
            val fadeOut = ObjectAnimator.ofFloat(line, "alpha", 0f)

            AnimatorSet().apply {
                playTogether(scaleDownX, scaleDownY, fadeOut)
                this.duration = duration
                addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        animateOut(index + 1)
                    }
                })
                start()
            }
        }

        animateOut(0)
    }

    override fun showTest(data: QuestionData) {
        questionText.text = data.question
        lines[0].text = data.variant1
        lines[1].text = data.variant2
        lines[2].text = data.variant3
        lines[3].text = data.variant4
    }

    override fun nextButtonEnabled() {
        buttonNext.isEnabled = true
        buttonNext.setBackgroundResource(R.drawable.bg_next)
    }

    override fun nextButtonDisabled() {
        buttonNext.isEnabled = false
        buttonNext.setBackgroundResource(R.drawable.bg_disebl)
    }

    override fun openResultScreen() {
        findNavController().navigate(TestFragmentDirections.actionTestFragmentToResultFragment(args.id))
    }

    override fun setOptionBackgroundTrue(pos: Int) {
        lines[pos].setBackgroundResource(R.drawable.correct_answer)
    }

    override fun setOptionBackgroundFalse(pos: Int) {
        lines[pos].setBackgroundResource(R.drawable.wrong_answer)
    }

    override fun setScore(score: Int) {
        binding.score.text = "${score+1}/10"
    }
    override fun clearOldState() {
        for (i in lines.indices){
            lines[i].setBackgroundResource(R.drawable.bg_variant)
        }
    }

    override fun updateTimer(timeLeft: Long) {
        binding.timer.text = timeLeft.toString()
    }

    override fun showTimeOutDialog() {
        dialogTime?.show()
    }

    override fun openMenuScreen() {
        findNavController().navigate(TestFragmentDirections.actionTestFragmentToMenuFragment())
    }

    override fun shareQuestion(question: String, options: List<CharSequence>) {
        val optionsText = options.mapIndexed { index, option ->
            "🔹 ${'A' + index}) $option"
        }.joinToString("\n")

        val shareText = "❓ Savol: $question\n\n$optionsText"

        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText)
            type = "text/plain"
        }

        startActivity(Intent.createChooser(intent, "Savolni ulashing"))
    }
    override fun onDestroyView() {
        super.onDestroyView()
        presenter.stopTimer()
        dialogTime = null
    }
}