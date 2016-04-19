package appewtc.masterung.gpssurvey;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

public class ShowDetail extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private TextView nameTextView, dateTextView, areaTextView;
    private LatLng[] pointLatLngs;
    private String strName;

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

        //Create Marker
        createMarker();

    }   // Main Method

    private void createMarker() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase
                .rawQuery("SELECT * FROM surveyTABLE WHERE Name = " + "'" + strName + "'", null);
        cursor.moveToFirst();
        pointLatLngs = new LatLng[cursor.getCount()];

        for (int i=0;i<cursor.getCount();i++) {

            pointLatLngs[i] = new LatLng(Double.parseDouble(cursor.getString(4)),
                    Double.parseDouble(cursor.getString(5)));
            cursor.moveToNext();

        }   // for
        cursor.close();

    }   // createMarker

    private void bindWidget() {
        nameTextView = (TextView) findViewById(R.id.textView18);
        dateTextView = (TextView) findViewById(R.id.textView19);
        areaTextView = (TextView) findViewById(R.id.textView20);
    }

    private void showView() {

        strName = getIntent().getStringExtra("Name");
        String strDate = getIntent().getStringExtra("Date");
        String strArea = getIntent().getStringExtra("Area");

        nameTextView.setText(strName);
        dateTextView.setText(strDate);
        areaTextView.setText("Area = " + strArea);
    }   // showView


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pointLatLngs[0], 16));

        PolygonOptions polygonOptions = new PolygonOptions()
                .strokeWidth(10)
                .strokeColor(Color.RED)
                .fillColor(Color.argb(50, 148, 194, 72));

        for (int i=0;i<pointLatLngs.length;i++) {
            polygonOptions.add(pointLatLngs[i]);
        }   // for
        mMap.addPolygon(polygonOptions);

    }   // onMap

}   // Main Class
