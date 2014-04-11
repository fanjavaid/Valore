package com.fanjavaid.valore.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doLogin();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void doLogin() {
        EditText txtNpm = (EditText) findViewById(R.id.textNpm);
        String strNpm = txtNpm.getText().toString();

        String message = null;

        Context ctx = getApplicationContext();
        Toast toast = null;

        if (strNpm.equals("")) {
            message = "Please insert NPM!";
            toast = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
            toast.show();
        } else {
            //201143579091
            if (strNpm.length() < 12) {
                message = "Not Valid NPM!";
                toast = Toast.makeText(ctx, message, Toast.LENGTH_LONG);
                toast.show();
            } else {
                Intent intent = new Intent(this, MenuNilaiActivity.class);
                startActivity(intent);
            }
        }
    }

}
