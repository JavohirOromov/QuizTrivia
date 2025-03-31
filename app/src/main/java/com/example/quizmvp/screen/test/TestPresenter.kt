package com.example.quizmvp.screen.test
import LocalStorage
import android.os.CountDownTimer

import com.example.quizmvp.model.QuestionData
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class TestPresenter(private val view: TestContract.View): TestContract.Presenter {
    private val model: TestContract.Model = TestModel()
    private lateinit var data: List<QuestionData>
    private var currentIndex = 0
    private val totalQuestionCount = 10
    private var correctCount = 0
    private var wrongCount = 0
    private var userAnswer: String = ""
    private var timer: CountDownTimer? = null
    private var timeLeft = 30L
    private var categoryID = 0
    private val storage by lazy { LocalStorage.getInstance() }

    private fun loadData(id: Int) {
        data = model.getQuestions(totalQuestionCount, id)
        view.nextButtonDisabled()
        view.showTest(data[0])
        userAnswer = ""
        startTimer()
    }
    private fun startTimer(){
        timer?.cancel()
        timer = object: CountDownTimer(30000,1000){
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = millisUntilFinished / 1000
                view.updateTimer(timeLeft)
            }
            override fun onFinish() {
                if (userAnswer.isEmpty()){
                    view.showTimeOutDialog()
                }
            }
        }
        timer?.start()
    }
    override fun stopTimer(){
        timer?.cancel()
    }
    override fun selectUserAnswer(pos: Int, str: String) {
        view.optionClickableFalse()
        stopTimer()
        view.nextButtonEnabled()
        userAnswer = str
        if (data[currentIndex].answer == userAnswer){
            view.setOptionBackgroundTrue(pos)
        }else{
            var correctIndex = 0
            val variants = listOf(data[currentIndex].variant1,data[currentIndex].variant2,data[currentIndex].variant3,data[currentIndex].variant4)
            for (i in variants.indices){
                if (data[currentIndex].answer == variants[i]){
                    correctIndex = i
                    break
                }
            }
            view.setOptionBackgroundFalse(pos)
            view.setOptionBackgroundTrue(correctIndex)
        }
    }

    override fun clickNextButton() {
        if (currentIndex == totalQuestionCount) return
        if (data[currentIndex].answer == userAnswer) {
            correctCount++
        } else {
            wrongCount++
        }
        currentIndex++
        if (currentIndex < totalQuestionCount) {
            view.nextButtonDisabled()
            view.showTestAnimation(data[currentIndex])
            view.setScore(currentIndex)
            view.clearOldState()
            view.optionClickableTrue()
            userAnswer = ""
            startTimer()
            val progress = (correctCount * 100) / totalQuestionCount
            storage.saveCorrectCont(categoryID.toString(),progress)
        } else {
            model.saveUserResult(correctCount, wrongCount)
            view.openResultScreen()
            val progress = (correctCount * 100) / totalQuestionCount
            storage.saveCorrectCont(categoryID.toString(),progress)
        }
    }

    override fun setExtraValue(id: Int) {
        categoryID = id
        loadData(id)
    }

    override fun clickDialogBtn() {
        view.openMenuScreen()
    }

    override fun clickShareBtn(question: String, options: List<CharSequence>) {
        view.shareQuestion(question,options)
    }

    override fun clickBackBtn() {
        view.showQuitDialog()
    }

    override fun clickQuitDialogBtn() {
        view.openMenuScreen()
    }
}