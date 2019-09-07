package com.geektech.infinityapp.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;

import com.geektech.infinityapp.R;
import com.geektech.infinityapp.main.MainActivity;
import com.tbuonomo.viewpagerdotsindicator.OnPageChangeListenerHelper;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    ViewPager viewPager;
    IntroPagerAdapter adapter;
    private Button nextButton, prevButton;

    public static void start(Context context) {
        Intent intent = new Intent(context, IntroActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ArrayList<IntroPageConfig> pages = new ArrayList<>();
        pages.add(new IntroPageConfig(R.string.frag_name0, R.drawable.ic_ac));
        pages.add(new IntroPageConfig(R.string.frag_name1, R.drawable.ic_android));
        pages.add(new IntroPageConfig(R.string.frag_name2, R.drawable.ic_assignment));
        adapter = new IntroPagerAdapter(getSupportFragmentManager(), pages);
        nextButton = findViewById(R.id.nextBtn);
        prevButton = findViewById(R.id.prevBtn);
        viewPager = findViewById(R.id.intro_pager);
        viewPager.setAdapter(adapter);

        WormDotsIndicator wormDotsIndicator = findViewById(R.id.worm_dots_indicator);
        wormDotsIndicator.setViewPager(viewPager);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() == 2) {
                    introSkip();
                }
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (viewPager.getCurrentItem() == 2) {
                    nextButton.setText("Finish");
                } else {
                    nextButton.setText("next >");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });

    }

    public void introSkip() {
        MainActivity.start(this);
        finish();
    }

    public class IntroPagerAdapter extends FragmentPagerAdapter {

        List<IntroPageConfig> pages;

        IntroPagerAdapter(FragmentManager fm, List<IntroPageConfig> pages) {
            super(fm);
            this.pages = pages;
        }

        @Override
        public Fragment getItem(final int position) {
            return IntroPageFragment.newInstance(pages.get(position));
        }

        @Override
        public int getCount() {
            return pages.size();
        }
    }
}
