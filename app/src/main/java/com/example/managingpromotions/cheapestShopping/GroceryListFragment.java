package com.example.managingpromotions.cheapestShopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;

public class GroceryListFragment extends Fragment {

    private RecyclerView recyclerView;

    private final String title;

    public GroceryListFragment() {
        this.title = "Tab1";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grocery_list, container, false);
        init(rootView);


        return rootView;
    }

    private void init(View view) {
        recyclerView = view.findViewById(R.id.fragment_grocery_list_rv);
    }
}