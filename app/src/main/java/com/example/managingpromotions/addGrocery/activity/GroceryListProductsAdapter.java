package com.example.managingpromotions.addGrocery.activity;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.model.GroceryListProductDTO;

import java.util.List;

public class GroceryListProductsAdapter extends RecyclerView.Adapter<GroceryListProductsAdapter.ProductHolder> {

    private final List<GroceryListProductDTO> groceryListProductDTOS;
    private final Context context;

    public GroceryListProductsAdapter(List<GroceryListProductDTO> groceryListProductDTOS, Context context) {
        this.groceryListProductDTOS = groceryListProductDTOS;
        this.context = context;
    }

    public static class ProductHolder extends RecyclerView.ViewHolder{

        TextView productNameTextView, amountTextView;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            productNameTextView = itemView.findViewById(R.id.product_name);
            amountTextView = itemView.findViewById(R.id.amount);
        }
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view_grocery_list_row, parent, false );

        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {

        holder.productNameTextView.setText(groceryListProductDTOS.get(position).getName());
        holder.amountTextView.setText(String.valueOf(groceryListProductDTOS.get(position).getAmount()));
    }

    @Override
    public int getItemCount() {

        if(groceryListProductDTOS == null || groceryListProductDTOS.isEmpty()){
            return 0;
        }

        return groceryListProductDTOS.size();
    }
}
