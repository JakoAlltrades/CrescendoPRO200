package crescendo.com.crescendoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signIn(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, Sign_In.class);
        startActivity(myIntent);
    }
    public void signUp(View view)
    {
        Intent myIntent = new Intent(MainActivity.this, Sign_Up.class);
        startActivity(myIntent);
    }

}
