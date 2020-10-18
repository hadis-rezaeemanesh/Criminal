package com.example.criminal.controller.activity;

import androidx.fragment.app.Fragment;

import com.example.criminal.controller.fragment.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    public Fragment createFragment() {
        return CrimeListFragment.newInstance();
    }
}