package com.decard.lib.jnistruct;

import android.graphics.Rect;
import android.os.Bundle;

import com.decard.lib.jnistruct.data.DataBean;
import com.decard.lib.jnistruct.data.DevStateInfo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        NativeLibrary nativeLibrary = new NativeLibrary();
        DataBean dataBean = nativeLibrary.getDataFromNative();
        Log.e(TAG, "onCreate: "+dataBean.toString() );
        dataBean.setRect(new Rect(10,10,10,10));
        dataBean.setmScore(100);
        dataBean.getmInner().mMessage = "data from java";
        nativeLibrary.transferDataToNative(dataBean);

        DevStateInfo devStateInfo = new DevStateInfo();
        devStateInfo.setUcAppVer("V1.0.0");
        devStateInfo.setUcAliEarliestTime("20200509");
        devStateInfo.setUiAliNotUpCnt(10);
        devStateInfo.setUcAliQrCAVer("0001");
        devStateInfo.setUcCupQrCAVer("0002");
        devStateInfo.setUcCupEarliestTime("20200509");
        devStateInfo.setUiCupNotUpCnt(20);
        devStateInfo.setUcOdaEarliestTime("20200510");

        int i = nativeLibrary.Com_Msg_StateUp(devStateInfo);
        Log.e(TAG, "onCreate: "+i );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
