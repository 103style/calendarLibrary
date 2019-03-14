package com.tcl.p_calendar;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by wzhiqiang on 2018/11/2.
 */

public class MonthDefaultTitleFormatter implements TitleFormatter {

    private Calendar calendar;

    public MonthDefaultTitleFormatter() {
        calendar = Calendar.getInstance();
    }

    @Override
    public CharSequence format(CalendarDay day) {
        calendar.set(Calendar.MONTH, day.getMonth() - 1);
        return calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
    }
}
