package com.udemy.hekotech.mobil_isletme;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.udemy.hekotech.mobil_isletme.Models.FrKurumsal;
import com.udemy.hekotech.mobil_isletme.Models.FrSiparis;
import com.udemy.hekotech.mobil_isletme.Models.frIlerisim;

public class MainActivity extends AppCompatActivity {
    private SectionAdapter sectionAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sectionAdapter=new SectionAdapter(getSupportFragmentManager());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.container);
        viewPager.setAdapter(sectionAdapter);
        viewPager.setOffscreenPageLimit(0);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

  
public class SectionAdapter extends FragmentPagerAdapter{

    public SectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: frIlerisim tab1 = new frIlerisim();
            return  tab1;
            case 1: FrSiparis tab2 = new FrSiparis();
            return  tab2;
            case 2: FrKurumsal tab3 = new FrKurumsal();
            return tab3;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0: return "iletisim";
            case 1: return "siparis";
            case 2: return "kurumsal";
            default: return null;
        }
    }
}
}
