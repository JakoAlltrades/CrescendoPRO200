package crescendo.com.crescendoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Brandon on 5/18/2017.
 */

public class UserData  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdata);
    }
    public void viewRecordings(View view)
    {
        Intent myIntent = new Intent(UserData.this, ViewRecordings.class);
        startActivity(myIntent);
    }
    public void viewTunings(View view)
    {
        Intent myIntent = new Intent(UserData.this, viewtune.class);
        startActivity(myIntent);
    }
}
