package com.example.managingpromotions.newletter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;

import java.util.ArrayList;

public class ButtonGridFragment extends Fragment implements NewsletterGridRowActivity.ButtonClickListener {

    private ArrayList<String> buttonLabels = new ArrayList<>();
    private RecyclerView recyclerView;

    public ButtonGridFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newletter_grid_activity, container, false);
        recyclerView = view.findViewById(R.id.grid_with_buttons_for_newspapers);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        NewsletterGridRowActivity adapter = new NewsletterGridRowActivity(getContext(), buttonLabels, this);
        recyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onButtonClick(String label) {
        // do something when button is clicked
    }
}
