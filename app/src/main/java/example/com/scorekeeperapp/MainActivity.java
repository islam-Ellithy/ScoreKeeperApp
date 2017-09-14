package example.com.scorekeeperapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.IView {

    private TextView textViewScoreA;
    private TextView textViewScoreB;
    private ProgressBar progressBar;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("scoreTeamA", scoreTeamA);
        outState.putInt("scoreTeamB", scoreTeamB);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textViewScoreA = (TextView) findViewById(R.id.scoreA);
        textViewScoreB = (TextView) findViewById(R.id.scoreB);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("scoreTeamA");
            scoreTeamB = savedInstanceState.getInt("scoreTeamB");

            textViewScoreA.setText(String.valueOf(scoreTeamA));
            textViewScoreB.setText(String.valueOf(scoreTeamB));
        }


    }

    public void updateScoreA(int x) {
        if (progressBar.getVisibility() == View.GONE)
            progressBar.setVisibility(View.VISIBLE);
        textViewScoreA.setText(String.valueOf(x));
    }

    public void updateScoreB(int x) {
        if (progressBar.getVisibility() == View.GONE)
            progressBar.setVisibility(View.VISIBLE);

        textViewScoreB.setText(String.valueOf(scoreTeamB));
    }


    public void resetScoreA(View view) {
        scoreTeamA = 0;
        updateScoreA(scoreTeamA);
    }

    public void resetScoreB(View view) {
        scoreTeamB = 0;
        updateScoreB(scoreTeamB);
    }

    public void resetAllScores(View view) {
        resetScoreA(view);
        resetScoreB(view);
        if (progressBar.getVisibility() != View.GONE)
            progressBar.setVisibility(View.GONE);
    }


    public void addPlus1ScoreA(View view) {
        scoreTeamA++;
        updateScoreA(scoreTeamA);
    }

    public void addPlus2ScoreA(View view) {
        scoreTeamA += 2;
        updateScoreA(scoreTeamA);
    }

    public void addPlus3ScoreA(View view) {
        scoreTeamA += 3;
        updateScoreA(scoreTeamA);
    }


    public void addPlus1ScoreB(View view) {
        scoreTeamB++;
        updateScoreB(scoreTeamB);
    }

    public void addPlus2ScoreB(View view) {
        scoreTeamB += 2;
        updateScoreB(scoreTeamB);

    }

    public void addPlus3ScoreB(View view) {
        scoreTeamB += 3;
        updateScoreB(scoreTeamB);

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
