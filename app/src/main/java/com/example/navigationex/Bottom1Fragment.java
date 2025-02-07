package com.example.navigationex;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationex.databinding.FragmentBottom1Binding;
import com.example.navigationex.databinding.FragmentBottom1Binding;
import com.example.navigationex.databinding.FragmentTabbed1Binding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bottom1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bottom1Fragment extends Fragment {
    private FragmentTabbed1Binding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentTabbed1Binding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                switch (position) {
                    case 0: default:
                        return new Tabbed1AFragment();
                    case 1:
                        return new Tabbed1BFragment();
                    case 2:
                        return new Tabbed1CFragment();
                }
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });

        new TabLayoutMediator(binding.tabLayout, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position) {
                    case 0: default:
                        tab.setText("TAB A");
                        break;
                    case 1:
                        tab.setText("TAB B");
                        break;
                    case 2:
                        tab.setText("TAB C");
                        break;
                }
            }
        }).attach();
    }
}