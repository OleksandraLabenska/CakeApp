
package com.example.cake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////here I assign a method onCheckedChange to the checkbox
        CheckBox userCheck = findViewById(R.id.checked);
        userCheck.setOnCheckedChangeListener(this);
        //here I assign a method onClick to the button
        Button userButton = findViewById(R.id.button);
        userButton.setOnClickListener(this);
    }

    //In this part I define what will happen depending on whether the checkbox is checked or not

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        EditText userNameContest = findViewById(R.id.nameContest);
        //If the checkbox is checked, the field for entering the name of the contest will become visible and a toast with a message  will be displayed on the screen
        if (isChecked) {
            userNameContest.setText("");
            userNameContest.setVisibility(View.VISIBLE);
            //If the checkbox is not checked there won't be any changes
        } else {
            userNameContest.setText("None");
            userNameContest.setVisibility(View.INVISIBLE);
        }
    }

    //In this part I define what will happen when the button is clicked

    @Override
    public void onClick(View v) {
        EditText userName = findViewById(R.id.nameValue);
        EditText userSurname = findViewById(R.id.surnameValue);
        EditText userAge = findViewById(R.id.ageValue);
        EditText userNameContest = findViewById(R.id.nameContest);
        //Here I check if all the input fields are filled( Name, Surname, Age).If one of the fields are not filled a toast will appear with the message to fill the form
        if (userName.getText().toString().trim().isEmpty() ||
                userSurname.getText().toString().trim().isEmpty() ||
                userAge.getText().toString().trim().isEmpty() ||
                userNameContest.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill all form fields!", Toast.LENGTH_SHORT).show();
        } else {
            //Here I check if the user have 18 years old. If the user do not have 18, a toast will appear on the screen with the message that a participant should have 18 years old
            if (Integer.parseInt(userAge.getText().toString()) < 18) {
                Toast.makeText(getApplicationContext(), "To participate in the contest you should have 18 y.o.", Toast.LENGTH_SHORT).show();
            } else {
                //If the user have 18 y.o. and all fields are filled, a toast will appear on the screen with the message that registration has been done successfully
                Toast.makeText(getApplicationContext(), "Registration has been done successfully!", Toast.LENGTH_SHORT).show();
            }
        }

    }
}

