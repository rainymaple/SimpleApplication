package jgli.simpleapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyActivity extends Activity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        boolean handled;
        int id = item.getItemId();
        switch (id){
            case R.id.action_showActivity2:
                onclickMenuShowActivity(item,Activity2.class);
                handled =true;
                break;
            case R.id.action_showActivity3:
                onclickMenuShowActivity(item,Activity3.class);
                handled =true;
                break;
            case R.id.action_exit:
                onclickMenuExit(item);
                handled = true;
                break;
            default: handled = super.onOptionsItemSelected(item);
        }
        return handled;
    }

    private void onclickMenuShowActivity(MenuItem item, Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }




    public void onclickMenuExit(MenuItem item) {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the
        // action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
}
