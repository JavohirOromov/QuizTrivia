import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quizmvp.R
import com.example.quizmvp.databinding.FragmentInfoBinding

/**
 * Creator: Javohir Oromov
 * Project: Quiz Trivia
 * Date: 29/03/25
 * Javohir's MacBook Air
 */
class InfoFragment: Fragment(R.layout.fragment_info) {

    private val binding: FragmentInfoBinding by viewBinding(FragmentInfoBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}