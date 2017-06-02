package crescendo.com.crescendoapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Brandon on 5/18/2017.
 */

public class Chords  extends AppCompatActivity {

    ChordAdapter chordAdapter;
    ArrayList<Drawable> chords;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chords);

        setUpChords();
        chordAdapter = new ChordAdapter(this, chords);

        ListView listView = (ListView) findViewById(R.id.ChordsListView);
        listView.setAdapter(chordAdapter);
    }
    private void setUpChords()
    {
        chords = new ArrayList<>();
        chords.add(ContextCompat.getDrawable(this, R.drawable.a));
        chords.add(ContextCompat.getDrawable(this, R.drawable.a7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.ab));
        chords.add(ContextCompat.getDrawable(this, R.drawable.am));
        chords.add(ContextCompat.getDrawable(this, R.drawable.apower));
        chords.add(ContextCompat.getDrawable(this, R.drawable.b));
        chords.add(ContextCompat.getDrawable(this, R.drawable.b7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.bb));
        chords.add(ContextCompat.getDrawable(this, R.drawable.bb7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.bbm));
        chords.add(ContextCompat.getDrawable(this, R.drawable.bm));
        chords.add(ContextCompat.getDrawable(this, R.drawable.c));
        chords.add(ContextCompat.getDrawable(this, R.drawable.c7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.cm));
        chords.add(ContextCompat.getDrawable(this, R.drawable.csharpm));
        chords.add(ContextCompat.getDrawable(this, R.drawable.d));
        chords.add(ContextCompat.getDrawable(this, R.drawable.d7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.db));
        chords.add(ContextCompat.getDrawable(this, R.drawable.dm));
        chords.add(ContextCompat.getDrawable(this, R.drawable.e));
        chords.add(ContextCompat.getDrawable(this, R.drawable.e7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.eb));
        chords.add(ContextCompat.getDrawable(this, R.drawable.eb7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.em));
        chords.add(ContextCompat.getDrawable(this, R.drawable.epowerchord));
        chords.add(ContextCompat.getDrawable(this, R.drawable.f));
        chords.add(ContextCompat.getDrawable(this, R.drawable.f7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.fm));
        chords.add(ContextCompat.getDrawable(this, R.drawable.fsharp));
        chords.add(ContextCompat.getDrawable(this, R.drawable.fsharp7));
        chords.add(ContextCompat.getDrawable(this, R.drawable.fsharpm));
    }
}
