package com.demo.dokong.kotlincoroutinestest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.demo.dokong.kotlincoroutinestest.R

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-1. 14:18
 */
class EmptyFragment : Fragment() {

    companion object {
        fun newInstance(title: String) = EmptyFragment()
            .apply {
                arguments = Bundle()
                    .apply {
                        putString("title", title)
                    }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.frag_empty, container, false)
        view.findViewById<TextView>(R.id.tv).text = arguments?.getString("title")
        return view
    }
}