package com.fanjavaid.valore.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuNilaiActivity extends Activity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_nilai);

        // Get list object from xml
        listView = (ListView) findViewById(R.id.list);

        // Define Array to be exist in ListView
        String [] values = new String[] {"KHS", "Transkrip"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                Intent intent = null;

                if (itemValue.equalsIgnoreCase("khs")) {
                    intent = new Intent(MenuNilaiActivity.this, SemesterActivity.class);
                } else if (itemValue.equalsIgnoreCase("transkrip")) {
                    intent = new Intent(MenuNilaiActivity.this, MataKuliahActivity.class);
                } else {
                    intent = new Intent(MenuNilaiActivity.this, MenuNilaiActivity.class);
                }

                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nilai, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
