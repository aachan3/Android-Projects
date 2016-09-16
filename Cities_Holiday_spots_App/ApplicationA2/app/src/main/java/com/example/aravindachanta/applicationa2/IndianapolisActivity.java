package com.example.aravindachanta.applicationa2;

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

public class IndianapolisActivity extends AppCompatActivity implements
        IndianapolisListfragment.inListSelectionListener {

    public static String[] IndianapolislistArray;
    public static String[] IndianapoliswebArray;


    private final IndianapolisWebfragment indianapolisWebfragment = new IndianapolisWebfragment();
    private FragmentManager mfragmentManager;
    private FrameLayout IndianaListFrameLayout, IndianaWebFragmentLayout;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
    private static final String TAG = "IndianapolisActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IndianapolislistArray = getResources().getStringArray(R.array.indiana_titles);
        IndianapoliswebArray = getResources().getStringArray(R.array.indiana_links);
        setContentView(R.layout.activity_indianapolis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        IndianaListFrameLayout = (FrameLayout) findViewById(R.id.indianpolislist_fragment);
        IndianaWebFragmentLayout = (FrameLayout) findViewById(R.id.indianapolisweb_fragment);

        mfragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTrans = mfragmentManager
                .beginTransaction();

        // Add the indianapolisListFragment to the layout
        fragmentTrans.add(R.id.indianpolislist_fragment,
                new IndianapolisListfragment());
        fragmentTrans.addToBackStack(null);
        // Commit the FragmentTransaction
        fragmentTrans.commit();

        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mfragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });

    }
    private void setLayout() {

        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_PORTRAIT) {
            // Determine whether the indianapoliswebFragment has been added
            if (!indianapolisWebfragment.isAdded()) {

                // Make the indianapolisListFragment occupy the entire layout
                IndianaListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                IndianaWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {

                // Make the IndianaListFrameLayout take 1/3 of the layout's width
                IndianaListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));

                // Make the IndianawebFragmentLayout take 2/3's of the layout's width
                IndianaWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));

            }
        }
        if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            if (!indianapolisWebfragment.isAdded()) {

                // Make the IndianaListFrame occupy the entire layout
                IndianaListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        MATCH_PARENT, MATCH_PARENT));
                IndianaWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
            } else {

                // Make the IndianaListFrameLayout take 1/3 of the layout's width
                IndianaListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 1f));

                // Make the IndianaWebFragmentLayout take 2/3's of the layout's width
                IndianaWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(
                        0, MATCH_PARENT, 2f));

            }

        }
    }
    @Override
    public void onConfigurationChanged(Configuration newconfig)
    { //when screen orientation changes
        super.onConfigurationChanged(newconfig);
        //if the web fragment is present in portrait
        if(newconfig.orientation==Configuration.ORIENTATION_LANDSCAPE){

            if(indianapolisWebfragment.isAdded())
            {
                //set Indianalistfragment to 1/3's of layout width and web fragment to 2/3's of layout width
                IndianaListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 1f));
                IndianaWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT, 2f));
            }

        }
        else
        {    //set indianalistfragment to 0's of layout width and indiana web fragment to full of layout width
            if(indianapolisWebfragment.isAdded()) {
                IndianaListFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                        MATCH_PARENT));
                IndianaWebFragmentLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                        MATCH_PARENT));
            }
        }

    }
    // Called when the user selects an item in the indianalistFragment
    @Override
    public void onListSelection(int index) {

        // If the IndianawebFragment has not been added, add it now
        if (!indianapolisWebfragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mfragmentManager
                    .beginTransaction();

            // Add the indianpoliswebFragment to the layout
            fragmentTransaction.add(R.id.indianapolisweb_fragment,
                    indianapolisWebfragment);

            // Add this FragmentTransaction to the backstack
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            mfragmentManager.executePendingTransactions();
        }

        if (indianapolisWebfragment.getShownIndex() != index) {

            // Tell the webFragment to show the webpage at position index
            indianapolisWebfragment.showWebAtIndex(index);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_indiana, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.indiana_settings) {
            Intent k = new Intent(this,ChicagoActivity.class);

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
        if (k == 1) {
            //if no entry left close the activity
            super.onBackPressed();
        } else
            //pop the fragments in a stack
            getFragmentManager().popBackStack();
    }
}

