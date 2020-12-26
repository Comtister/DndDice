package com.example.dnddice;

import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList=new ArrayList<>();
    private final List<String> FragmentBaslikList=new ArrayList<>();

    TabAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int pozisyon){

        return fragmentList.get(pozisyon);
    }

    public void addFragment(Fragment fragment,String baslik){
        fragmentList.add(fragment);
        FragmentBaslikList.add(baslik);

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int pozisyon){
        return FragmentBaslikList.get(pozisyon);
    }

    @Override
    public int getCount(){
        return fragmentList.size();
    }




}
