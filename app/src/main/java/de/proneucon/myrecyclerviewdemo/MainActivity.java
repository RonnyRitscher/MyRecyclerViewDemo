package de.proneucon.myrecyclerviewdemo;
/**
 * My-Recycler-View
 * implementieren der dependencies für die RecyclerView
 * <p>
 * für die Items eine Layoutdatei anlegen
 * <p>
 * Basteln der Klasse Person
 * Elemente angeben
 *
 *
 * !! Wenn in dem ItemLayout die TextViews auf MatchConstraind gesetzt sind, wird die Liste nicht angezeigt!!!
 * !! Lösung: die rechte Constraint des Items muss gelöscht werden, dann ist matchConstraind verwendbar!!!
 */


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


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
                new Person("Max", "Berlin" , 1),
                new Person("Frank", "Hamburg",2),
                new Person("Paul", "Bremen",3),
                new Person("Mia", "Bonn",4),
                new Person("Moritz", "Hamburg",5),
                new Person("Max", "Berlin",6),
                new Person("Frank", "Hamburg",7),
                new Person("Paul", "Bremen",8)

        ));

        recyclerView = findViewById(R.id.recyclerView);

        //ITEM-DECORATION:    verändern der enthaltenen Items****************************************************************
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(10,10,10,10);  //setzt den äußeren Abstand

            }

            //Wir ändern die Items und lassen einen Rand anzeigen in Farbe
            @Override
            public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDrawOver(c, parent, state);
                RecyclerView.LayoutManager layoutManager = parent.getLayoutManager(); //holt den Layoutmanager
                //schleife für alle Elemente:
                for(int i=0; i<parent.getChildCount();i++){
                    View child = parent.getChildAt(i);
                    //Farbe definieren
                    Paint paintCyan = new Paint();
                    paintCyan.setAntiAlias(true);
                    paintCyan.setColor(Color.CYAN);
                    paintCyan.setStyle(Paint.Style.STROKE);
                    paintCyan.setStrokeWidth(5);

                    //Da ab lev 21 surround with version control
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        //Canvas zeichnen - achte auch die richtige angabe
                        c.drawRoundRect(        //c ist das Canvas
                                layoutManager.getDecoratedLeft(child)+10,   //Abstand zu den anderen Elementen
                                layoutManager.getDecoratedTop(child)+10,
                                layoutManager.getDecoratedRight(child)-10,
                                layoutManager.getDecoratedBottom(child)-10,
                                20,  //Rundungen
                                20,
                                paintCyan  //Farbe
                        );
                    }
                }
            }
        });

        //LAYOUT-MANAGER:****************************************************************
        /* layoutManager - normale Ansicht: */
//        rvLayoutManager = new LinearLayoutManager(this);

        /* layoutManager - erweiterung: elemente nebeneinander *** reverse: false zeigt den ersten Eintrag, true springt auf den letzten Eintrag */
//        rvLayoutManager = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);

        /* verwenden von GRID-LAYOUT anzeigen der Items über Grid nebeneinander (für bsp: Landscape) */
        rvLayoutManager = new GridLayoutManager(this , 3); //

        //ADAPTER: Adapter wird initialisiert/gebaut****************************************************************
        rvAdapter = new RvAdapter();                        //extern eine neue Klasse RvAdapter() definieren

        //Übergeben von LAYOUT und ADAPTER****************************************************************
        recyclerView.setLayoutManager(rvLayoutManager);     //rv den LayoutManager übergeben
        recyclerView.setAdapter(rvAdapter);                 //rv den Adapter geben


    }
}
