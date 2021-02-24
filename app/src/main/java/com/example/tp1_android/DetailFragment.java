package com.example.tp1_android;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import static com.example.tp1_android.data.Country.countries;

public class DetailFragment extends Fragment {

    public static final String TAG = "DetailFragment";
    TextView nom;
    TextView capitale;
    TextView superficie;
    TextView langues;
    TextView monnaie;
    TextView population;
    ImageView drapeau;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //idCountry = view.findViewById(R.id.sc);
        nom = view.findViewById(R.id.sc_nom);
        capitale = view.findViewById(R.id.sc_capitale);
        superficie = view.findViewById(R.id.sc_superficie);
        langues = view.findViewById(R.id.sc_langues);
        monnaie = view.findViewById(R.id.sc_monnaie);
        population = view.findViewById(R.id.sc_population);
        drapeau = view.findViewById(R.id.sc_drapeau);

        //// Implementation with bundle
        // textView.setText("Info in chapter "+(getArguments().getInt("numChapter")+1));

        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());

        int idCountry = args.getCountryId();
        nom.setText(countries[args.getCountryId()].getName());
        capitale.setText(countries[args.getCountryId()].getCapital());
        superficie.setText(countries[args.getCountryId()].getArea() + " km2");
        langues.setText(countries[args.getCountryId()].getLanguage());
        monnaie.setText(countries[args.getCountryId()].getCurrency());
        population.setText(countries[args.getCountryId()].getPopulation() + "");

        String uri = countries[args.getCountryId()].getImgUri();

        Context c = drapeau.getContext();
        drapeau.setImageDrawable(c.getResources().getDrawable(c.getResources().getIdentifier (uri, null , c.getPackageName())));


        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}