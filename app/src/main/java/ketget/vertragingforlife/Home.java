package ketget.vertragingforlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

import java.util.Collections;

public class Home extends AppCompatActivity {
    Button addVertraging;
    Button resetKnop ;
    TextView displayVertraging;
    private int vertraging = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        addVertraging = findViewById(R.id.addvertraging);
        displayVertraging = findViewById(R.id.displayvertraging);
        resetKnop = findViewById(R.id.resetKnop);


        addVertraging.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                vertraging += 1;
                displayVertraging.setText(Integer.toString(vertraging));
            }
        });

        resetKnop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View d) {
                vertraging = 0;
                displayVertraging.setText(getString(R.string.counterNull));
            }
        });

        Spinner stationVertrek = findViewById(R.id.stationVertrek);
        ArrayAdapter<String> adapterStations = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.stationVertrek));
        adapterStations.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) ;
        stationVertrek.setAdapter(adapterStations);

        Spinner stationAankomst = findViewById(R.id.stationAankomst);
        stationAankomst.setAdapter(adapterStations);




    }
}