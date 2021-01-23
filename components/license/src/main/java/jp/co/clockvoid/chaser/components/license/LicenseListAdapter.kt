package jp.co.clockvoid.chaser.components.license

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.text.method.LinkMovementMethod
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
            licenseTextView.text = fromHtml(item.licenses.foldIndexed("Under ") { index, acc, item ->
                "$acc${if (index != 0) ", " else ""}<a href=\"${item.license_url}\">${item.license}</a>"
            })
            licenseTextView.movementMethod = LinkMovementMethod.getInstance()
            licenseTextView.isGone = item.licenses.isEmpty()
        }
    }

    private fun fromHtml(html: String): Spanned {

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(html)
        }
    }
}
