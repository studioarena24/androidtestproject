package com.ks.studioarena.delivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.dynamic.SupportFragmentWrapper
import com.google.android.material.tabs.TabLayout

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root = inflater.inflate(R.layout.fragment_main, container, false)

        val tabs = root.findViewById<TabLayout>(R.id.tabLayout)
        tabSelected(tabs)

        childFragmentManager.beginTransaction()
            .replace(R.id.mainFrameLayout_fragment, FirstTab())
            .commit()


        return root
    }

    private fun tabSelected(tabs: TabLayout?) {
        tabs!!.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab!!.position) {
                    0 ->  {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout_fragment, FirstTab())
                            .commit()
                    }
                    1 ->  {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout_fragment, SecondTab())
                            .commit()
                    }
                    2 -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.mainFrameLayout_fragment, ThirdTab())
                            .commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
}