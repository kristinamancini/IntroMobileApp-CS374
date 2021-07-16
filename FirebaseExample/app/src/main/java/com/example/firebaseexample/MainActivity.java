package com.example.firebaseexample;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    //instance variables
    private EditText firstName;
    private EditText lastName;
    private TextView addedMessage;
    private TextView errorMessage;
    private Button addEmployeeButton;
    private RecyclerView myRecycler;

    private AddEmployeeAdapter adapter;
    private DatabaseReference myRef;

    int newEntry = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRef = FirebaseDatabase.getInstance().getReference("employees");

        myRecycler = (RecyclerView) findViewById(R.id.employee_data);
        errorMessage = (TextView) findViewById(R.id.error_message);
        addedMessage = (TextView) findViewById(R.id.success_message);
        addEmployeeButton = (Button) findViewById(R.id.add_button);
        firstName = (EditText) findViewById(R.id.first_name_edit_text);
        lastName = (EditText) findViewById(R.id.last_name_edit_text);

        //show recycler view linearly
        myRecycler.setLayoutManager(new LinearLayoutManager(this));

        //fetch data with Recycler view
        FirebaseRecyclerOptions<Employee> options = new FirebaseRecyclerOptions.Builder<Employee>()
                .setQuery(myRef, Employee.class)
                .build();
        //connecting object of adapter class to adapter class itself
        adapter = new AddEmployeeAdapter(options);

        //connect adapter class with the Recycler view
        myRecycler.setAdapter(adapter);
    }


    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();
    }

    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }


    //click button, add employee
    public void addEmployee(View view) {

        String fName = firstName.getText().toString().trim();
        String lName = lastName.getText().toString().trim();

        closeKeyboard();

        if (!fName.trim().isEmpty() && !lName.trim().isEmpty()){

            String i = String.valueOf(newEntry);
            Employee newEmployee = new Employee(fName, lName);
            myRef.child(i).setValue(newEmployee);
            newEntry++;
            addedMessage.setVisibility(View.VISIBLE);
            errorMessage.setVisibility(View.INVISIBLE);
        }

        else {
            addedMessage.setVisibility(View.INVISIBLE);
            errorMessage.setVisibility(View.VISIBLE);
        }
    }

    //close keyboard after pushing button
    private void closeKeyboard() {
        View view = this.getCurrentFocus();

        if (view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}