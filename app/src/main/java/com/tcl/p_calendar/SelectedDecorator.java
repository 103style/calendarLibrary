package com.tcl.p_calendar;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.tcl.calendar.CalendarDay;
import com.tcl.calendar.DayViewDecorator;
import com.tcl.calendar.DayViewFacade;

import org.threeten.bp.DayOfWeek;

import java.util.Calendar;

/**
 * Created by wzhiqiang on 2018/11/2.
 */

public class SelectedDecorator implements DayViewDecorator {
    private static final String TAG = "SelectedDecorator";

    private Drawable drawable;
    private SettingsResponse.ReminderBean bean;
    private int color = Color.RED;

    public SelectedDecorator(SettingsResponse.ReminderBean bean, Context context) {
        drawable = context.getResources().getDrawable(R.drawable.calendar_select_bg);
        this.bean = bean;
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        if (bean == null || bean.todo == null) {
            return false;
        }
        for (SettingsResponse.ReminderBean.TodoBean todoBean : bean.todo) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(todoBean.start * 1000);
            CalendarDay calendarDay = CalendarDay.from(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1
                    , calendar.get(Calendar.DAY_OF_MONTH));
            Log.i(TAG, "shouldDecorate: after：" + todoBean.start + "---" + calendarDay.getDate());
            int repeat = todoBean.repeat;
            switch (repeat) {
                case 0://never
                    if (calendarDay.equals(day))
                        return true;
                    break;
                case 1://everyday
                    if (day.isAfter(calendarDay) || day.equals(calendarDay))
                        return true;
                    break;
                case 2://every week
                    if (day.isAfter(calendarDay) || day.equals(calendarDay)) {
                        int dateWeek = DateUtils.getDateWeek(todoBean.start);
                        DayOfWeek dayOfWeek = day.getDate().getDayOfWeek();
                        if (dayOfWeek.getValue() == dateWeek)
                            return true;
                    }
                    break;
                case 3:
                    if (day.isAfter(calendarDay) || day.equals(calendarDay)) {
                        int dayOfMonth = day.getDate().getDayOfMonth();
                        int dayMonth = DateUtils.getDay(todoBean.start);
                        if (dayOfMonth == dayMonth)
                            return true;
                    }
                    break;
                default:
                    break;
            }
        }

        return false;
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new DotSpan(5, color));
    }

    public void setBean(SettingsResponse.ReminderBean bean) {
        this.bean = bean;
    }
}
