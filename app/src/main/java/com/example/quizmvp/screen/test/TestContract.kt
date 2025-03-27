import com.example.quizmvp.model.QuestionData
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
interface TestContract {

    interface Model{
        fun getQuestions(count: Int, id: Int): List<QuestionData>
        fun saveUserResult(correctCount: Int, wrongCount: Int)
    }
    interface View{
        fun showTestAnimation(data: QuestionData)
        fun showTest(data: QuestionData)
        fun nextButtonEnabled()
        fun nextButtonDisabled()
        fun openResultScreen()
        fun setOptionBackgroundTrue(pos: Int)
        fun setOptionBackgroundFalse(pos: Int)
        fun setScore(score: Int)
        fun clearOldState()
        fun updateTimer(timeLeft: Long)
        fun showTimeOutDialog()
        fun openMenuScreen()
        fun shareQuestion(question: String, options: List<CharSequence>)
        fun optionClickableFalse()
        fun optionClickableTrue()

    }
    interface Presenter{
        fun selectUserAnswer(pos: Int, str: String)
        fun clickNextButton()
        fun setExtraValue(id: Int)
        fun stopTimer()
        fun clickDialogBtn()
        fun clickShareBtn(question: String, options: List<CharSequence>)
    }
}