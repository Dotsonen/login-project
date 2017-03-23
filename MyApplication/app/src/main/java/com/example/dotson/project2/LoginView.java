package com.example.dotson.project2;

import android.app.Activity;
import android.content.Context;
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

    EditText pwd = (EditText) findViewById(R.id.pwdBox);
    EditText repPwd = (EditText) findViewById(R.id.repPwdBox);
    EditText email = (EditText) findViewById(R.id.emailBox);

    ProgressBar strengthMeter = (ProgressBar) findViewById(R.id.progressBar);

    final Button signUpButton = (Button) findViewById(R.id.signUpButton);

    Toast toast;
    CharSequence text;

    Context context2;

    int duration = Toast.LENGTH_SHORT;

    public LoginView(final Context context){
        super(context);
        init(context);
        context2 = getContext();
        checkContent(context2);
    }

    // Seems needed for some reason
    public LoginView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    // This constructor also needed to rid error
    public LoginView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }


    private void checkContent(Context context) {

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

                // Check if all fields are filled
                if (pwd.getText().toString().equals("") || repPwd.getText().toString().equals("") || email.getText().toString().equals("")) {

                    // Toast that says you have to fill in all fields
                    text = "You have to fill in all fields!";
                    toast = Toast.makeText(context2, text, duration);
                    toast.show();

                } else {

                    if (!pwd.getText().toString().equals( repPwd.getText().toString() )) {

                        // Toast that says passwords does not agree
                        text = "Passwords do not agree!" + " pwd = " + pwd.getText().toString() + " repPwd = " + repPwd.getText().toString();
                        toast = Toast.makeText(context2, text, duration);
                        toast.show();

                    } else {

                        // Toast that says congratulations! You signed up successfully
                        text = "Congratulations! You signed up successfully." + " pwd = " + pwd.getText().toString() + " repPwd = " + repPwd.getText().toString();
                        toast = Toast.makeText(context2, text, duration);
                        toast.show();

                    }

                }
            }

        });


    }

    private void init(Context context) {
        View.inflate(context, R.layout.login_view, this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
    }

}

