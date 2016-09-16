package com.example.aravindachanta.applicationa2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class IndianapolisWebfragment extends Fragment {

    private static final String TAG = "IndianapolWebfragment";

    private WebView web = null;
    private int mCurrIdx = -1;
    private int Len;

    int getShownIndex() {
        return mCurrIdx;
    }

    // load the webpage on listclick at position newIndex
    void showWebAtIndex(int newIndex) {

        mCurrIdx = newIndex;
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(IndianapolisActivity.IndianapoliswebArray[newIndex]);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");

        // Inflate the layout defined in indiana_web.xml

        return inflater.inflate(R.layout.indiana_web,
                container, false);


    }

    // Set up some information about the web WebtView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

        web = (WebView) getActivity().findViewById(R.id.indianaView);
        Len = IndianapolisActivity.IndianapoliswebArray.length;
    }

}