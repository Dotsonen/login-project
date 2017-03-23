package com.example.dotson.project2;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.R.attr.duration;

/**
 * Created by hjalmarwilander on 2017-03-16.
 */

public class LoginView extends LinearLayout {
    int duration = Toast.LENGTH_SHORT;

    // Seems needed for some reason
    public LoginView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
        checkContent();
    }



    private void checkContent() {

        final EditText pwd = (EditText) findViewById(R.id.pwdBox);
        final EditText repPwd = (EditText) findViewById(R.id.repPwdBox);
        final EditText email = (EditText) findViewById(R.id.emailBox);

        ProgressBar strengthMeter = (ProgressBar) findViewById(R.id.progressBar);

        final Button signUpButton = (Button) findViewById(R.id.signUpButton);

        pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                // Checks if password is entered
                if (pwd.getText().toString().length() == 0) {
                    pwd.setError("Enter your password..!");
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                signUpButton.setBackgroundColor(Color.RED);
                // Check if all fields are filled
                if (pwd.getText().toString().equals("") || repPwd.getText().toString().equals("") || email.getText().toString().equals("")) {

                    // Toast that says you have to fill in all fields
                    String text = "You have to fill in all fields!";
                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();

                } else {

                    if (!pwd.getText().toString().equals( repPwd.getText().toString() )) {

                        // Toast that says passwords does not agree
                        String text = "Passwords do not agree!" + " pwd = " + pwd.getText().toString() + " repPwd = " + repPwd.getText().toString();
                        Toast toast = Toast.makeText(getContext(), text, duration);
                        toast.show();

                    } else {

                        // Toast that says congratulations! You signed up successfully
                        String text = "Congratulations! You signed up successfully." + " pwd = " + pwd.getText().toString() + " repPwd = " + repPwd.getText().toString();
                        Toast toast = Toast.makeText(getContext(), text, duration);
                        toast.show();

                    }

                }
            }

        });


    }

    private void init(Context context) {
        View.inflate(context, R.layout.login_view, this);
     //   ((Activity)context).getLayoutInflater().inflate(R.layout.login_view,this);

    }

}

