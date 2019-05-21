package com.tcl.p_calendar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import org.threeten.bp.LocalDate;

import java.util.Calendar;
import java.util.HashSet;


public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.test);

        calendarView.setTitleFormatter(new MonthDefaultTitleFormatter(getResources().getStringArray(R.array.month_array)));

        calendarView.setSelectedDate(CalendarDay.today());

        calendarView.setLeftArrow(R.drawable.calendar_select_left);
        calendarView.setRightArrow(R.drawable.calendar_select_right);

        calendarView.setTodayTextColor(R.color.calendar_taday_text_color);
        calendarView.setTvRightTopText(R.string.tv_today);

//        calendarView.setSelectionDrawable(ContextCompat.getDrawable(this, R.drawable.calendar_select_right));

        HashSet<CalendarDay> dates = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            CalendarDay c = CalendarDay.from(LocalDate.of(2019, 3, 10 + i));
            dates.add(c);
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
