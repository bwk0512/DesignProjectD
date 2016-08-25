package com.escns.smombie.Tab;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.escns.smombie.MainActivity;
import com.escns.smombie.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.AxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hyo99 on 2016-08-16.
 */

public class TabFragment2 extends Fragment {

    Context mContext;
    private SharedPreferences pref;

    ImageView buttonOne, buttonTwo;

    RelativeLayout layout1, layout2;

    HorizontalBarChart chart1, chart2;

    TextView textProperty;

    View rootView;

    int userGender = 0; // 1:남자   2:여자
    int userAge = 0; // 1:10대   2:20대   3:30대   4:40대   5:50대이상

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tab2, container, false);

        init();

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
                buttonOne.setImageResource(R.drawable.bg_round_blue_gender);
                buttonTwo.setImageResource(R.drawable.bg_round_gray_age);
                if(userGender == 1)
                    textProperty.setText("남자");
                else
                    textProperty.setText("여자");
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                buttonOne.setImageResource(R.drawable.bg_round_gray_gender);
                buttonTwo.setImageResource(R.drawable.bg_round_blue_age);
                if(userAge == 1)
                    textProperty.setText("10대");
                else if(userAge == 2)
                    textProperty.setText("20대");
                else if(userAge == 3)
                    textProperty.setText("30대");
                else if(userAge == 4)
                    textProperty.setText("40대");
                else
                    textProperty.setText("50대");
            }
        });

        buttonOne.callOnClick();

        return rootView;
    }

    public void init() {

        mContext = getActivity().getApplicationContext();
        pref = mContext.getSharedPreferences(getResources().getString(R.string.app_name), mContext.MODE_PRIVATE);

        layout1 = (RelativeLayout) rootView.findViewById(R.id.tab2_charLayout1);
        layout2 = (RelativeLayout) rootView.findViewById(R.id.tab2_charLayout2);

        chart1 = (HorizontalBarChart) rootView.findViewById(R.id.tab2_chart1);
        chart2 = (HorizontalBarChart) rootView.findViewById(R.id.tab2_chart2);

        buttonOne = (ImageView) rootView.findViewById(R.id.tab2_button1);
        buttonTwo = (ImageView) rootView.findViewById(R.id.tab2_button2);

        textProperty = (TextView) rootView.findViewById(R.id.tab2_text);

        chartOne();
        chartTwo();
    }

    /**
     * 성별평균을 기준으로 하는 HorizontalBarChart
     */
    public void chartOne() {
        List<BarEntry> entries = new ArrayList<>();
        //entries.add(new BarEntry(0, 30));
        //entries.add(new BarEntry(1, 0));
        //entries.add(new BarEntry(2,  80));
        //userGender = 1;

        Log.d("tag", "Tab2_Chart1 Dist " + pref.getInt("AVGDIST", 0));
        Log.d("tag", "Tab2_Chart1 Gender " + pref.getString("GENDER", ""));
        Log.d("tag", "Tab2_Chart1 Male " + pref.getFloat("AVGMALE" ,0));
        Log.d("tag", "Tab2_Chart1 Female " + pref.getFloat("AVGFEMALE", 0));

        entries.add(new BarEntry(2, pref.getInt("AVGDIST", 0)));
        entries.add(new BarEntry(1, 0));
        if(  pref.getString("GENDER", "").compareTo("male") == 0 ) {
            entries.add(new BarEntry(0, pref.getFloat("AVGMALE", 0)));
            userGender = 1;
        }
        else {
            entries.add(new BarEntry(0, pref.getFloat("AVGFEMALE", 0)));
            userGender = 2;
        }

        BarDataSet set = new BarDataSet(entries, "이동거리");

        BarData data = new BarData(set);
        data.setBarWidth(0.8f); // set custom bar width
        data.setValueTextSize(14f);
        data.setValueFormatter(new MyValueFormatter());

        initAxisOne();

        chart1.setData(data);
        chart1.setFitBars(true); // make the x-axis fit exactly all bars
        chart1.setTouchEnabled(false); // 차트의 막대 선택 여부
        chart1.setScaleEnabled(false); // 차트의 x,y축 확대 여부
        chart1.setDescription(""); // 차트 우측하단의 설명문구
        chart1.invalidate(); // refresh
    }

    /**
     * 성별평균을 기준으로 하는 HorizontalBarChart의 가로축
     */
    public void initAxisOne() {

        XAxis xAxis = chart1.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftYAxis = chart1.getAxisLeft();
        leftYAxis.setEnabled(false);

        YAxis rightYAxis = chart1.getAxisRight();
        rightYAxis.setEnabled(false);
    }

    /**
     * 나이평균을 기준으로 하는 HorizontalBarChart
     */
    public void chartTwo() {
        List<BarEntry> entries = new ArrayList<>();
        //entries.add(new BarEntry(0, 40));
        //entries.add(new BarEntry(1, 0));
        //entries.add(new BarEntry(2, 10));
        //userAge = 2;

        Log.d("tag", "Tab2_Chart2 Dist " + pref.getInt("AVGDIST", 0));
        Log.d("tag", "Tab2_Chart2 Age " + pref.getInt("AGE", 0));
        Log.d("tag", "Tab2_Chart2 10 " + pref.getFloat("AVG10S" ,0));
        Log.d("tag", "Tab2_Chart2 20 " + pref.getFloat("AVG20S" ,0));
        Log.d("tag", "Tab2_Chart2 30 " + pref.getFloat("AVG30S" ,0));
        Log.d("tag", "Tab2_Chart2 40 " + pref.getFloat("AVG40S" ,0));
        Log.d("tag", "Tab2_Chart2 50 " + pref.getFloat("AVG50S" ,0));

        entries.add(new BarEntry(2, pref.getInt("AVGDIST", 0)));
        entries.add(new BarEntry(1, 0));
        if(pref.getInt("AGE", 10) < 20) {
            entries.add(new BarEntry(0, pref.getFloat("AVG10S", 0)));
            userAge = 1;
        }
        else if(pref.getInt("AGE", 10) >= 20 && pref.getInt("AGE", 10) < 30) {
            entries.add(new BarEntry(0, pref.getFloat("AVG20S", 0)));
            userAge = 2;
        }
        else if(pref.getInt("AGE", 10) >= 30 && pref.getInt("AGE", 10) < 40) {
            entries.add(new BarEntry(0, pref.getFloat("AVG30S", 0)));
            userAge = 3;
        }
        else if(pref.getInt("AGE", 10) >= 40 && pref.getInt("AGE", 10) < 50) {
            entries.add(new BarEntry(0, pref.getFloat("AVG40S", 0)));
            userAge = 4;
        }
        else {
            entries.add(new BarEntry(0, pref.getFloat("AVG50S", 0)));
            userAge = 5;
        }

        BarDataSet set = new BarDataSet(entries, "이동거리");

        BarData data = new BarData(set);
        data.setBarWidth(0.8f); // set custom bar width
        data.setValueTextSize(14f);
        data.setValueFormatter(new MyValueFormatter());

        initAxisTwo();

        chart2.setData(data);
        chart2.setFitBars(true); // make the x-axis fit exactly all bars
        chart2.setTouchEnabled(false); // 차트의 막대 선택 여부
        chart2.setScaleEnabled(false); // 차트의 x,y축 확대 여부
        chart2.setDescription(""); // 차트 우측하단의 설명문구
        chart2.invalidate(); // refresh
    }

    /**
     * 나이평균을 기준으로 하는 HorizontalBarChart의 가로축
     */
    public void initAxisTwo() {

        XAxis xAxis = chart2.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftYAxis = chart2.getAxisLeft();
        leftYAxis.setEnabled(false);

        YAxis rightYAxis = chart2.getAxisRight();
        rightYAxis.setEnabled(false);
    }

    /**
     * float형으로 나오던 바의 값을 int형으로 변환
     */
    public class MyValueFormatter implements ValueFormatter {
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return "" + ((int) value);
        }
    }
}
