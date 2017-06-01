package crescendo.com.crescendoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import github.bewantbe.audio_analyzer_for_android.AnalyzerActivity;

/**
 * Created by Brandon on 5/18/2017.
 */

public class UserHome  extends AppCompatActivity {
    DBHandler dbHandler = new DBHandler();
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhome);
        //get id here
        TextView username = (TextView) findViewById(R.id.username);
        int userid = -1;
        userid = getIntent().getIntExtra("User_id", userid);
        user = dbHandler.GetsUserByID(userid);
        username.append(""+user.getUsername());
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
        Intent myIntent = new Intent(UserHome.this, AnalyzerActivity.class);
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

}
