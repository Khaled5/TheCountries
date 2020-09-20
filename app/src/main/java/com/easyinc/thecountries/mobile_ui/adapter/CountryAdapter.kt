package com.easyinc.thecountries.mobile_ui.adapter

import android.content.Context
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.easyinc.thecountries.R
import com.easyinc.thecountries.base.extentions.inflate
import com.easyinc.thecountries.presentation.model.CountryView
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.android.synthetic.main.list_item.view.*
import javax.inject.Inject

class CountryAdapter @Inject constructor(
    @ApplicationContext private val context: Context
): RecyclerView.Adapter<CountryAdapter.RunViewHolder>() {

    inner class RunViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(country: CountryView, clickListener: (String) -> Unit) {
            itemView.country_name.text = country.name
            GlideToVectorYou.init().with(context).load(Uri.parse(country.flag),itemView.country_flag)

            itemView.setOnClickListener {
                clickListener(country.name)
            }
        }
    }

    internal var clickListener: (String) -> Unit = {_ -> }

    private val diffCallback = object : DiffUtil.ItemCallback<CountryView>() {
        override fun areItemsTheSame(oldItem: CountryView, newItem: CountryView): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CountryView, newItem: CountryView): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<CountryView>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RunViewHolder(parent.inflate(R.layout.list_item))


    override fun getItemCount() = differ.currentList.size

    override fun onBindViewHolder(holder: RunViewHolder, position: Int) = holder.bind(differ.currentList[position],clickListener)

}