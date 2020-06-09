package jp.co.clockvoid.chaser.core.android.extensions

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

object FragmentExtension {

    /**
     * bindingをnullにするLifecycleObserverの登録をして、lifecycleOwnerセットをする拡張関数。
     * Lazyを継承しているので、フィールドをvalにすることができる。
     * @param layoutResId layoutのID
     * @param onDestroyView bindingをnullにする前に呼び出すべきコールバック
     */
    fun <T : ViewDataBinding> Fragment.dataBinding(
        @LayoutRes layoutResId: Int,
        onDestroyView: ((T) -> Unit)? = null
    ): Lazy<T> {
        return object : Lazy<T> {

            private var binding: T? = null

            override fun isInitialized(): Boolean = binding != null

            override val value: T
                get() = binding ?: DataBindingUtil.inflate<T>(
                    layoutInflater,
                    layoutResId,
                    requireActivity().findViewById(id) as? ViewGroup,
                    false
                ).also {
                    binding = it
                    it.lifecycleOwner = viewLifecycleOwner
                    viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        @Suppress("unused")
                        fun onDestroyView() {
                            viewLifecycleOwner.lifecycle.removeObserver(this)
                            onDestroyView?.invoke(binding!!)
                            binding = null // For Fragment's view recreation
                        }
                    })
                }
        }
    }
}
