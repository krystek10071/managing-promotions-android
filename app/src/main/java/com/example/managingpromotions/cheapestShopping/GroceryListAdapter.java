package com.example.managingpromotions.cheapestShopping;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryHolder> {

    private Context context;

    @NonNull
    @Override
    public GroceryListAdapter.GroceryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryListAdapter.GroceryHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class GroceryHolder extends RecyclerView.ViewHolder {

        TextView productNameTextView, amountTextView;

        public GroceryHolder(@NonNull View itemView) {
            super(itemView);

            productNameTextView = itemView.findViewById(R.id.product_name);
            amountTextView = itemView.findViewById(R.id.amount);
        }
    }


}
