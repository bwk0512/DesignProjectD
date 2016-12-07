package com.escns.smombie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.escns.smombie.DAO.Record;
import com.escns.smombie.Manager.DBManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyo99 on 2016-12-07.
 */

public class PointActivity extends AppCompatActivity {

    LinearLayout listlayout;

    private DBManager mDbManager;

    List<Record> list;
    int cnt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);

        listlayout = (LinearLayout) findViewById(R.id.listlayout);

        mDbManager = new DBManager(getApplicationContext());
        list = null;
        list = new ArrayList<>();
        list = mDbManager.getRecord();
        cnt = 0;

        String to = Integer.toString(mDbManager.getRowCount());
        Log.d("CNT1 = ", to);
        String to2 = Integer.toString(list.size());
        Log.d("CNT2 = ", to2);

        while(cnt < mDbManager.getRowCount()) {

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);
            layout.setGravity(Gravity.CENTER_VERTICAL);

            layout.addView(loadData(1));
            layout.addView(loadData(2));
            layout.addView(loadData(3));

            listlayout.addView(layout);

            cnt++;
        }

    }

    public TextView loadData(int num) {

        TextView textView = new TextView(this);

        if(num == 1) {
            String s = "  " + Integer.toString(list.get(cnt).getmPoint()) + "            ";
            textView.setText(s);
        }
        else if(num ==2) {
            String str = "";

            str += list.get(cnt).getmYear();
            str += ".";
            str += list.get(cnt).getmMonth();
            str += ".";
            str += list.get(cnt).getmDay();
            str += "/";
            str += list.get(cnt).getmHour();
            str += "H           ";

            textView.setText(str);
        }
        else {
            textView.setText(list.get(cnt).getmPurpose());
        }

        textView.setTextSize(20);

        return textView;
    }



}
