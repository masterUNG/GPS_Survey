package appewtc.masterung.gpssurvey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by masterUNG on 4/16/16 AD.
 */
public class SaveAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] pointStrings, latStrings, lngStrings;

    public SaveAdapter(Context context,
                       String[] pointStrings,
                       String[] latStrings,
                       String[] lngStrings) {
        this.context = context;
        this.pointStrings = pointStrings;
        this.latStrings = latStrings;
        this.lngStrings = lngStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return latStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.save_listview, viewGroup, false);

        TextView pointTextView = (TextView) view1.findViewById(R.id.textView12);
        pointTextView.setText(pointStrings[i]);

        TextView latTextView = (TextView) view1.findViewById(R.id.textView13);
        latTextView.setText(latStrings[i]);

        TextView lngTextView = (TextView) view1.findViewById(R.id.textView14);
        lngTextView.setText(lngStrings[i]);

        return view1;
    }
}   // Main Class
