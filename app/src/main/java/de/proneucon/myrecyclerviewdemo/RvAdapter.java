package de.proneucon.myrecyclerviewdemo;

/**
 * Adapter für die RecyclerView
 */
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder>  {

    private static final String TAG = RvAdapter.class.getSimpleName(); //LOG-TAG



    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //wir brauchen die View  über das erstellte Layouut für die Items der RV
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recyclerview_layout , null);

        return new ViewHolder(itemView);   // wir erzeugen ein neuen VH und geben diesen zurück
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder viewHolder, int i) {
        // besogt die Daten aus der DummyListe
        viewHolder.itemName.setText(MainActivity.personArrayList.get(i).getName()); //Liest den Name aus der AL für jeden Eintrag
        viewHolder.itemCity.setText(MainActivity.personArrayList.get(i).getCity()); //Liest den City aus der AL für jeden Eintrag
        int id = MainActivity.personArrayList.get(i).getId();

        //Hier können wir die Elemente anklicken
        viewHolder.itemView.setOnClickListener( (v) -> {
            Log.d(TAG, "onBindViewHolder: aus dem ViewAdapter :" + i + " wurde angewählt");
            viewHolder.isClicked = !viewHolder.isClicked;       //wechselt das BooleanFlag
            v.setBackgroundColor(viewHolder.isClicked ? Color.GREEN : Color.WHITE);

        });

    }

    @Override
    public int getItemCount() {
        return MainActivity.personArrayList.size();  // Gibt die Größe der Liste an
    }



    //************************
    //Innere Klasse die die View hält und an die View zurück gibt:
    public class ViewHolder  extends RecyclerView.ViewHolder{

        //MEMBER: Wir benötigen Member
        TextView itemName, itemCity;
        Boolean isClicked;

        //CONSTRUCTOR
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.tv_item_user_name);
            itemCity = itemView.findViewById(R.id.tv_item_user_city);
            isClicked = false;
        }
    }
}
