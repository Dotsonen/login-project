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

        final Button signUpButton = (Button) findViewById(R.id.signUpButton);
        


        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Check if all fields are filled
                if (pwd.getText().toString().equals("") || repPwd.getText().toString().equals("") || email.getText().toString().equals("")) {

                    // Toast that says you have to fill in all fields
                    String text = "You have to fill in all fields!";
                    Toast toast = Toast.makeText(getContext(), text, duration);
                    toast.show();
                    signUpButton.setBackgroundColor(Color.RED);

                } else {

                    if (!pwd.getText().toString().equals( repPwd.getText().toString() )) {

                        // Toast that says passwords does not agree
                        String text = "Passwords do not agree!" + " pwd = " + pwd.getText().toString() + " repPwd = " + repPwd.getText().toString();
                        Toast toast = Toast.makeText(getContext(), text, duration);
                        toast.show();
                        signUpButton.setBackgroundColor(Color.RED);

                    } else {

                        // Toast that says congratulations! You signed up successfully
                        String text = "Congratulations! You signed up successfully." + " pwd = " + pwd.getText().toString() + " repPwd = " + repPwd.getText().toString();
                        Toast toast = Toast.makeText(getContext(), text, duration);
                        toast.show();
                        signUpButton.setBackgroundColor(Color.GREEN);

                    }

                }
            }

        });


    }

    private void init(Context context) {
        View.inflate(context, R.layout.login_view, this);

    }

}

