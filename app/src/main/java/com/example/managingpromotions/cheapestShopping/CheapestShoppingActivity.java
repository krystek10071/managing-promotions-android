package com.example.managingpromotions.cheapestShopping;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.managingpromotions.R;
import com.example.managingpromotions.ui.main.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class CheapestShoppingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cheapest_shopping_activity);

        ViewPager2 viewPager2 = findViewById(R.id.cheapestShoppingViewPager);
        viewPager2.setAdapter(new ViewPageAdapter(this));

        TabLayout sampleTabLayout = findViewById(R.id.tabsCheapestShoppingActivity);

/*        //create mediator
        new TabLayoutMediator(
                sampleTabLayout,
                viewPager2,
                TabLayout.Tab::
        );*/
    }
}
