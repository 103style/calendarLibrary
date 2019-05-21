package com.tcl.p_calendar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.HashSet;


public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.test);

        //设置月份格式
        calendarView.setTitleFormatter(new MonthDefaultTitleFormatter(getResources().getStringArray(R.array.month_array)));


        //设置月份的左右点击按钮
        calendarView.setLeftArrow(R.drawable.calendar_select_left);
        calendarView.setRightArrow(R.drawable.calendar_select_right);

        // 设置右上角文字的颜色和文字
        calendarView.setTodayTextColor(R.color.calendar_taday_text_color);
        calendarView.setTvRightTopText(R.string.tv_today);

        //选中今天
        calendarView.setSelectedDate(CalendarDay.today());


        //设置 今天之后的日期不能点击  并且不能滑动到 今天之后的月份
        calendarView.setAfterTodayClickable(false);

        // 设置 今天之前的10天 添加标记的日期
        HashSet<CalendarDay> dates = new HashSet<>();
        CalendarDay today = CalendarDay.today();
        for (int i = 0; i < 10; i++) {
            today = today.toPreviousDay();
            dates.add(today);
        }
        calendarView.addDecorator(new EventDecorator(Color.parseColor("#FF01E9C3"),
                getResources().getDisplayMetrics().widthPixels / 120, dates));

        //click today
        calendarView.setTvRightTopClickListener(v -> {
            calendarView.setSelectedDate(CalendarDay.today());
            calendarView.setCurrentDate(CalendarDay.today());
        });

    }
}
