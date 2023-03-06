package com.example.managingpromotions.newletter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;

import java.util.ArrayList;

public class NewsletterGridRowActivity extends RecyclerView.Adapter<NewsletterGridRowActivity.ButtonViewHolder>{
        private final Context context;
        private final ArrayList<String> buttonLabels;
        private final ButtonClickListener buttonClickListener;

        public NewsletterGridRowActivity(Context context, ArrayList<String> buttonLabels, ButtonClickListener buttonClickListener) {
            this.context = context;
            this.buttonLabels = buttonLabels;
            this.buttonClickListener = buttonClickListener;
        }

        @NonNull
        @Override
        public ButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.button_grid_item, parent, false);
            return new ButtonViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ButtonViewHolder holder, int position) {
            String label = buttonLabels.get(position);
            holder.button.setText(label);
            holder.button.setOnClickListener(v -> buttonClickListener.onButtonClick(label));
        }

        @Override
        public int getItemCount() {
            return buttonLabels.size();
        }

public interface ButtonClickListener {
    void onButtonClick(String label);
}

public static class ButtonViewHolder extends RecyclerView.ViewHolder {

    public Button button;

    public ButtonViewHolder(@NonNull View itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.button_newsletter_name);
    }
}
}

