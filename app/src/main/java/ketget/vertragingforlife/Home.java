package ketget.vertragingforlife;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.content.SharedPreferences;



import java.util.Collections;

public class Home extends AppCompatActivity {
    SharedPreferences sharedpreferences ;
    Button addVertraging;
    Button resetKnop ;
    TextView displayVertraging;
    private int vertraging = 0;
    public static final  String mypreference = "mypref" ;
    public static final  String  vertragingkey = "vertragingkey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addVertraging = findViewById(R.id.addvertraging);
        displayVertraging = findViewById(R.id.displayvertraging);
        resetKnop = findViewById(R.id.resetKnop);

        sharedpreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if (sharedpreferences.contains(vertragingkey)) {
            vertraging = sharedpreferences.getInt(vertragingkey, -1);
            if (vertraging != 0) {
                displayVertraging.setText(Integer.toString(vertraging));
            }
        }
        else {
            displayVertraging.setText(getString(R.string.counterNull));
        }

        //VERTRAGINGSKNOP
        addVertraging.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vertraging += 1;
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt(vertragingkey,vertraging);
                editor.apply();

                displayVertraging.setText(Integer.toString(vertraging));
            }
        });
        //RESETTEN
        resetKnop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View d) {
                vertraging = 0;
                displayVertraging.setText(getString(R.string.counterNull));
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt(vertragingkey,vertraging);
                editor.apply();
            }
        });

        //STATIONSLIJST aanmaken
        ArrayAdapter<String> adapterStations = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.stationVertrek));
        adapterStations.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) ;


        // Keuzelijst vertrek station aanmaken
        Spinner stationVertrek = findViewById(R.id.stationVertrek);
        stationVertrek.setAdapter(adapterStations);
        //Keuzelijst aankomst station aanmaken
        Spinner stationAankomst = findViewById(R.id.stationAankomst);
        stationAankomst.setAdapter(adapterStations);





    }
}