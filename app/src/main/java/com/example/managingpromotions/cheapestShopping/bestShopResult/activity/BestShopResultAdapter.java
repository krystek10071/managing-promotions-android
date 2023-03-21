package com.example.managingpromotions.cheapestShopping.bestShopResult.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.bestShopResult.model.CheapestShoppingReponse;
import com.example.managingpromotions.cheapestShopping.productsFromShop.model.ProductParsedFromShopDTO;
import com.example.managingpromotions.cheapestShopping.productsInBasket.activity.ProductsInBasketActivity;

import java.util.List;

public class BestShopResultAdapter extends RecyclerView.Adapter<BestShopResultAdapter.BestShopResultHolder> {

    private final Context context;
    private final List<CheapestShoppingReponse> cheapestShoppingReponses;

    private final List<ProductParsedFromShopDTO> parsedFromShopDTOS;

    public BestShopResultAdapter(Context context, List<CheapestShoppingReponse> cheapestShoppingReponses,
                                 List<ProductParsedFromShopDTO> parsedProducts) {
        this.context = context;
        this.cheapestShoppingReponses = cheapestShoppingReponses;
        this.parsedFromShopDTOS = parsedProducts;
    }

    @NonNull
    @Override
    public BestShopResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.best_shop_result_row, parent, false);

        return new BestShopResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestShopResultHolder holder, int position) {

        setValueOfTheElementsInTheComponents(holder, position, cheapestShoppingReponses);

        holder.buttonSeeSelectedProducts.setOnClickListener(view -> {

            Intent intent = new Intent(context, ProductsInBasketActivity.class);
            intent.putExtra("productsInBasket", cheapestShoppingReponses.get(position));

            context.startActivity(intent);
        });

        holder.attentionButton.setOnClickListener(view ->
                createMessageForUnselectedProduct(cheapestShoppingReponses, position));
    }

    private void createMessageForUnselectedProduct(List<CheapestShoppingReponse> cheapestShoppingReponses, int position) {

        List<String> unselectedProducts = cheapestShoppingReponses.get(position).getUnSelectedProducts();
        StringBuilder strBuilder = new StringBuilder(
                "Koszyk końcowy nie został w pełni zrealizowany dla niektórych produktów z lity zakupów:\n");

        unselectedProducts.forEach(productName -> {
            strBuilder.append("- ")
                    .append(productName)
                    .append("\n");
        });

        Toast.makeText(context, strBuilder, Toast.LENGTH_LONG).show();
    }

    private void setValueOfTheElementsInTheComponents(
            BestShopResultHolder holder, int position, List<CheapestShoppingReponse> cheapestShoppingReponses) {

        String textCostValue = cheapestShoppingReponses.get(position).getPrice() + " zł";
        holder.textViewShopName.setText(cheapestShoppingReponses.get(position).getShopName());
        holder.textViewCostValue.setText(textCostValue);

        if (cheapestShoppingReponses.get(position).getUnSelectedProducts().isEmpty()) {
            holder.attentionButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        if (cheapestShoppingReponses == null || cheapestShoppingReponses.isEmpty()) {
            return 0;
        }

        return cheapestShoppingReponses.size();
    }


    public static class BestShopResultHolder extends RecyclerView.ViewHolder {

        private final TextView textViewShopName;
        private final TextView textViewCostValue;
        private final Button buttonSeeSelectedProducts;
        private final ImageView attentionButton;

        public BestShopResultHolder(@NonNull View itemView) {
            super(itemView);

            attentionButton = itemView.findViewById(R.id.attention_button);
            textViewShopName = itemView.findViewById(R.id.textViewShopName);
            textViewCostValue = itemView.findViewById(R.id.textViewCostValue);
            buttonSeeSelectedProducts = itemView.findViewById(R.id.seeSelectedProducts);
        }
    }
}
