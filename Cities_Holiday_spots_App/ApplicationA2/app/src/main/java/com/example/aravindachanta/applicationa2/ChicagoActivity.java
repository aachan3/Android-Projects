package com.example.aravindachanta.applicationa2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class ChicagoActivity extends AppCompatActivity implements
        ChicagoListfragment.ListSelectionListener {

    public static String[] ChicagolistArray;
    public static String[] ChicagowebArray;


    private final ChicagoWebfragment Chicagowebfragment = new ChicagoWebfragment();
    private FragmentManager mFragmentManager;
    private FrameLayout ChicagoListFrameLayout, ChicagoWebFragmentLayout;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
    private static final String TAG = "ChicagoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ChicagolistArray = getResources().getStringArray(R.array.chicago_titles);
        ChicagowebArray = getResources().getStringArray(R.array.chicago_links);
        setContentView(R.layout.activity_chicago);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ChicagoListFrameLayout = (FrameLayout) findViewById(R.id.chicagolist_fragment);
        ChicagoWebFragmentLayout = (FrameLayout) findViewById(R.id.chicagoweb_fragment);

        mFragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();

        // Add the ChicagoListFragment to the layout
        fragmentTransaction.add(R.id.chicagolist_fragment,
                new ChicagoListfragment());

        fragmentTransaction.addToBackStack(null);
        // Commit the FragmentTransaction
        fragmentTransaction.commit();

        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });

    }
    private void setLayout() {

        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT) {
            // Determine whether the Chicagowebfragment has been added
            if (!Chicagowebfragment.isAdded()) {

                // Make the ChicagoListFrameLayout occupy the entire layout
                ChicagoListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                ChicagoWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {


                ChicagoListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));

                // Make the ChicagowebFragmentLayout take full of the layout's width
                ChicagoWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));

            }
        }
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            if (!Chicagowebfragment.isAdded()) {

                // Make the ChicagoListFrameLayout occupy the entire layout
                ChicagoListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                ChicagoWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {

                // Make the ChicagoListFrameLayout take 1/3 of the layout's width
                ChicagoListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 1f));

                // Make the ChicagowebFragmentLayout take 2/3's of the layout's width
                ChicagoWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        0, MATCH_PARENT, 2f));

            }

        }
    }
    @Override
    public void onConfigurationChanged(Configuration newconfig)
    {
        //when screen orientation changes
        super.onConfigurationChanged(newconfig);
        //If changed to Landscape
        if(newconfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
             //if the web fragment is present in portrait
            if(Chicagowebfragment.isAdded())
            {
                //set listfragment to 1/3's of layout width and web fragment to 2/3's of layout width
                ChicagoListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 1f));
                ChicagoWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 2f));
            }

        }
        else
        {//set listfragment to 0's of layout width and web fragment to full of layout width
            if(Chicagowebfragment.isAdded()) {
                ChicagoListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
                ChicagoWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT));
            }
        }

    }
    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {

        // If the Chicagowebfragment has not been added, add it now
        if (!Chicagowebfragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            // Add the webFragment to the layout
            fragmentTransaction.add(R.id.chicagoweb_fragment,
                    Chicagowebfragment);

            fragmentTransaction.addToBackStack(null);


            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        }

        if (Chicagowebfragment.getShownIndex() != index) {

            // Tell the webFragment to show the webpage at position index
            Chicagowebfragment.showWebAtIndex(index);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chicago, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //start Activiy for the other city
        if (id == R.id.chic_settings) {
            Intent k = new Intent(this,IndianapolisActivity.class);

            k.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(k);
        }

        return super.onOptionsItemSelected(item);
    }
    //on BackPressed modified to interact with fragments in activity
    @Override
    public void onBackPressed() {
        //get the count of stackentries of fragment
        int k = getFragmentManager().getBackStackEntryCount();
        //if no entry left close the activity
        if(k==1)
        {
            super.onBackPressed();
        }
        else
        //pop the fragments in a stack
            getFragmentManager().popBackStack();
    }

}
