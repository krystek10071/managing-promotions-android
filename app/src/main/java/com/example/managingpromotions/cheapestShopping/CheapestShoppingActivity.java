package com.example.managingpromotions.cheapestShopping;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.managingpromotions.R;
import com.example.managingpromotions.ui.main.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CheapestShoppingActivity extends AppCompatActivity {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheapest_shopping_activity);

        ViewPager2 viewPager2 = findViewById(R.id.cheapestShoppingViewPager);
        viewPager2.setAdapter(new ViewPageAdapter(this));

        TabLayout sampleTabLayout = findViewById(R.id.tabsCheapestShoppingActivity);

        //create mediator
        new TabLayoutMediator(
                sampleTabLayout,
                viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(TAB_TITLES[position]);
                    }
                }
        ).attach();
    }
}
