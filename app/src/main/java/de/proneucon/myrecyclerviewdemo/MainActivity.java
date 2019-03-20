package de.proneucon.myrecyclerviewdemo;
/**
 * My-Recycler-View
 * implementieren der dependencies für die RecyclerView
 * <p>
 * für die Items eine Layoutdatei anlegen
 * <p>
 * Basteln der Klasse Person
 * Elemente angeben
 */

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //MEMBER
    RecyclerView recyclerView;
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager rvLayoutManager;

    static ArrayList<Person> personArrayList;    //!die Arraylist wird mit den vorhandenen Daten gefüllt (static zum verwenden in dem RvAdapter)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //INITIALISIERUNGEN
        personArrayList = new ArrayList<>();
        personArrayList.addAll(Arrays.asList(               //Dummy-Personen erstellen
                new Person("Max", "Berlin"),
                new Person("Frank", "Hamburg"),
                new Person("Paul", "Bremen"),
                new Person("Mia", "Bonn"),
                new Person("Moritz", "Hamburg")
        ));

        recyclerView = findViewById(R.id.recyclerView);
        rvLayoutManager = new LinearLayoutManager(this);   //LAYOUT-MANAGER

        //Adapter wird initialisiert/gebaut
        rvAdapter = new RvAdapter();        //extern eine neue Klasse RvAdapter() definieren
        recyclerView.setAdapter(rvAdapter); //rv den Adapter geben


    }
}
