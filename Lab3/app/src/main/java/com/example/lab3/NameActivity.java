package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;


public class NameActivity extends AppCompatActivity {

    private TextInputLayout nameInputLayout;
    private TextInputLayout surnameInputLayout;
    private EditText nameEditText;
    private EditText surnameEditText;
    private Button save;
    private Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_form);

        this.nameInputLayout = (TextInputLayout) this.findViewById(R.id.nameInputLayout);
        this.surnameInputLayout = (TextInputLayout) this.findViewById(R.id.surnameInputLayout);
        this.nameEditText = (EditText) this.findViewById(R.id.nameEditText);
        this.surnameEditText = (EditText) this.findViewById(R.id.surnameEditText);
        this.save = (Button) this.findViewById(R.id.save_button);
        this.cancel = (Button) this.findViewById(R.id.cancel_button);

        this.save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("FIELD_TYPE_KEY", Types.NAME);
                returnIntent.putExtra("RESULT_KEY", NameActivity.this.nameEditText.getText().toString() + " " + NameActivity.this.surnameEditText.getText().toString());
                NameActivity.this.setResult(Activity.RESULT_OK, returnIntent);
                NameActivity.this.finish();
            }
        });

        this.cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NameActivity.this.setResult(Activity.RESULT_CANCELED);
                NameActivity.this.finish();
            }
        });
    }
}