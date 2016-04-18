package appewtc.masterung.gpssurvey;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ShowDetail extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView nameTextView, dateTextView, areaTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_detail);

        //Bind Widget
        bindWidget();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map2);
        mapFragment.getMapAsync(this);

        //Show View
        showView();

    }   // Main Method

    private void bindWidget() {
        nameTextView = (TextView) findViewById(R.id.textView18);
        dateTextView = (TextView) findViewById(R.id.textView19);
        areaTextView = (TextView) findViewById(R.id.textView20);
    }

    private void showView() {

        String strName = getIntent().getStringExtra("Name");
        String strDate = getIntent().getStringExtra("Date");
        String strArea = getIntent().getStringExtra("Area");

        nameTextView.setText(strName);
        dateTextView.setText(strDate);
        areaTextView.setText(strArea);
    }   // showView


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }   // onMap

}   // Main Class
