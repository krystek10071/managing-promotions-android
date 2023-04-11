package com.example.managingpromotions.cheapestShopping.groceryList.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.model.GroceryListResponseDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryHolder> {

    private static final String GROCERY_LIST_NAME = "Nazwa listy: ";
    private static final String FORMAT_DATA_TIME = "dd/MM/yyyy HH:mm";

    private final Context context;
    private final List<GroceryListResponseDTO> groceryListResponseDTOS;
    private final List<Boolean> checkBoxStateArray;

    public GroceryListAdapter(Context context, List<GroceryListResponseDTO> groceryListResponseDTOS, List<Boolean> checkBoxStateArray) {
        this.context = context;
        this.groceryListResponseDTOS = groceryListResponseDTOS;
        this.checkBoxStateArray = checkBoxStateArray;
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

        holder.textViewGroceryName.setText( groceryListResponseDTOS.get(position).getName());
        holder.textViewAddedDate.setText(convertDateByFormatter(groceryListResponseDTOS.get(position).getCreateDate()));
        holder.textViewGroceryField.setText(GROCERY_LIST_NAME);

        holder.checkBox.setOnClickListener(view -> {
            if (checkBoxStateArray.get(position)) {
                holder.checkBox.setChecked(false);
                checkBoxStateArray.set(position, false);
            } else {
                holder.checkBox.setChecked(true);
                checkBoxStateArray.set(position, true);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (groceryListResponseDTOS == null || groceryListResponseDTOS.isEmpty()) {
            return 0;
        }

        return groceryListResponseDTOS.size();
    }

    public static class GroceryHolder extends RecyclerView.ViewHolder {

        TextView textViewGroceryName, textViewAddedDate, textViewGroceryField;
        CheckBox checkBox;

        public GroceryHolder(@NonNull View itemView) {
            super(itemView);

            textViewGroceryName = itemView.findViewById(R.id.textViewGroceryName);
            textViewAddedDate = itemView.findViewById(R.id.textViewAddedData);
            textViewGroceryField = itemView.findViewById(R.id.textViewGroceryField);
            checkBox = itemView.findViewById(R.id.checkBox);
        }
    }

    private String convertDateByFormatter(Date date){
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat(FORMAT_DATA_TIME, Locale.GERMANY);
        return simpleDateFormatter.format(date);
    }
}
