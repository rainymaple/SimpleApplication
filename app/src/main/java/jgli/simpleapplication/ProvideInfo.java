package jgli.simpleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import jgli.simpleapplication.R;

public class ProvideInfo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provide_info);
        setupViews();   // setup the handler of done button
    }

    private void setupViews() {
        Button btnDone= (Button)findViewById(R.id.buttonDone);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonDone_onClick((Button)view);
            }
        });
    }

    private void buttonDone_onClick(Button view) {
        String courseName = getSelectedCourse();
        String personName = getEditTextValue(R.id.name_editText);
        String email = getEditTextValue(R.id.email_editText);

        Intent resultIntent = new Intent();
        // putExtra to add some extra data
        resultIntent.putExtra(COURSE_NAME,courseName);
        resultIntent.putExtra(PERSON_NAME,personName);
        resultIntent.putExtra(EMAIL_NAME,email);

        // return the intent with extra data with setResult
        setResult(RESULT_OK,resultIntent);
        finish();   // close the Activity

    }

    // add some keys for extra data
    public static final String COURSE_NAME = "courseNameExtra";
    public static final String PERSON_NAME = "personNameExtra";
    public static final String EMAIL_NAME = "emailNameExtra";

    // get the text of the EditText
    private String getEditTextValue(int textViewId) {
        EditText editText = (EditText) findViewById(textViewId);
        Editable editable = editText.getText();
        return editable == null ? "" : editable.toString();
    }

    // get the text of selected item in the radio group
    private String getSelectedCourse() {
        RadioGroup rdg = (RadioGroup) findViewById(R.id.classSelectGroup);
        int id = rdg.getCheckedRadioButtonId();
        RadioButton rd = (RadioButton) findViewById(id);
        return (String) rd.getText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.provide_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
