package crescendo.com.crescendoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Brandon on 5/18/2017.
 */

public class Sign_Up  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }
    public void userHome(View view)
    {
        if(newUser())
        {
            Intent myIntent = new Intent(Sign_Up.this, UserHome.class);
            startActivity(myIntent);
        }
        else
        {
            Toast.makeText(Sign_Up.this, "UserName is taken, or passwords do not match", Toast.LENGTH_LONG).show();
        }
    }
    public boolean newUser()
    {
        EditText first = (EditText)findViewById(R.id.password);
        EditText second= (EditText)findViewById(R.id.passwordConf);
        if(first.getText().toString().equals(second.getText().toString()))
        {
            //database check
            return true;
        }
        else
        {
            return false;
        }

    }

}
