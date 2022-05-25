package com.example.managingpromotions.cheapestShopping.bestShopResult.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.cheapestShopping.bestShopResult.model.CheapestShoppingReponse;

import java.util.List;

public class BestShopResultAdapter extends RecyclerView.Adapter<BestShopResultAdapter.BestShopResultHolder> {

    private Context context;
    private List<CheapestShoppingReponse> cheapestShoppingReponses;

    public BestShopResultAdapter(Context context, List<CheapestShoppingReponse> cheapestShoppingReponses) {
        this.context = context;
        this.cheapestShoppingReponses = cheapestShoppingReponses;
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
        String textCostValue = cheapestShoppingReponses.get(position).getPrice() + " zł";

        holder.textViewShopName.setText(cheapestShoppingReponses.get(position).getShopName());
        holder.textViewCostValue.setText(textCostValue);
    }

    @Override
    public int getItemCount() {
        if (cheapestShoppingReponses == null || cheapestShoppingReponses.isEmpty()) {
            return 0;
        }

        return cheapestShoppingReponses.size();
    }


    public static class BestShopResultHolder extends RecyclerView.ViewHolder {

        TextView textViewShopName, textViewCostValue;
        Button buttonSeeSelectedProducts;

        public BestShopResultHolder(@NonNull View itemView) {
            super(itemView);

            textViewShopName = itemView.findViewById(R.id.textViewShopName);
            textViewCostValue = itemView.findViewById(R.id.textViewCostValue);
            buttonSeeSelectedProducts = itemView.findViewById(R.id.seeSelectedProducts);
        }
    }
}
