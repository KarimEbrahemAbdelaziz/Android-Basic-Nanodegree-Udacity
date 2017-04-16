package com.example.karim.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /**
     *  scoreTeamAValue hold the score for team A
     *  scoreTeamBValue hold the score for team B
     */
    int scoreTeamAValue = 0;
    int scoreTeamBValue = 0;

    /**
     *  teamAScore refer to text view that show the score of team A
     *  teamBScore refer to text view that show the score of team B
     */
    @BindView(R.id.team_a_score)
    TextView teamAScore;
    @BindView(R.id.team_b_score)
    TextView teamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     *  Button to add +6 points for team A score
     */
    @OnClick(R.id.add_6points_teamA)
    public void addSixPointsTeamA(){
        scoreTeamAValue += 6;
        teamAScore.setText(Integer.toString(scoreTeamAValue));
    }

    /**
     *  Button to add +3 points for team A score
     */
    @OnClick(R.id.add_3points_teamA)
    public void addThreePointsTeamA(){
        scoreTeamAValue += 3;
        teamAScore.setText(Integer.toString(scoreTeamAValue));
    }

    /**
     *  Button to add +2 points for team A score
     */
    @OnClick(R.id.add_2points_teamA)
    public void addTwoPointsTeamA(){
        scoreTeamAValue += 2;
        teamAScore.setText(Integer.toString(scoreTeamAValue));
    }

    /**
     *  Button to add +1 point for team A score
     */
    @OnClick(R.id.add_1point_teamA)
    public void addOnePointTeamA(){
        scoreTeamAValue += 1;
        teamAScore.setText(Integer.toString(scoreTeamAValue));
    }

    /**
     *  Button to add +6 points for team B score
     */
    @OnClick(R.id.add_6points_teamB)
    public void addSixPointsTeamB(){
        scoreTeamBValue += 6;
        teamBScore.setText(Integer.toString(scoreTeamBValue));
    }

    /**
     *  Button to add +3 points for team B score
     */
    @OnClick(R.id.add_3points_teamB)
    public void addThreePointsTeamB(){
        scoreTeamBValue += 3;
        teamBScore.setText(Integer.toString(scoreTeamBValue));
    }

    /**
     *  Button to add +2 points for team B score
     */
    @OnClick(R.id.add_2points_teamB)
    public void addTwoPointsTeamB(){
        scoreTeamBValue += 2;
        teamBScore.setText(Integer.toString(scoreTeamBValue));
    }

    /**
     *  Button to add +1 point for team B score
     */
    @OnClick(R.id.add_1point_teamB)
    public void addOnePointTeamB(){
        scoreTeamBValue += 1;
        teamBScore.setText(Integer.toString(scoreTeamBValue));
    }

    /**
     *  Reset button that reset scores for both teams A and B to 0
     */
    @OnClick(R.id.reset_button)
    public void resetButton(){
        scoreTeamAValue = 0;
        scoreTeamBValue = 0;
        teamAScore.setText(Integer.toString(scoreTeamAValue));
        teamBScore.setText(Integer.toString(scoreTeamBValue));
    }

}
