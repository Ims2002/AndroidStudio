package com.ims.fileview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CountryAdapter extends ArrayAdapter<Country> {

    private final Country[] countries;

    public CountryAdapter(Context context, Country[] countries) {
        super(context, R.layout.listitem_country, countries);
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //nos permite crear una interfaz java a partir de un xml
        LayoutInflater inflater = LayoutInflater.from(getContext());
        //pasamos el layout
        View item = inflater.inflate(R.layout.listitem_country, null);
        ImageView ivFlag = item.findViewById(R.id.ivFlag);

        try {
            String flagName = "_"+countries[position].getCountryCode().toLowerCase();
            int resID = getContext().getResources().getIdentifier(flagName, "drawable", getContext().getPackageName());

            if(resID != 0) {
                ivFlag.setImageResource(resID);
            } else {
                flagName = "_onu";
                resID = getContext().getResources().getIdentifier(flagName, "drawable", getContext().getPackageName());
                ivFlag.setImageResource(resID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //asignamos los datos al item para rellenar el layout

        //convertimos siempre los numeros a string para que no los tome como una referencia
        TextView tvCountryPopulation = item.findViewById(R.id.tvPopulationNumber);
        tvCountryPopulation.setText(countries[position].getPopulation());

        TextView tvCountryCapital = item.findViewById(R.id.tvCapitalName);
        tvCountryCapital.setText(countries[position].getCapital());

        TextView tvCountryName = item.findViewById(R.id.tvCountry);
        tvCountryName.setText(countries[position].getCountry());

        //el item es el layout rellenado
        return item;
    }
}
