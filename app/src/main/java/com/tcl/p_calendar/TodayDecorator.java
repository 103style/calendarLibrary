package com.tcl.p_calendar;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.tcl.calendar.CalendarDay;
import com.tcl.calendar.DayViewDecorator;
import com.tcl.calendar.DayViewFacade;


/**
 * Created by wzhiqiang on 2018/11/1.
 */

public class TodayDecorator implements DayViewDecorator {

    private CalendarDay today;
    private Drawable drawable;

    public TodayDecorator(Context context){
        today = CalendarDay.today();
        drawable = context.getResources().getDrawable(R.drawable.calendar_today_bg);
    }
    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return today != null && today.equals(day);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.setBackgroundDrawable(drawable);
    }
}
