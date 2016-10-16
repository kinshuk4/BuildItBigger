package com.udacity.gradle.builditbigger;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.k2udacity.androidjokedisplayer.JokeDisplayer;


public class MainActivity extends ActionBarActivity {
    private static String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Log.d(LOG_TAG, "tellJoke()");
        new JokeAsyncActivityTask(this).execute();
    }

    public class JokeAsyncActivityTask extends JokeAsyncTask {

        private Activity activity;

        public JokeAsyncActivityTask(Activity activity) {
            this.activity = activity;
        }

        @Override
        protected void onPostExecute(@Nullable String s) {
            super.onPostExecute(s);
            if (s != null)
                JokeDisplayer.startActvity(activity, s);
        }
    }

}
