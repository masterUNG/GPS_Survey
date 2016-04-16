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
public class HistoryAdapter extends BaseAdapter{

    //Explicit
    private Context context;
    private String[] nameStrings, areaStrings, dateStrings;

    public HistoryAdapter(Context context,
                          String[] nameStrings,
                          String[] areaStrings,
                          String[] dateStrings) {
        this.context = context;
        this.nameStrings = nameStrings;
        this.areaStrings = areaStrings;
        this.dateStrings = dateStrings;
    }   // Constructor

    @Override
    public int getCount() {
        return nameStrings.length;
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
        View view1 = layoutInflater.inflate(R.layout.history_listview, viewGroup, false);

        TextView nameTextView = (TextView) view1.findViewById(R.id.textView15);
        nameTextView.setText(nameStrings[i]);

        TextView areaTextView = (TextView) view1.findViewById(R.id.textView16);
        areaTextView.setText(areaStrings[i]);

        TextView dateTextView = (TextView) view1.findViewById(R.id.textView17);
        dateTextView.setText(dateStrings[i]);

        return view1;
    }
}   // Main Class
