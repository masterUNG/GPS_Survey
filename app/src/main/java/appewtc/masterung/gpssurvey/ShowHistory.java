package appewtc.masterung.gpssurvey;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ShowHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);

        ListView listView = (ListView) findViewById(R.id.listView2);

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.DATABASE_NAME,
                MODE_PRIVATE, null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + ManageTABLE.plate_table, null);
        cursor.moveToFirst();
        String[] nameStrings = new String[cursor.getCount()];
        String[] areaStrings = new String[cursor.getCount()];
        String[] dateStrings = new String[cursor.getCount()];

        for (int i=0;i<cursor.getCount();i++) {

            nameStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Name));
            areaStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Area));
            dateStrings[i] = cursor.getString(cursor.getColumnIndex(ManageTABLE.column_Date));

            cursor.moveToNext();
        }
        cursor.close();

        HistoryAdapter historyAdapter = new HistoryAdapter(this, nameStrings,
                areaStrings, dateStrings);
        listView.setAdapter(historyAdapter);



    }   // Main Method

}   // Main Class
