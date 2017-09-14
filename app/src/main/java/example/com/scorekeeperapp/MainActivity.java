package example.com.scorekeeperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView scoreA, scoreB;
    ProgressBar progressBar;
    int x = 0, y = 0;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("x", x);
        outState.putInt("y", y);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        scoreA = (TextView) findViewById(R.id.scoreA);
        scoreB = (TextView) findViewById(R.id.scoreB);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if (savedInstanceState != null) {
            x = savedInstanceState.getInt("x");
            y = savedInstanceState.getInt("y");

            scoreA.setText(String.valueOf(x));
            scoreB.setText(String.valueOf(y));
        }


    }

    public void updateUIA(int x) {
        if (progressBar.getVisibility() == View.GONE)
            progressBar.setVisibility(View.VISIBLE);
        scoreA.setText("" + x);
    }

    public void updateUIB(int x) {
        if (progressBar.getVisibility() == View.GONE)
            progressBar.setVisibility(View.VISIBLE);

        scoreB.setText("" + y);
    }


    public void resetA(View view) {
        x = 0;
        updateUIA(x);
    }

    public void resetB(View view) {
        y = 0;
        updateUIB(y);
    }

    public void resetAll(View view) {
        resetA(view);
        resetB(view);
        if (progressBar.getVisibility() != View.GONE)
            progressBar.setVisibility(View.GONE);
    }


    public void plus1A(View view) {
        x++;
        updateUIA(x);
    }

    public void plus2A(View view) {
        x += 2;
        updateUIA(x);
    }

    public void plus3A(View view) {
        x += 3;
        updateUIA(x);
    }


    public void plus1B(View view) {
        y++;
        updateUIB(y);
    }

    public void plus2B(View view) {
        y += 2;
        updateUIB(y);

    }

    public void plus3B(View view) {
        y += 3;
        updateUIB(y);

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
}
