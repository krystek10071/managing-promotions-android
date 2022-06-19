package com.example.managingpromotions.cheapestShopping.productsInBasket.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ParsedProductDTO;

import java.math.BigDecimal;
import java.util.List;

public class ProductsInBasketAdapter extends RecyclerView.Adapter<ProductsInBasketAdapter.ProductsHolder> {

    private final Context context;
    private final List<ParsedProductDTO> parsedProductDTOS;

    public ProductsInBasketAdapter(Context context, List<ParsedProductDTO> parsedProductDTOS) {
        this.context = context;
        this.parsedProductDTOS = parsedProductDTOS;
    }

    @NonNull
    @Override
    public ProductsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.products_in_basket_row, parent, false);

        return new ProductsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsHolder holder, int position) {

        holder.textViewProductName.setText(parsedProductDTOS.get(position).getName());
        holder.textViewPrice.setText(parsedProductDTOS.get(position).getPrice().toString());
        holder.textViewAmount.setText(parsedProductDTOS.get(position).getAmount().toString());
        holder.textViewSum.setText(calculateSum(parsedProductDTOS.get(position)));

    }

    private String calculateSum(ParsedProductDTO parsedProductDTO) {
        BigDecimal priceProduct = parsedProductDTO.getPrice();
        int amount = parsedProductDTO.getAmount();
        return priceProduct.multiply(BigDecimal.valueOf(amount)).toString() + " zł";
    }

    @Override
    public int getItemCount() {
        if (parsedProductDTOS == null || parsedProductDTOS.isEmpty()) {
            return 0;
        }

        return parsedProductDTOS.size();
    }

    public static class ProductsHolder extends RecyclerView.ViewHolder {

        TextView textViewProductName, textViewPrice, textViewAmount, textViewSum;

        public ProductsHolder(@NonNull View itemView) {
            super(itemView);

            textViewProductName = itemView.findViewById(R.id.textViewProductName);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
            textViewAmount = itemView.findViewById(R.id.textViewAmount);
            textViewSum = itemView.findViewById(R.id.textViewSum);
        }
    }

}
