package com.example.quizmvp.screen.test
import com.example.quizmvp.model.QuestionData
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class TestModel: TestContract.Model {
    private val repository = AppRepository.getInstance()

    override fun getQuestions(count: Int, id: Int): List<QuestionData> {
        return repository.getTests(count,id)
    }

    override fun saveUserResult(correctCount: Int, wrongCount: Int) {
        repository.correctCount = correctCount
        repository.wrongCount = wrongCount
    }
}