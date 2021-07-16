package com.example.helloconstraints;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast; 

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    //private View coloredButton;
    Button b;
    Button b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);

        b = (Button) findViewById(R.id.button_count);
        b2 = findViewById(R.id.button_zero);
        //coloredButton = (View) findViewById(R.id.button_count);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(mCount));
            if (mCount % 2 == 0) {
                b.setBackgroundColor(getResources().getColor(R.color.design_default_color_primary_dark));

                b2.setBackgroundColor(getResources().getColor(R.color.black));
            }
                //coloredButton.setBackgroundColor(Color.GREEN);
            else {
                b.setBackgroundColor(getResources().getColor(R.color.purple_200));
                b2.setBackgroundColor(getResources().getColor(R.color.black));
            }
                //coloredButton.setBackgroundColor(Color.MAGENTA);
        }

    }

    public void backZero(View view) {

        /*
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(0));
            b2.setBackgroundColor(getResources().getColor(R.color.gray));
            mCount = 0;

        }
        else
            b2.setBackgroundColor(getResources().getColor(R.color.black));
*/


        if (mCount != 0 && mShowCount != null) {
            b2.setBackgroundColor(getResources().getColor(R.color.gray));
            mCount = 0;
            mShowCount.setText(Integer.toString(mCount));



        }
        //else
           // b2.setBackgroundColor(getResources().getColor(R.color.black));



        /*
        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(0));
            mCount = 0;
            b2.setBackgroundColor(getResources().getColor(R.color.gray));
        }
        else {
            //mShowCount.setText(Integer.toString(0));
            //mCount = 0;
            b2.setBackgroundColor(getResources().getColor(R.color.black));

        }

        */
    }
}