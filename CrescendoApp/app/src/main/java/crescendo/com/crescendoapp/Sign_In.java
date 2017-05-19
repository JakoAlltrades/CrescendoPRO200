package crescendo.com.crescendoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Brandon on 5/18/2017.
 */

public class Sign_In  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
    }

    public void userHome(View view)
    {
        Intent myIntent = new Intent(Sign_In.this, UserHome.class);
        startActivity(myIntent);
    }
}
