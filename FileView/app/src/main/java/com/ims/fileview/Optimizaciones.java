package com.ims.fileview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Optimizaciones extends ArrayAdapter<Country> {
    /**
     * Falta aplicar patrón ViewHolder
     */

    static class ViewHolder {
        TextView name;
        TextView capital;
        TextView population;
        TextView cap;
        TextView pop;
        ImageView flag;
    }

    private final Country[] countries;

    public Optimizaciones(Context context, Country[] countries) {
        super(context, R.layout.listitem_country, countries);
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;
        //optimizamos la appya que ya no se crea un layout
        //completo cada vez que se hace scroll se reutilizan
        if(item == null) {

            //nos permite crear una interfaz java a partir de un xml
            LayoutInflater inflater = LayoutInflater.from(getContext());
            //pasamos el layout
            item = inflater.inflate(R.layout.listitem_country, null);

            holder = new ViewHolder();
            holder.pop = item.findViewById(R.id.tvPopulation);
            holder.cap = item.findViewById(R.id.tvCapital);
            holder.name = item.findViewById(R.id.tvCountry);
            holder.capital = item.findViewById(R.id.tvCapitalName);
            holder.flag = item.findViewById(R.id.ivFlag);
            holder.population = item.findViewById(R.id.tvPopulationNumber);

            item.setTag(holder);
        }else {
            holder = (ViewHolder) item.getTag();
        }
        holder.capital.setText(countries[position].getCapital());
        String flagName = "_"+countries[position].getCountryCode().toLowerCase();
        int resID = getContext().getResources().getIdentifier(flagName, "drawable", getContext().getPackageName());

        if(resID != 0) {
            holder.flag.setImageResource(resID);
        } else {
            flagName = "_onu";
            resID = getContext().getResources().getIdentifier(flagName, "drawable", getContext().getPackageName());
            holder.flag.setImageResource(resID);
        }
        holder.name.setText(countries[position].getCountry());
        holder.population.setText(countries[position].getPopulation());

        return (item);
/*
        ImageView ivFlag = item.findViewById(R.id.ivFlag);

        try {
            String flag = "_"+countries[position].getCountryCode().toLowerCase();
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
        return item;*/
    }
}
