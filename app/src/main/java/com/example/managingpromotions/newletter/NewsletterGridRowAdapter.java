package com.example.managingpromotions.newletter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.model.LetterNewsletterResponseDTO;

import java.util.List;

public class NewsletterGridRowAdapter extends RecyclerView.Adapter<NewsletterGridRowAdapter.ButtonViewHolder> {
    private final Context context;
    private final List<LetterNewsletterResponseDTO> newsletterResponseDTS;
    private final ButtonClickListener buttonClickListener;

    public NewsletterGridRowAdapter(Context context, List<LetterNewsletterResponseDTO> newsletterResponseDTOS,
                                    ButtonClickListener buttonClickListener) {
        this.context = context;
        this.newsletterResponseDTS = newsletterResponseDTOS;
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
        LetterNewsletterResponseDTO newsletter = newsletterResponseDTS.get(position);

        setButtonLogo(newsletter, holder);
       // holder.button.setText("label111");
        holder.imageButton.setOnClickListener(v -> buttonClickListener.onButtonClick("label"));
    }

    @Override
    public int getItemCount() {

        if (newsletterResponseDTS == null || newsletterResponseDTS.isEmpty()) {
            return 0;
        }

        return newsletterResponseDTS.size();
    }

    public interface ButtonClickListener {
        void onButtonClick(String label);
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {

        public ImageButton imageButton;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.button_newsletter_name);
        }
    }

    private void setButtonLogo(LetterNewsletterResponseDTO newsletter, ButtonViewHolder holder) {

        switch (newsletter.getShopName()) {
            case ELECLERC:
                holder.imageButton.setBackgroundResource(R.drawable.eleclerc_logo);
                break;
            case GROSZEK:
                holder.imageButton.setBackgroundResource(R.drawable.groszek_logo);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

