package course.examples.Services.KeyClient;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class transactionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Intent i = getIntent();
        String[] res = i.getStringArrayExtra("result");

        ListView listt= (ListView) findViewById(R.id.list);
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, res);
        listt.setAdapter(itemsAdapter);
    }
}
