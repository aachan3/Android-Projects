package com.example.aravindachanta.project1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FirstActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button new_button = (Button) findViewById(R.id.send);
        //specify a listener for the send button
        new_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                EditText edit = (EditText) findViewById(R.id.input);
                String mess = edit.getText().toString();
                //Regular expression for checking the input to the editText view
                String regex = "([\\D 0-9]*)(\\([0-9]{3}\\)\\s?[0-9]{3}-[0-9]{4})([\\D 0-9]*)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(mess);
                //Select the second group from regular expression and send it to message app
                if (matcher.matches()) {
                    edit.setText(matcher.group(2));
                    //Creating a Toast
                    Context context = getApplicationContext();
                    CharSequence text = "Opening Compose Message App";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    send_message();
                } else {
                    //Creating a Toast
                    Context context = getApplicationContext();
                    CharSequence text = "Pattern not recognized,should be in the format of (xxx) xxx-xxxx";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
        return true;
    }

   //Code for invoking the Message App from FirstActivity
    protected void send_message()
    {
        EditText editText= (EditText) findViewById(R.id.input);
        Uri uri = Uri.parse("smsto:" + editText.getText().toString());

        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

        // start the implicit intent
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



   //function used when user returns to FirstActivity
    public void onRestart(){
        super.onRestart();
        EditText edit = (EditText) findViewById(R.id.input);
        edit.setText("Returning from Compose message");
    }

}
