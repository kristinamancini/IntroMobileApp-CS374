package com.example.firebaseexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AddEmployeeAdapter extends FirebaseRecyclerAdapter<Employee,
        AddEmployeeAdapter.employeesViewholder> {

    public AddEmployeeAdapter(@NonNull FirebaseRecyclerOptions<Employee> options){
        super(options);
    }

    //bind the view in Card view employee.xml with data in model class Employee.class
    @Override
    protected void onBindViewHolder(@NonNull employeesViewholder holder, int position, @NonNull
            Employee model) {
        //add firstname from model class Employee.class to view in Card view employee.xml
        holder.firstname.setText(model.getFirstName());

        // Add lastname from model class Employee.class to view in Card view employee.xml
        holder.lastname.setText(model.getLastName());
    }

    //tell the class about the Card view employee.xml where data is shown
    @NonNull
    @Override
    public employeesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee, parent,
                false);
        return new AddEmployeeAdapter.employeesViewholder(view);
    }

    //sub Class to create references of the views in Card view employee.xml
    class employeesViewholder extends RecyclerView.ViewHolder {
        TextView firstname, lastname;

        public employeesViewholder(@NonNull View itemView)
        {
            super(itemView);
            firstname = itemView.findViewById(R.id.firstname);
            lastname = itemView.findViewById(R.id.lastname);
        }
    }


}
