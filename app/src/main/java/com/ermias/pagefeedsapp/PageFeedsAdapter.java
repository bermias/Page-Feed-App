package com.ermias.pagefeedsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class PageFeedsAdapter extends RecyclerView.Adapter<PageFeedsAdapter.ViewHolder>{

    private List<Card> mCards;
    private LayoutInflater mInflater;
    private Context mContext;

    public PageFeedsAdapter(Context context, List<Card> cards){
        mCards = cards;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cardView = inflater.inflate(R.layout.list_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(cardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          Card card = mCards.get(position);
          String cardType = card.getCard_type();
          Help help = new Help();
          try{
             if(cardType.equals("text")){
                 int colorT = Color.parseColor(card.getCard_text_color());
                 int sizeT = card.getCard_text_size();
                 SpannableString ss =  help.getSpannableString(card.getCard_text_value(),
                         sizeT, colorT);
                  holder.textViewTitle.setText(ss);
                 //holder.textViewTitle.setText(card.getCard_text_value());
                 //holder.textViewTitle.setTextColor(colorT);
                 //holder.textViewTitle.setTextSize(sizeT);

             }
             else if(cardType.equals("title_description")){
                 System.out.println("title_description");
                int colorT = Color.parseColor(card.getCard_title_color());
                int colorD = Color.parseColor(card.getCard_description_color());
                int sizeT = card.getCard_title_size();
                int sizeD = card.getCard_description_size();
                 SpannableString sst = help.getSpannableString(card.getCard__title_text(),
                         sizeT, colorT);
                         //new SpannableString(card.getCard__title_text());
                 SpannableString ssd = help.getSpannableString(card.getCard_description_value(),
                         sizeD, colorD);
                         //new SpannableString(card.getCard_description_value());
                 SpannableString ss = new SpannableString(sst + "\n" + ssd);
                holder.textViewTitle.setText(sst);
                holder.textViewTitle.append("\n");
                holder.textViewTitle.append(ssd);
                /*holder.textViewTitle.setTextSize(sizeT);
                holder.textViewTitle.setTextColor(colorT);
                holder.textViewDescription.setText(card.getCard_description_value());
                holder.textViewDescription.setTextSize(sizeD);
                holder.textViewDescription.setTextColor(colorD);*/
             }
             else if(cardType.equals("image_title_description")){
                 System.out.println("image_title_description");
                 /*int colorT = Color.parseColor(card.getCard_title_color());
                 int colorD = Color.parseColor(card.getCard_description_color());
                 int sizeT = card.getCard_title_size();
                 int sizeD = card.getCard_description_size();
                 holder.textViewTitle.setText(card.getCard__title_text());
                 holder.textViewTitle.setTextSize(sizeT);
                 holder.textViewTitle.setTextColor(colorT);
                 holder.textViewDescription.setText(card.getCard_description_value());
                 holder.textViewDescription.setTextSize(sizeD);
                 holder.textViewDescription.setTextColor(colorD);*/
                 int colorT = Color.parseColor(card.getCard_title_color());
                 int colorD = Color.parseColor(card.getCard_description_color());
                 int sizeT = card.getCard_title_size();
                 int sizeD = card.getCard_description_size();
                 SpannableString sst = help.getSpannableString(card.getCard__title_text(),
                         sizeT, colorT);
                 //new SpannableString(card.getCard__title_text());
                 SpannableString ssd = help.getSpannableString(card.getCard_description_value(),
                         sizeD, colorD);
                 //new SpannableString(card.getCard_description_value());
                 //SpannableString ss = new SpannableString(sst + "\n" + ssd);
                 holder.textViewTitle.setText(sst);
                 holder.textViewTitle.append("\n");
                 holder.textViewTitle.append(ssd);
                 URL url = new URL(card.getImage_url());
                 Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                 //bitmap.setHeight(card.getImage_height());
                 //bitmap.setWidth(card.getImage_width());

                 Drawable d = new BitmapDrawable(mContext.getResources(), bitmap);
                 d.setBounds(0,0,card.getImage_width(), card.getImage_height());
                 holder.textViewTitle.setBackground(d);
             }

          }catch (Exception  e){
              System.out.println(e.toString());
          }
    }

    @Override
    public int getItemCount() {
        if(mCards == null){
            return 0;
        }
        return mCards.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewTitle;
        //public TextView textViewDescription;

        public ViewHolder( View itemView) {
            super(itemView);

            textViewTitle = (TextView) itemView.findViewById(R.id.title_textView);
            //textViewDescription = (TextView) itemView.findViewById(R.id.description_textView);

        }
    }


}
