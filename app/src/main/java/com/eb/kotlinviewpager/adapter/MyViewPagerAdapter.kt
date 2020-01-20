package com.eb.kotlinviewpager.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.eb.kotlinviewpager.fragments.PageOne
import com.eb.kotlinviewpager.fragments.PageTwo



const val PAGE_ONE_INDEX = 0
const val PAGE_TWO_INDEX = 1

class MyViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        PAGE_ONE_INDEX to { PageOne() },
        PAGE_TWO_INDEX to { PageTwo() }
    )

    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}