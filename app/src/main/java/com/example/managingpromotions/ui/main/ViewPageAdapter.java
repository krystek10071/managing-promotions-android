package com.example.managingpromotions.ui.main;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.managingpromotions.cheapestShopping.BestShopResultFragment;
import com.example.managingpromotions.cheapestShopping.GroceryListFragment;
import com.example.managingpromotions.cheapestShopping.ProductsFromShopFragment;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new GroceryListFragment();
                break;
            case 1:
                fragment = new ProductsFromShopFragment();
                break;
            case 2:
                fragment = new BestShopResultFragment();
                break;
        }

        if (fragment != null) {
            return fragment;
        }
        return new GroceryListFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}