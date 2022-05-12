package com.example.managingpromotions.cheapestShopping.productsFromShop.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;

import java.util.List;

public class ProductsFromShopAdapter extends RecyclerView.Adapter<ProductsFromShopAdapter.ProductsHolder> {

    private Context context;
    private ProductParsedFromShopDTO productParsedFromShopDTO;
    private List<Boolean> checkBoxStateArray;

    public ProductsFromShopAdapter(Context context, ProductParsedFromShopDTO productParsedFromShopDTO, List<Boolean> checkBoxStateArray) {
        this.context = context;
        this.productParsedFromShopDTO = productParsedFromShopDTO;
        this.checkBoxStateArray = checkBoxStateArray;
    }

    @NonNull
    @Override
    public ProductsFromShopAdapter.ProductsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.recycler_view_products_parsed_from_shop_row,
                parent, false);

        return new ProductsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsFromShopAdapter.ProductsHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ProductsHolder extends RecyclerView.ViewHolder {

        TextView textViewProductName, textViewPrice, textViewAmount;
        CheckBox checkBox;

        public ProductsHolder(@NonNull View itemView) {
            super(itemView);

            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }
}
