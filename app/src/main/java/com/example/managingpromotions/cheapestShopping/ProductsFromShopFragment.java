package com.example.managingpromotions.cheapestShopping;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.managingpromotions.R;

public class ProductsFromShopFragment extends Fragment {

    private TextView testTextViewTab2;

    public ProductsFromShopFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_products_from_shop, container, false);

        testTextViewTab2 = rootView.findViewById(R.id.textViewTab2);

        testTextViewTab2.setText("TAB 2");

        return rootView;
    }
}