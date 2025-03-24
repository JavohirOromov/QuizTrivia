import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizmvp.databinding.ItemCategoryBinding
import com.example.quizmvp.model.CategoryDate
/**
 * Creator: Javohir Oromov
 * Project: QuizMVP
 * Date: 23/03/25
 * Javohir's MacBook Air
 */
class CategoryAdapter: ListAdapter<CategoryDate, CategoryAdapter.CategoryVH>(CategoryDU) {

    private var itemClickListener: ((Int) -> Unit)? = null

    fun setItemClickListener(itemClickListener: (Int) -> Unit){
        this.itemClickListener = itemClickListener
    }

    inner class CategoryVH(private val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: CategoryDate){
            binding.categoryImage.setImageResource(data.image)
            binding.category.text = data.name
            binding.progressBar.progress = data.progress
            binding.txtProgress.text = "${data.progress}%"
        }
        init {
            binding.item.setOnClickListener {
                itemClickListener?.invoke(getItem(adapterPosition).id)
            }
        }
    }
    object CategoryDU: DiffUtil.ItemCallback<CategoryDate>() {
        override fun areItemsTheSame(oldItem: CategoryDate, newItem: CategoryDate): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CategoryDate, newItem: CategoryDate): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CategoryVH(binding)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        holder.bind(getItem(position))
    }
}