package crescendo.com.crescendoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Brandon on 5/18/2017.
 */

public class UserHome  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhome);
    }
    public void view(View view)
    {
        Intent myIntent = new Intent(UserHome.this, UserData.class);
        startActivity(myIntent);
    }
    public void record(View view)
    {
        Intent myIntent = new Intent(UserHome.this, Record.class);
        startActivity(myIntent);
    }
    public void tune(View view)
    {
        Intent myIntent = new Intent(UserHome.this, Tune.class);
        startActivity(myIntent);
    }
    public void metronome(View view)
    {
        Intent myIntent = new Intent(UserHome.this, Metronome.class);
        startActivity(myIntent);
    }
    public void chords(View view)
    {
        Intent myIntent = new Intent(UserHome.this, Chords.class);
        startActivity(myIntent);
    }
    public void scales(View view)
    {
        Intent myIntent = new Intent(UserHome.this, Scales.class);
        startActivity(myIntent);
    }
}
