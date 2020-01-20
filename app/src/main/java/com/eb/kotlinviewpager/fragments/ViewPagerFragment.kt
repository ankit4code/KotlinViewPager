package com.eb.kotlinviewpager.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

import com.eb.kotlinviewpager.R
import com.eb.kotlinviewpager.adapter.MyViewPagerAdapter
import com.eb.kotlinviewpager.adapter.PAGE_ONE_INDEX
import com.eb.kotlinviewpager.adapter.PAGE_TWO_INDEX
import com.eb.kotlinviewpager.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentViewPagerBinding.inflate(inflater,container,false)
        val viewPager= binding.viewPager
        val tabLayout = binding.tabs

        viewPager.adapter = MyViewPagerAdapter(this)

        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)



        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            PAGE_ONE_INDEX -> R.drawable.page_one_tab_selector
            PAGE_TWO_INDEX -> R.drawable.page_two_tab_selector
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            PAGE_ONE_INDEX -> getString(R.string.page_one)
            PAGE_TWO_INDEX -> getString(R.string.page_two)
            else -> null
        }
    }
}
