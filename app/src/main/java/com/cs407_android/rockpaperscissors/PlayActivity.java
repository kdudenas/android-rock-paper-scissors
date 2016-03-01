package com.cs407_android.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //KAD add toolbar
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        //TA implementation
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, PlayFragment.newInstance(null, null))
                .addToBackStack(null) //KAD can either pass null or opt name for this backtrack
                .commit();
        //TA end
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    //KAD handle menu item clicks too
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch(item.getItemId()){
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI
                Intent other=new Intent(this, SettingsActivity.class); //we want to start a new activity, SettingsActivity
                startActivity(other);
                return true;
            // The action bar will automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            default: return super.onOptionsItemSelected(item);
        }
    }
}
