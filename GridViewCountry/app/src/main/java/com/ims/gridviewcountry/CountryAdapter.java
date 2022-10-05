package com.ims.gridviewcountry;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ims.gridviewcountry.Country;

public class CountryAdapter extends ArrayAdapter<Country> {

    static class ViewHolder {
        ImageView flag;
        TextView capital;
        TextView population;
    }

    private final Country[] countries;

    public CountryAdapter(@NonNull Context context, Country[] countries) {
        super(context,R.layout.gridlayout_item,countries);
        this.countries = countries;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;

        if(item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.gridlayout_item,null);

            holder = new ViewHolder();
            holder.capital = item.findViewById(R.id.tvCapitalName);
            holder.population = item.findViewById(R.id.tvPopulationNumber);
            holder.flag = item.findViewById(R.id.ivFlag);

            item.setTag(holder);
        }else{
            holder = (ViewHolder) item.getTag();
        }

        holder.capital.setText(countries[position].getCapital());
        holder.population.setText(countries[position].getPopulation());
        String flagName = "_"+countries[position].getCountryCode().toLowerCase();
        int resID = getContext().getResources().getIdentifier(flagName, "drawable", getContext().getPackageName());

        if(resID != 0) {
            holder.flag.setImageResource(resID);
        } else {
            flagName = "_onu";
            resID = getContext().getResources().getIdentifier(flagName, "drawable", getContext().getPackageName());
            holder.flag.setImageResource(resID);
        }
        return item;
    }
}
