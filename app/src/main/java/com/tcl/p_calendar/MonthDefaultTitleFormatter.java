package com.tcl.p_calendar;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.format.TitleFormatter;

/**
 * @author xiaoke.luo@tcl.com 2019/3/14 15:09
 * location 历史轨迹 标题格式
 */
public class MonthDefaultTitleFormatter implements TitleFormatter {
    /**
     * 显示的标题月份数组
     */
    private String[] months;

    public MonthDefaultTitleFormatter(String[] months) {
        this.months = months;
    }

    @Override
    public CharSequence format(CalendarDay day) {
        return months[day.getMonth() - 1];
    }
}
