package com.example.aravindachanta.project2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Song title string array
    String[] text = {
          "Coming Home",
            "Titanium",
            "The Way I are",
            "Lean On",
            "Waka Waka",
            "Firework",
            "Club Can't Handle me"
    };
    //singer description string array
    String[] subtext = {
            "Diddy-Dirty Money ft. Skylar Grey",
            "David Guetta ft. Sia",
            "Justin Timberlake ft. Keri Hilson",
            "Major Lazer and DJ Snake",
            "Shakira ft. FreshlyGround",
            "Katy Perry",
            "Flo Rida ft. David Guetta"
    };
    //integer array containing drawable id's of images
    Integer[] image_id = {
            R.drawable.pic_1,
            R.drawable.pic_2,
            R.drawable.pic_3,
            R.drawable.pic_4,
            R.drawable.pic_5,
            R.drawable.pic_6,
            R.drawable.pic_7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //object for CustomList adapter...representation of strings in constructor
        CustomList adapter = new CustomList(this, image_id, text, subtext);
        //calling the list view from context_main.xml
        ListView lv = (ListView) findViewById(R.id.list);
        //setting the list view lv to custom adapter object
        lv.setAdapter(adapter);
        //registering the list view lv for context menu
        registerForContextMenu(lv);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting on click listener for the list view lv
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // switch statement using the position(starting from 0) of all the lists in the view
                switch (position)
                {
                    //cases for different links pertaining to youtube watchable songs
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=k-ImCpNqbJw")));
                        break;

                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=JRfuAukYTKg")));
                        break;

                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=U5rLz5AZBIA")));
                        break;

                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=YqeW9_5kURI")));
                        break;

                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=pRpeEdMmmQ0")));
                        break;

                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=QGJuMBdaqIw")));
                        break;

                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=SgM3r8xKfGE")));
                        break;
                    default:
                        break;
                }
            }
        });


    }
    @Override
    //create the menu on longclick using context_menu(has 3 options)
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater m = getMenuInflater();
        m.inflate(R.menu.context_menu, menu);

    }
    @Override
    //Selecting one of the 3 options in the context menu
    public boolean onContextItemSelected(MenuItem item)
    {
        //Getting the item.getMenuInfo() which is the previous list item clicked to get the context menu
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()) {
            //If the 1st option is selected
            case R.id.video:
                //position of the list item in the list view which has been clicked
                switch(menuInfo.position) {
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=k-ImCpNqbJw")));
                        break;

                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=JRfuAukYTKg")));
                        break;

                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=U5rLz5AZBIA")));
                        break;

                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=YqeW9_5kURI")));
                        break;

                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=pRpeEdMmmQ0")));
                        break;

                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=QGJuMBdaqIw")));
                        break;

                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://www.youtube.com/watch?v=SgM3r8xKfGE")));
                        break;
                    default:
                        break;
                }
                break;
            //if second link is clicked in the context menu
            case R.id.song_wikis:

                switch(menuInfo.position) {
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Coming_Home_(Diddy_–_Dirty_Money_song)")));
                        break;

                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Titanium_(song)")));
                        break;

                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/The_Way_I_Are")));
                        break;

                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Lean_On")));
                        break;

                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Waka_Waka_(This_Time_for_Africa)")));
                        break;

                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Firework_(song)")));
                        break;

                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Club_Can%27t_Handle_Me")));
                        break;
                    default:
                        break;
                }
                break;// Show message


            //If 3rd link is selected from the context menu
            case R.id.composer_wikis:
                switch(menuInfo.position) {
                    case 0:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Diddy_–_Dirty_Money")));
                        break;

                    case 1:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/David_Guetta")));
                        break;

                    case 2:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Timbaland")));
                        break;

                    case 3:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Major_Lazer")));
                        break;

                    case 4:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Shakira")));
                        break;

                    case 5:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Katy_Perry")));
                        break;

                    case 6:
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("https://en.wikipedia.org/wiki/Flo_Rida")));
                        break;
                    default:
                        break;
                }
                break; // Show message


        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
}
