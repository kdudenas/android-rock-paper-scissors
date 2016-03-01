package com.cs407_android.rockpaperscissors;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Settings
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        if (savedInstanceState != null) {
            return;
        }

    }


    public void exitSettingsPressed(View view) {
       //KAD go back to where you came from
        this.finish();
    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    public void playPressed(View view) {
//        //KAD Put stuff to start game play activity
//        Intent other=new Intent(this, PlayActivity.class); //we want to start a new activity, PlayActivity
//        startActivity(other);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        switch(item.getItemId()){
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI

//                Intent other=new Intent(this, SettingsActivity.class); //we want to start a new activity, PlayActivity
//                startActivity(other); TODO idk


                return true;
            // The action bar will automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            default: return super.onOptionsItemSelected(item);
        }
    }


}
