package com.example.midtermkristinamanciniv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //data members to be used
    private EditText mInput;
    private Button converterButton;
    private TextView mmOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the IDs and initialize
        mInput = (EditText) findViewById(R.id.meters_edit_text);
        converterButton = (Button) findViewById(R.id.convert_button);
        mmOutput = (TextView) findViewById(R.id.millimeters_text_view);


    }

    //the onclick method, using OnClickListener, convert meter to millimeters by multiply 1000 * x meters
    public void convert(View view) {

        converterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInput.getText().toString().length() == 0)
                    mInput.setText("0");

                double number = Double.parseDouble(mInput.getText().toString());
                double answer = (double) (number * 1000);

                String stringResult = String.format("%.2f", answer);

                mmOutput.setText(stringResult + " millimeters");

            }
        });

    }
}