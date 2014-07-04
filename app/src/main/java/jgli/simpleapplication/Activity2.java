package jgli.simpleapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import jgli.simpleapplication.R;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        setupUiEvent();

        if(savedInstanceState !=null){
            restoreState(savedInstanceState);
        }
    }

    private void restoreState(Bundle savedInstanceState) {
        String text = savedInstanceState.getString(textViewState,"default value");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(text);
    }

    private String textViewState;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView textView = (TextView) findViewById(R.id.textView);
        String text = textView.getText().toString();
        outState.putString(textViewState,text);
    }


    private void setupUiEvent() {
        Button button = (Button) findViewById(R.id.clickMeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleClickMe((Button) view);
            }
        });
    }

    private void handleClickMe(Button button){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Wow, you clicked me!");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity2, menu);
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
