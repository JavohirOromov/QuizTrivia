import android.content.Context
import android.content.SharedPreferences

/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 24/03/25
 * Javohir's MacBook Air
 */
class LocalStorage private constructor(context: Context){
    private val preferences: SharedPreferences = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = preferences.edit()

    companion object{
        private lateinit var instance: LocalStorage
        private const val FILE_NAME = "Javohir's quiz"

        fun init(context: Context){
            if (!(::instance.isInitialized)){
                instance = LocalStorage(context)
            }
        }
        fun getInstance(): LocalStorage{
            return instance
        }
    }
    fun saveCorrectCont(categoryID: String,count: Int){
        editor.putInt(categoryID,count).apply()
    }
    fun getCorrectCount(categoryID: String): Int{
        return preferences.getInt(categoryID,0)
    }
}