package com.example.quizmvp.screen.menu
import CategoryAdapter
import LocalStorage
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.quizmvp.R
import com.example.quizmvp.databinding.FragmentMenuBinding
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class MenuFragment: Fragment(R.layout.fragment_menu) {
    private val binding: FragmentMenuBinding by viewBinding(FragmentMenuBinding::bind)
    private val repository by lazy { AppRepository.getInstance() }
    private val adapter by lazy { CategoryAdapter() }
    private val storage by lazy { LocalStorage.getInstance() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        adapter.setItemClickListener {
            val actions = MenuFragmentDirections.actionMenuFragmentToTestFragment(it)
            findNavController().navigate(actions)
        }
        binding.info.setOnClickListener {
            findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToInfoFragment())
        }
    }
    private fun initAdapter(){
        binding.categoryList.adapter = adapter
        val updateList = repository.categoryList().map { category ->
            val progress = storage.getCorrectCount(category.id.toString())
            category.copy(progress = progress)
        }
        adapter.submitList(updateList)
    }
}