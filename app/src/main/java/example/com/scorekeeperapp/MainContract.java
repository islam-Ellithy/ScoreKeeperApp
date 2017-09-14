package example.com.scorekeeperapp;

import android.view.View;

/**
 * Created by MrHacker on 9/14/2017.
 */

public interface MainContract {
    interface IView {
        void updateScoreA(int x);

        void updateScoreB(int x);

        void resetScoreA(View view);

        void resetScoreB(View view);

        void resetAllScores(View view);

        void addPlus1ScoreA(View view);

        void addPlus2ScoreA(View view);

        void addPlus3ScoreA(View view);

        void addPlus1ScoreB(View view);

        void addPlus2ScoreB(View view);

        void addPlus3ScoreB(View view);
    }
}
