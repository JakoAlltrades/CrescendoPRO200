package crescendo.com.crescendoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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
        EditText username = (EditText)findViewById(R.id.username);
        EditText password = (EditText)findViewById(R.id.password);
        /*
        checkDatabase(username,password);
         */
        Intent myIntent = new Intent(Sign_In.this, UserHome.class);
        startActivity(myIntent);
    }
    /*
    public void checkDatabase(String username, String password)
    {
    if(//getDataByUsername(username)//return boolean)
    //if(//getDataByPassword(password))

     */

}
