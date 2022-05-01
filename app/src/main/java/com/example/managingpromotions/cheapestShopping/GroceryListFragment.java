package com.example.managingpromotions.cheapestShopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.managingpromotions.R;

public class GroceryListFragment extends Fragment {

    TextView testTextViewTab1;

    private final String title;

    public GroceryListFragment() {
        this.title = "Tab1";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grocery_list, container, false);

        testTextViewTab1 = rootView.findViewById(R.id.textViewTab1);

        testTextViewTab1.setText(title);

        return rootView;
    }
}