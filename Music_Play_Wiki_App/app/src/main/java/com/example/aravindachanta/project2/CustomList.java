package com.example.aravindachanta.project2;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aravindachanta on 2/18/16.
 */
//Defining a custom adapter using Arrayadapter
public class CustomList extends ArrayAdapter<String>{

    String[] Heading;
    String[] SubHeading;
    Integer[] image_id;
    Context context;
    //Defining the constructor and setting the string values from MainActivity to defined variables
    public CustomList(Activity context, Integer[] image_id, String[] text, String[] subtext) {

        super(context, R.layout.list_view,text);
        this.context = context;
        this.Heading = text;
        this.SubHeading = subtext;
        this.image_id = image_id;
    }
    //Function to inflate the List view using the adapter
     public View getView(int position, View view, ViewGroup parent)
     {

         LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         //inflate the list view and set each one to rview
         View rview= inflater.inflate(R.layout.list_view, null, true);
         //getting the views from list_view
         TextView txt = (TextView) rview.findViewById(R.id.title);
         TextView subtxt = (TextView) rview.findViewById(R.id.description);
         ImageView image = (ImageView) rview.findViewById(R.id.icon);
         //setting the values defined from constructor to the above defined variables
         txt.setText(Heading[position]);
         subtxt.setText(SubHeading[position]);
         image.setImageResource(image_id[position]);
         return rview;

     }
    }


