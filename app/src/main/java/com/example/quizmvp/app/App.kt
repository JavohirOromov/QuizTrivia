package com.example.quizmvp.app
import LocalStorage
import android.app.Application
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        AppRepository.init()
        LocalStorage.init(this)
    }
}