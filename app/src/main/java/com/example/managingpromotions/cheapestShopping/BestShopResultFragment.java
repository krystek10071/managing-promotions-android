package com.example.managingpromotions.cheapestShopping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.managingpromotions.R;

public class BestShopResultFragment extends Fragment {

    public BestShopResultFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_best_shop_result, container, false);
    }
}