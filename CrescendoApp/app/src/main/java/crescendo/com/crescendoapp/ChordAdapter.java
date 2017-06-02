package crescendo.com.crescendoapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by chance on 6/2/2017.
 */

public class ChordAdapter extends ArrayAdapter<Drawable> {

    public ChordAdapter(Context context, ArrayList<Drawable> images)
    {
        super(context, 0, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Drawable image = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_chord, parent, false);
        }
        ImageView chordImg = (ImageView)convertView.findViewById(R.id.chordImage);
        chordImg.setImageDrawable(image);

        return convertView;
    }

}
