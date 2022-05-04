package com.example.managingpromotions.cheapestShopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.model.GroceryListResponseDTO;

import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryHolder> {

    private Context context;
    private List<GroceryListResponseDTO> groceryListResponseDTOS;

    public GroceryListAdapter(Context context, List<GroceryListResponseDTO> groceryListResponseDTOS) {
        this.context = context;
        this.groceryListResponseDTOS = groceryListResponseDTOS;
    }

    @NonNull
    @Override
    public GroceryListAdapter.GroceryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view_grocery_row, parent, false);

        return new GroceryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryListAdapter.GroceryHolder holder, int position) {

        holder.textViewGroceryName.setText(groceryListResponseDTOS.get(position).getName());
        holder.textViewAddedData.setText(groceryListResponseDTOS.get(position).getCreateDate().toString());
    }

    @Override
    public int getItemCount() {
        if (groceryListResponseDTOS == null || groceryListResponseDTOS.isEmpty()) {
            return 0;
        }

        return groceryListResponseDTOS.size();
    }

    public static class GroceryHolder extends RecyclerView.ViewHolder {

        TextView textViewGroceryName, textViewAddedData;

        public GroceryHolder(@NonNull View itemView) {
            super(itemView);

            textViewGroceryName = itemView.findViewById(R.id.textViewGroceryName);
            textViewAddedData = itemView.findViewById(R.id.textViewAddedData);
        }
    }
}
