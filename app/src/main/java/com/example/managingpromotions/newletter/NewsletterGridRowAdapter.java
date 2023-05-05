package com.example.managingpromotions.newletter;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managingpromotions.R;
import com.example.managingpromotions.model.LetterNewsletterResponseDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        holder.imageButton.setOnClickListener(v -> buttonClickListener.openActivityWithNewsletter(newsletter.getId()));
    }

    @Override
    public int getItemCount() {

        if (newsletterResponseDTS == null || newsletterResponseDTS.isEmpty()) {
            return 0;
        }

        return newsletterResponseDTS.size();
    }

    public interface ButtonClickListener {
        void openActivityWithNewsletter(Long id);
    }

    public static class ButtonViewHolder extends RecyclerView.ViewHolder {

        public ImageButton imageButton;
        public TextView textViewStartDateEndDate;

        public ButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.button_newsletter_name);
            textViewStartDateEndDate = itemView.findViewById(R.id.textViewDateStartEnd);
        }
    }

    private void setButtonLogo(LetterNewsletterResponseDTO newsletter, ButtonViewHolder holder) {

        switch (newsletter.getShopName()) {
            case ELECLERC:
                holder.imageButton.setImageDrawable(getRoundedDrawable(context, R.drawable.eleclerc_logo));
                holder.textViewStartDateEndDate.setText(createStarAndEndDate(newsletter.getStartDate(), newsletter.getEndDate()));
                break;
            case GROSZEK:
                holder.imageButton.setImageDrawable(getRoundedDrawable(context, R.drawable.groszek_logo_1));
                holder.textViewStartDateEndDate.setText(createStarAndEndDate(newsletter.getStartDate(), newsletter.getEndDate()));
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private String createStarAndEndDate(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        String formattedStart = start.format(formatter);
        String formattedEnd = end.format(formatter);
        return formattedStart + "-" + formattedEnd;
    }

    private RoundedBitmapDrawable getRoundedDrawable(Context context, int drawableId) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawableId);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(), bitmap);
        roundedBitmapDrawable.setCornerRadius(50);
        roundedBitmapDrawable.setAntiAlias(true);
        return roundedBitmapDrawable;
    }
}

