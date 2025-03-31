import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.example.quizmvp.R
import com.example.quizmvp.databinding.DialogQuitBinding
/**
 * Creator: Javohir Oromov
 * Project: Quiz Trivia
 * Date: 29/03/25
 * Javohir's MacBook Air
 */
class QuitDialog(context: Context): AlertDialog(context) {


    private val binding: DialogQuitBinding = DialogQuitBinding.inflate(LayoutInflater.from(context))

    private var btnClickListener: (() -> Unit)? = null

    fun setBtnClickListener(btnClickListener: () -> Unit){
        this.btnClickListener = btnClickListener
    }

    init {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.attributes?.windowAnimations = R.style.CustomDialogAnim
        setCancelable(false)
        setView(binding.root)

        binding.quit.setOnClickListener {
            dismiss()
        }
        binding.btn.setOnClickListener {
            btnClickListener?.invoke()
            dismiss()
        }
    }
}