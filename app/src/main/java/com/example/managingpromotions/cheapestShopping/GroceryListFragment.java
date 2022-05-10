package com.example.managingpromotions.cheapestShopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.presenter.GroceryListPresenterImpl;
import com.example.managingpromotions.model.GroceryListResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class GroceryListFragment extends Fragment {

    private RecyclerView recyclerView;
    private GroceryListAdapter groceryListAdapter;
    private GroceryListPresenterImpl groceryListPresenter;
    private List<GroceryListResponseDTO> groceryListResponseDTOList;

    //todo
    private List<Boolean> checkBoxStateArray;

    public GroceryListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_grocery_list, container, false);
        init(rootView);
        groceryListPresenter = new GroceryListPresenterImpl(this);

        groceryListPresenter.getGroceryLists();
        checkBoxStateArray = new ArrayList<>(groceryListResponseDTOList.size());

        groceryListAdapter = new GroceryListAdapter(rootView.getContext(), groceryListResponseDTOList, checkBoxStateArray);
        recyclerView.setAdapter(groceryListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(rootView.getContext()));

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        //set Grocery List elements
        groceryListPresenter.getGroceryLists();
    }

    private void init(View view) {
        groceryListResponseDTOList = new ArrayList<>();
        recyclerView = view.findViewById(R.id.fragment_grocery_list_rv);
    }

    public void displayMessage(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }

    public void setRecyclerView(List<GroceryListResponseDTO> groceryListResponseDTOS) {

        groceryListResponseDTOList.addAll(groceryListResponseDTOS);

        //todo
        groceryListResponseDTOS.forEach(groceryListResponseDTO -> {
            checkBoxStateArray.add(false);
        });

        groceryListAdapter.notifyItemChanged(groceryListResponseDTOS.size());
    }
}