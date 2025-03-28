import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.quizmvp.R
import com.example.quizmvp.databinding.DialogTimeBinding
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class TimeOutDialog(context: Context): AlertDialog(context) {
    private val binding: DialogTimeBinding = DialogTimeBinding.inflate(LayoutInflater.from(context))

    private var btnClickListener: (() -> Unit)? = null
    fun setBtnClickListener(btnClickListener: () -> Unit){
        this.btnClickListener = btnClickListener
    }

    init {
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        window?.attributes?.windowAnimations = R.style.CustomDialogAnim
        setCancelable(false)
        setView(binding.root)

        binding.btn.setOnClickListener {
            btnClickListener?.invoke()
            dismiss()
        }
    }
}