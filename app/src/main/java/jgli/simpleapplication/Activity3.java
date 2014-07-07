package jgli.simpleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Activity3 extends Activity {

    // add some keys here
    static final int PROVIDE_INFO_REQUEST_CODE = 20000;

    TextView mClassNameTextView;
    TextView mPersonNameTextView;
    TextView mEmailNameTextView;

//<editor-folder desc="view fields getters">
    public TextView getCourseNameTextView(){
        if(mClassNameTextView == null){
            mClassNameTextView = (TextView) findViewById(R.id.classNameTextView);
        }
        return mClassNameTextView;
    }
    public TextView getPersonNameTextView(){
        if(mPersonNameTextView == null){
            mPersonNameTextView = (TextView)findViewById(R.id.personNameTextView);
        }
        return mPersonNameTextView;
    }

    public TextView getEmailNameTextView(){
        if(mEmailNameTextView == null){
            mEmailNameTextView =(TextView)findViewById(R.id.emailNameTextView);
        }
        return mEmailNameTextView;
    }
//</editor-folder>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        setupViews();
    }

    private void setupViews() {
        Button btnInfo = (Button) findViewById(R.id.btn_info);
        btnInfo.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) { onClickProvideInfo((Button)view);
                                       }
                                   }
        );
    }

    private void onClickProvideInfo(Button view) {
        Intent intent = new Intent(this,ProvideInfo.class);
        startActivityForResult(intent, PROVIDE_INFO_REQUEST_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent resultIntent) {
        switch (requestCode) {
            case PROVIDE_INFO_REQUEST_CODE:
                handlerProvideInfoResult(resultCode,resultIntent);
                break;
        }
    }
    // display the result
    private void handlerProvideInfoResult(int resultCode, Intent resultIntent) {
        if (resultCode == RESULT_OK) {
            String courseName = resultIntent.getStringExtra(ProvideInfo.COURSE_NAME);
            String personName = resultIntent.getStringExtra(ProvideInfo.PERSON_NAME);
            String emailName = resultIntent.getStringExtra(ProvideInfo.EMAIL_NAME);

            getCourseNameTextView().setText(courseName);
            getPersonNameTextView().setText(personName);
            getEmailNameTextView().setText(emailName);
        } else {
            Toast.makeText(this,"User Canceled",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity3, menu);
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
