package com.example.android.soccercounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mLocalGoals = 0;
    private int mLocalRedCards = 0;
    private int mLocalYellowCards = 0;
    private int mLocalPenalties = 0;

    private int mVisitorGoals = 0;
    private int mVisitorRedCards = 0;
    private int mVisitorYellowCards = 0;
    private int mVisitorPenalties = 0;

    private TextView mLocalGoals_TextView = null;
    private TextView mLocalRedCards_TextView = null;
    private TextView mLocalYellowCards_TextView = null;
    private TextView mLocalPenalties_TextView = null;
    private RadioGroup mLocalRadioGroup = null;

    private TextView mVisitorGoals_TextView = null;
    private TextView mVisitorRedCards_TextView = null;
    private TextView mVisitorYellowCards_TextView = null;
    private TextView mVisitorPenalties_TextView = null;
    private RadioGroup mVisitorRadioGroup = null;

    // Constants for Saved Instance State
    private static final String LOCAL_GOALS = "lgl";
    private static final String LOCAL_REDCARDS = "lrc";
    private static final String LOCAL_YELLOWCARDS = "lyc";
    private static final String LOCAL_PENALTIES = "lpn";
//    private static final String LOCAL_RADIO = "lrd";
    private static final String VISITOR_GOALS = "vgl";
    private static final String VISITOR_REDCARDS = "vrc";
    private static final String VISITOR_YELLOWCARDS = "vyc";
    private static final String VISITOR_PENALTIES = "vpn";
//    private static final String VISITOR_RADIO = "vrd";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore state
            mLocalGoals = savedInstanceState.getInt(LOCAL_GOALS);
            mLocalRedCards = savedInstanceState.getInt(LOCAL_REDCARDS);
            mLocalYellowCards = savedInstanceState.getInt(LOCAL_YELLOWCARDS);
            mLocalPenalties = savedInstanceState.getInt(LOCAL_PENALTIES);
//            mLocalRadioGroup.check(savedInstanceState.getInt(LOCAL_RADIO));

            mVisitorGoals = savedInstanceState.getInt(VISITOR_GOALS);
            mVisitorRedCards = savedInstanceState.getInt(VISITOR_REDCARDS);
            mVisitorYellowCards = savedInstanceState.getInt(VISITOR_YELLOWCARDS);
            mVisitorPenalties = savedInstanceState.getInt(VISITOR_PENALTIES);
//            mVisitorRadioGroup.check(savedInstanceState.getInt(VISITOR_RADIO));
        }

        setContentView(R.layout.activity_main);

        // Assign variables to views so that they can be used later
        mLocalGoals_TextView = (TextView) findViewById(R.id.local_goals_textView);
        mLocalRedCards_TextView = (TextView) findViewById(R.id.local_red_cards_textView);
        mLocalYellowCards_TextView = (TextView) findViewById(R.id.local_yellow_cards_textView);
        mLocalPenalties_TextView = (TextView) findViewById(R.id.local_penalties_textView);
        mLocalRadioGroup = (RadioGroup) findViewById(R.id.local_radio_group);

        mVisitorGoals_TextView = (TextView) findViewById(R.id.visitor_goals_textView);
        mVisitorRedCards_TextView = (TextView) findViewById(R.id.visitor_red_cards_textView);
        mVisitorYellowCards_TextView = (TextView) findViewById(R.id.visitor_yellow_cards_textView);
        mVisitorPenalties_TextView = (TextView) findViewById(R.id.visitor_penalties_textView);
        mVisitorRadioGroup = (RadioGroup) findViewById(R.id.visitor_radio_group);

        // Refresh TextViews with recovered values
        refreshAll();

    }

    /* Reference: https://developer.android.com/guide/components/activities/activity-lifecycle.html */
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save the current state
//        int radioChecked;

        savedInstanceState.putInt(LOCAL_GOALS, mLocalGoals);
        savedInstanceState.putInt(LOCAL_REDCARDS, mLocalRedCards);
        savedInstanceState.putInt(LOCAL_YELLOWCARDS, mLocalYellowCards);
        savedInstanceState.putInt(LOCAL_PENALTIES, mLocalPenalties);
/*
        radioChecked = mLocalRadioGroup.getCheckedRadioButtonId();
        savedInstanceState.putInt(LOCAL_RADIO, radioChecked);
*/

        savedInstanceState.putInt(VISITOR_GOALS, mVisitorGoals);
        savedInstanceState.putInt(VISITOR_REDCARDS, mVisitorRedCards);
        savedInstanceState.putInt(VISITOR_YELLOWCARDS, mVisitorYellowCards);
        savedInstanceState.putInt(VISITOR_PENALTIES, mVisitorPenalties);
/*
        radioChecked = mVisitorRadioGroup.getCheckedRadioButtonId();
        savedInstanceState.putInt(VISITOR_RADIO, radioChecked);
*/

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);

    }


    /*
    * Process any clicked button
     */
    public void onButtonClicked(View button) {

        switch (button.getId()) {
            case R.id.local_minus_button:
                processLocalButton(-1);
                break;
            case R.id.local_plus_button:
                processLocalButton(+1);
                break;
            case R.id.visitor_minus_button:
                processVisitorButton(-1);
                break;
            case R.id.visitor_plus_button:
                processVisitorButton(+1);
                break;
            case R.id.reset_button:
                processResetButton();
                break;
        }
    }


    /*
    * Local Button clicked
     */
    private void processLocalButton(int value) {
        int radioChecked = mLocalRadioGroup.getCheckedRadioButtonId();
        switch (radioChecked) {
            case R.id.local_goals_radio:
                if ((value == -1 && mLocalGoals > 0) || value == +1) {
                    mLocalGoals += value;
                    mLocalGoals_TextView.setText(String.valueOf(mLocalGoals));
                }
                break;
            case R.id.local_red_cards_radio:
                if ((value == -1 && mLocalRedCards > 0) || value == +1) {
                    mLocalRedCards += value;
                    mLocalRedCards_TextView.setText(String.valueOf(mLocalRedCards));
                }
                break;
            case R.id.local_yellow_cards_radio:
                if ((value == -1 && mLocalYellowCards > 0) || value == +1) {
                    mLocalYellowCards += value;
                    mLocalYellowCards_TextView.setText(String.valueOf(mLocalYellowCards));
                }
                break;
            case R.id.local_penalties_radio:
                if ((value == -1 && mLocalPenalties > 0) || value == +1) {
                    mLocalPenalties += value;
                    mLocalPenalties_TextView.setText(String.valueOf(mLocalPenalties));
                }
                break;
        }

    }


    /*
    * Visitor  Button clicked
     */
    private void processVisitorButton(int value) {
        int radioChecked = mVisitorRadioGroup.getCheckedRadioButtonId();
        switch (radioChecked) {
            case R.id.visitor_goals_radio:
                if ((value == -1 && mVisitorGoals > 0) || value == +1) {
                    mVisitorGoals += value;
                    mVisitorGoals_TextView.setText(String.valueOf(mVisitorGoals));
                }
                break;
            case R.id.visitor_red_cards_radio:
                if ((value == -1 && mVisitorRedCards > 0) || value == +1) {
                    mVisitorRedCards += value;
                    mVisitorRedCards_TextView.setText(String.valueOf(mVisitorRedCards));
                }
                break;
            case R.id.visitor_yellow_cards_radio:
                if ((value == -1 && mVisitorYellowCards > 0) || value == +1) {
                    mVisitorYellowCards += value;
                    mVisitorYellowCards_TextView.setText(String.valueOf(mVisitorYellowCards));
                }
                break;
            case R.id.visitor_penalties_radio:
                if ((value == -1 && mVisitorPenalties > 0) || value == +1) {
                    mVisitorPenalties += value;
                    mVisitorPenalties_TextView.setText(String.valueOf(mVisitorPenalties));
                }
                break;
        }

    }


    /*
    * Reset Button clicked
     */
    private void processResetButton() {
        mLocalGoals = 0;
        mLocalRedCards = 0;
        mLocalYellowCards = 0;
        mLocalPenalties = 0;
        mVisitorGoals = 0;
        mVisitorRedCards = 0;
        mVisitorYellowCards = 0;
        mVisitorPenalties = 0;

        mLocalRadioGroup.check(R.id.local_goals_radio);
        mVisitorRadioGroup.check(R.id.visitor_goals_radio);

        refreshAll();

    }


    /*
     * Refresh all TextViews
     */
    private void refreshAll() {

        mLocalGoals_TextView.setText(String.valueOf(mLocalGoals));
        mLocalRedCards_TextView.setText(String.valueOf(mLocalRedCards));
        mLocalYellowCards_TextView.setText(String.valueOf(mLocalYellowCards));
        mLocalPenalties_TextView.setText(String.valueOf(mLocalPenalties));

        mVisitorGoals_TextView.setText(String.valueOf(mVisitorGoals));
        mVisitorRedCards_TextView.setText(String.valueOf(mVisitorRedCards));
        mVisitorYellowCards_TextView.setText(String.valueOf(mVisitorYellowCards));
        mVisitorPenalties_TextView.setText(String.valueOf(mVisitorPenalties));

    }
}
