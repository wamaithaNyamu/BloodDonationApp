package com.example.blood_donation_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.example.blood_donation_app.Fragments.fragment_donor_home;
import com.example.blood_donation_app.Fragments.fragment_donor_maps;
import com.example.blood_donation_app.Fragments.fragment_donor_profile;
import com.example.blood_donation_app.Fragments.fragment_hospital_home;

import com.example.blood_donation_app.Fragments.fragment_hospital_map;

import com.example.blood_donation_app.Fragments.fragment_hospital_profile;

public class hospitalSectionsPageAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;

    public hospitalSectionsPageAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new fragment_hospital_home();
                break;
            case 1:
                fragment = new fragment_hospital_map();
                break;
            case 2:
                fragment = new fragment_hospital_profile();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }


}
