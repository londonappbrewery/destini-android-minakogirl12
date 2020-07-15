package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop, mButtonBottom;
    private int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        if(savedInstanceState != null){
            mStoryIndex = savedInstanceState.getInt("StoryIndex");
            if(mStoryIndex == 2){
                mStoryTextView.setText(R.string.T2_Story);
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
            }
            else if(mStoryIndex == 3){
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
            }
            else if(mStoryIndex == 4){
               mStoryTextView.setText("Do you want to restart the game?");
                mButtonTop.setText(R.string.restart);
                mButtonBottom.setText(R.string.closeApp);
            }
            else{
                mStoryIndex = 1;
            }

        }



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (mStoryIndex){
                    case 1:
                    case 2:
                        mStoryTextView.setText(R.string.T3_Story);
                        mButtonTop.setText(R.string.T3_Ans1);
                        mButtonBottom.setText(R.string.T3_Ans2);
                        mStoryIndex = 3;
                        break;

                    case 3:
                        mStoryTextView.setText(R.string.T6_End);
                        mButtonTop.setText(R.string.restart);
                        mButtonBottom.setText(R.string.closeApp);
                        mStoryIndex = 4;
                        break;
                    case 4:
                        mStoryTextView.setText(R.string.T1_Story);
                        mButtonTop.setText(R.string.T1_Ans1);
                        mButtonBottom.setText(R.string.T1_Ans2);
                        mStoryIndex = 1;
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "Encountered an error closing app...", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }


            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (mStoryIndex){
                    case 1:
                        mStoryTextView.setText(R.string.T2_Story);
                        mButtonTop.setText(R.string.T2_Ans1);
                        mButtonBottom.setText(R.string.T2_Ans2);
                        mStoryIndex = 2;
                        break;
                    case 2:
                        mStoryTextView.setText(R.string.T4_End);
                        mButtonTop.setText(R.string.restart);
                        mButtonBottom.setText(R.string.closeApp);
                        mStoryIndex = 4;
                        break;
                    case 3:
                        mStoryTextView.setText(R.string.T5_End);
                        mButtonTop.setText(R.string.restart);
                        mButtonBottom.setText(R.string.closeApp);
                        mStoryIndex = 4;
                        break;
                    case 4:
                       finish();
                        break;

                    default:
                        Toast.makeText(MainActivity.this, "Encountered an error closing app...", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                }


            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("StoryIndex", mStoryIndex);
    }

}
