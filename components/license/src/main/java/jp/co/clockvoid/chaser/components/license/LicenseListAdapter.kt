package jp.co.clockvoid.chaser.components.license

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jp.co.clockvoid.chaser.components.license.databinding.ItemLicenseListBinding

class LicenseListAdapter
    : ListAdapter<PackageLicense, LicenseListAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object {

        val DIFF_CALLBACK: DiffUtil.ItemCallback<PackageLicense> =
            object : DiffUtil.ItemCallback<PackageLicense>() {

                override fun areItemsTheSame(
                    oldItem: PackageLicense,
                    newItem: PackageLicense
                ): Boolean {

                    return oldItem.project == newItem.project
                }

                override fun areContentsTheSame(
                    oldItem: PackageLicense,
                    newItem: PackageLicense
                ): Boolean {

                    return oldItem == newItem
                }
            }
    }

    inner class ViewHolder(val binding: ItemLicenseListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(ItemLicenseListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = getItem(position)
        holder.binding.apply {
            packageNameTextView.text = item.project
            copyrightTextView.text = holder.binding.root.context.getString(
                R.string.copyright_c,
                (item.year?.plus(" ") ?: "") +
                item.developers.foldIndexed("") { index, acc, item ->
                    "$acc${if (index != 0) ", " else ""}$item"
                }
            )
            copyrightTextView.isGone = item.developers.isEmpty()
            urlTextView.text = item.url
            urlTextView.isGone = item.url.isNullOrEmpty()
            licenseTextView.text = item.licenses.foldIndexed("") { index, acc, item ->
                "$acc${if (index != 0) ", " else ""}${item.license}"
            }
            licenseTextView.isGone = item.licenses.isEmpty()
        }
    }
}
