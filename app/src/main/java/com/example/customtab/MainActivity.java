package com.example.customtab;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    ViewPager mViewPager;
    TabLayout mTabLayout;

    private String[] tabTitles = {"Favorites", "Recent", "Discover", "IP", "QR"};
    private int[] tabIcons = {R.drawable.ic_all_out_black_24dp, R.drawable.ic_android_black_24dp,
            R.drawable.ic_announcement_black_24dp, R.drawable.ic_archive_black_24dp,
            R.drawable.ic_assignment_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mViewPager = (ViewPager)findViewById(R.id.viewpager);
        mTabLayout = (TabLayout)findViewById(R.id.tablayout);
        setUpViewPager();
        mTabLayout.setupWithViewPager(mViewPager);
        setUpTabIcons();
    }

    private void setUpViewPager(){
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());

        Fragment fragOne, fragTwo, fragThree, fragFour, fragFive;
        fragOne = new FragmentTab();
        fragTwo = new FragmentTab();
        fragThree = new FragmentTab();
        fragFour = new FragmentTab();
        fragFive = new FragmentTab();

        Fragment[] fragments = {fragOne, fragTwo, fragThree, fragFour, fragFive};


        Bundle args = new Bundle();
        args.putString("text", "First Fragment");
        fragOne.setArguments(args);

        args = new Bundle();
        args.putString("text", "Second Fragment");
        fragTwo.setArguments(args);

        args = new Bundle();
        args.putString("text", "Third Fragment");
        fragThree.setArguments(args);

        args = new Bundle();
        args.putString("text", "Fourth Fragment");
        fragFour.setArguments(args);


        args = new Bundle();
        args.putString("text", "Fifth Fragment");
        fragFive.setArguments(args);

        for (int i = 0; i<tabTitles.length; i++) {
            adapter.addFragment(fragments[i], tabTitles[i]);
        }
        mViewPager.setAdapter(adapter);
    }

    private void setUpTabIcons() {
        for (int i = 0; i < tabIcons.length; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.img_custom_tab);
            imageView.setImageResource(tabIcons[i]);
            TextView txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtTitle.setText(tabTitles[i]);
            if (i == 3) {
                TextView txtSubtitle = (TextView) view.findViewById(R.id.txtSubtitle);
                txtSubtitle.setText("Address");
            }
            mTabLayout.getTabAt(i).setCustomView(view);
        }
    }
}
