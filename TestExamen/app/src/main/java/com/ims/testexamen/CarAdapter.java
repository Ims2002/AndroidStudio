package com.ims.testexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private final Car[] cars;
    private final Context context;
    private final IOnClickListener listener;

    public CarAdapter(Car[] cars, Context context, IOnClickListener listener) {
        this.cars = cars;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car,parent,false);
        return new CarViewHolder(itemView,context,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = cars[position];
        holder.bindCar(car);
    }

    @Override
    public int getItemCount() {
        return cars.length;
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tvCarName;
        private final TextView tvCarCode;
        private final TextView tvKm;
        private final TextView tvFabricadoEn;
        private final Context context;
        private final IOnClickListener listener;

        public CarViewHolder(@NonNull View itemView,Context context,IOnClickListener listener) {
            super(itemView);

            this.context = context;
            this.listener = listener;

            tvCarCode = itemView.findViewById(R.id.tvCode);
            tvCarName = itemView.findViewById(R.id.tvName);
            tvKm = itemView.findViewById(R.id.tvKm);
            tvFabricadoEn = itemView.findViewById(R.id.tvFabricadoEn);

            itemView.setOnClickListener(this);
        }

        public void bindCar(Car car) {
            //si hay img's
            //try {
                /*
                 * Obtenemos el código de 2 caracteres del país y nos aseguramos que esté en minúsculas
                 * ya que las imágenes situadas en /res/drawable están en minúsculas.
                 * Además le añadimos el caracter "_" delante para que coincida con el nombre de los Drawables.
                 */
                /*String flagName = "_"+country.getCode().toLowerCase();
                 Obtenemos el ID del drawable (imagen de la bandera) a partir del flagName
                int resID = context.getResources().getIdentifier(flagName, "drawable", context.getPackageName());
                 Si hemos conseguido obtener el ID del drawable asociado, se lo asignamos al ImageView
                if(resID != 0) {
                    ivFlag.setImageResource(resID);
                } else {
                    flagName = "_onu";
                    resID = context.getResources().getIdentifier(flagName, "drawable", context.getPackageName());
                    ivFlag.setImageResource(resID);
                }

            } catch (Exception e) {*/
                /*
                 * Si falla la obtención del ID del drawable no hacemos nada. Simplemente se quedará
                 * con la imagen de la bandera que tenga asignada por defecto.
                 */
            //}

            /*CON INT
            /*String imgName = "hangman_"+patron num img's;
            int resID = getContext().getResources().getIdentifier(imgName,"drawable",getContext().getPackageName());
            imageView.setImageResource(resID);*/


            //SOLO NECESITO LOS DATOS QUE SE VAYAN A CARGAR EN EL LISTADO

            tvCarName.setText(car.getCarName());
            //tvKm.setText(String.valueOf(car.getKm()));
            tvCarCode.setText(car.getCarCode());
            //tvFabricadoEn.setText(car.getFabricadoEn());
        }

        @Override
        public void onClick(View view) {
            if(listener != null) {
                listener.onClick(getAdapterPosition());
            }
        }
    }


}
