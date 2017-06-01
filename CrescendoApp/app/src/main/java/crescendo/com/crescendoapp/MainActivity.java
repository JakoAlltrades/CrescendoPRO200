package crescendo.com.crescendoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        EditText user = (EditText)findViewById(R.id.username);
        EditText pass= (EditText)findViewById(R.id.password);
        String username = user.getText().toString();
        String password = pass.getText().toString();


        if(dbHandler.SignIn(username,password))
        {//if exists
            Intent myIntent = new Intent(MainActivity.this, UserHome.class);
            myIntent.putExtra("User_id", 1);
            startActivity(myIntent);
        }
        else
        {
            Toast.makeText(MainActivity.this, "User Name or password not valid",Toast.LENGTH_LONG ).show();

           // Toast.
        }
        /*
        checkDatabase(username,password);
         */
    }
    public void signUp(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, Sign_Up.class);
        startActivity(myIntent);
    }

}
