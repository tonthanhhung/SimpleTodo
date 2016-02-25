package com.codebox.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    String valueToEdit;
    int idToEdit;

    EditText etItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        valueToEdit = getIntent().getStringExtra("value");
        idToEdit = getIntent().getIntExtra("id", -1);
        etItem = (EditText) findViewById(R.id.etItem);
        etItem.setText(valueToEdit);
        etItem.setSelection(valueToEdit.length());
        etItem.requestFocus();
        if(etItem.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

    }

    public void onEditItem(View v) {
        String newValue = etItem.getText().toString();
        Intent iData = new Intent();
        iData.putExtra("id", idToEdit);
        iData.putExtra("value", newValue);
        setResult(RESULT_OK, iData);
        finish();
    }
}
