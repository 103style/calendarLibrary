package com.tcl.p_calendar;

import android.graphics.Color;
import android.text.style.ForegroundColorSpan;

import com.tcl.calendar.CalendarDay;
import com.tcl.calendar.DayViewDecorator;
import com.tcl.calendar.DayViewFacade;

/**
 * Created by wzhiqiang on 2018/11/1.
 */
public class AfterDayDecorator implements DayViewDecorator {

    private CalendarDay date;

    public AfterDayDecorator() {
        date = CalendarDay.today();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return date != null && day.isAfter(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.parseColor("#ffd7d1d1")));
    }
}
