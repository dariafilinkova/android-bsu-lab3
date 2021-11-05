package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class CommentActivity extends AppCompatActivity {

    private TextInputLayout commentInputLayout;
    private EditText commentEditText;
    private Button save;
    private Button cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_form);

        this.commentInputLayout = (TextInputLayout) this.findViewById(R.id.commentInputLayout);
        this.commentEditText = (EditText) this.findViewById(R.id.commentEditText);
        this.save = (Button) this.findViewById(R.id.save_button);
        this.cancel = (Button) this.findViewById(R.id.cancel_button);

    this.save.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("FIELD_TYPE_KEY", Types.COMMENT);
        returnIntent.putExtra("RESULT_KEY",
                CommentActivity.this.commentEditText.getText().toString());
        CommentActivity.this.setResult(Activity.RESULT_OK, returnIntent);
        CommentActivity.this.finish();
    }
    });


        this.cancel.setOnClickListener(new View.OnClickListener()

    {
        public void onClick (View v){
        CommentActivity.this.setResult(Activity.RESULT_CANCELED);
        CommentActivity.this.finish();
    }
    });

}
}