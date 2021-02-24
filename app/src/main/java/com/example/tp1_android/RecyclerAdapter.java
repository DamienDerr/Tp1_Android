package com.example.tp1_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.tp1_android.data.Country.countries;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] nom = {"France","Allemagne","Espagne","Afrique du Sud","Etats-Unis","Japon"};

    private String[] capital = {"Paris","Berlin","Madrid","Pretoria","Washington","Tokyo"};

    private int[] images = { R.drawable.ic_flag_of_france_320px, R.drawable.ic_flag_of_germany_320px, R.drawable.ic_flag_of_japan_320px,
            R.drawable.ic_flag_of_south_africa_320px, R.drawable.ic_flag_of_spain_320px, R.drawable.ic_flag_of_the_united_states_320px };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(countries[i].getName());
        viewHolder.itemDetail.setText(countries[i].getCapital());

        Context c = viewHolder.itemImage.getContext();
        viewHolder.itemImage.setImageDrawable(c.getResources().getDrawable(c.getResources().
                getIdentifier (countries[i].getImgUri(), null, c.getPackageName())));

    }

    @Override
    public int getItemCount() {
        return countries.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemTitle;
        TextView itemDetail;

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);

            int position = getAdapterPosition();

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    int position = getAdapterPosition();
                    /* Snackbar.make(v, "Click detected on chapter " + (position+1),
                        Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                     */
                    //// Implementation with bundle
                    // Bundle bundle = new Bundle();
                    // bundle.putInt("numChapter", position);
                    // Navigation.findNavController(v).navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);

                    ListFragmentDirections.ActionFirstFragmentToSecondFragment action = ListFragmentDirections.actionFirstFragmentToSecondFragment(position);
                    action.setCountryId(position);
                    Navigation.findNavController(v).navigate(action);
                }
            });
    }
}
}