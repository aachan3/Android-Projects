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

//Several Activity and Fragment lifecycle methods are instrumented to emit LogCat output
//so you can follow the class' lifecycle
public class ChicagoWebfragment extends Fragment {

    private static final String TAG = "ChicagoWebfragment";

    private WebView mView = null;
    private int mCurrIdx = -1;
    private int mArrLen;

    int getShownIndex() {
        return mCurrIdx;
    }

    // load the url when link is pressed at position newIndex
    void showWebAtIndex(int newIndex) {

        mCurrIdx = newIndex;
        mView.setWebViewClient(new WebViewClient());
        mView.loadUrl(ChicagoActivity.ChicagowebArray[newIndex]);
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

        // Inflate the layout defined in chicago_web.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.chicago_web,
                container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

        mView = (WebView) getActivity().findViewById(R.id.webView);
        mArrLen = ChicagoActivity.ChicagowebArray.length;
    }

}