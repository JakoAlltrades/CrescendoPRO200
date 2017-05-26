package crescendo.com.crescendoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        dbHandler = new DBHandler();
    }
    public void userHome(View view)
    {
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);
        /*
        checkDatabase(username,password);
         */
        Intent myIntent = new Intent(MainActivity.this, UserHome.class);
        startActivity(myIntent);
    }
    public void signUp(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, Sign_Up.class);
        startActivity(myIntent);
    }

}
