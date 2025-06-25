package cn.edu.hnu.cronplugin.cron;

import org.apache.commons.lang3.StringUtils;

/**
 * Cron 表达式元数据配置
 */
public class CronExpression {

    private String[] expression;

    public CronExpression() {
        expression = new String[]{"*", "*", "*", "*", "*", "?", "*"};
    }

    /**
     * 返回最终的 Cron 表达式
     * @return
     */
    public String getExpression() {
        return StringUtils.join(expression, " ");
    }

    /**
     * 根据索引直接设置
     * @param index 索引
     * @param val 值
     */
    public void setItemByIndex(int index, String val) {
        expression[index] = val;
    }

    /**
     * 获取
     * @return second
     */
    public String getSecond() {
        return expression[0];
    }

    /**
     * 设置
     * @param second
     */
    public void setSecond(String second) {
        this.expression[0] = second;
    }

    /**
     * 获取
     * @return minute
     */
    public String getMinute() {
        return expression[1];
    }

    /**
     * 设置
     * @param minute
     */
    public void setMinute(String minute) {
        this.expression[1] = minute;
    }

    /**
     * 获取
     * @return hour
     */
    public String getHour() {
        return expression[2];
    }

    /**
     * 设置
     * @param hour
     */
    public void setHour(String hour) {
        this.expression[2] = hour;
    }

    /**
     * 获取
     * @return day
     */
    public String getDay() {
        return expression[3];
    }

    /**
     * 设置
     * @param day
     */
    public void setDay(String day) {
        this.expression[3] = day;
    }

    /**
     * 获取
     * @return month
     */
    public String getMonth() {
        return expression[4];
    }

    /**
     * 设置
     * @param month
     */
    public void setMonth(String month) {
        this.expression[4] = month;
    }

    /**
     * 获取
     * @return week
     */
    public String getWeek() {
        return expression[5];
    }

    /**
     * 设置
     * @param week
     */
    public void setWeek(String week) {
        this.expression[5] = week;
    }

    /**
     * 获取
     * @return year
     */
    public String getYear() {
        return expression[6];
    }

    /**
     * 设置
     * @param year
     */
    public void setYear(String year) {
        this.expression[6] = year;
    }

    public String toString() {
        return this.getExpression();
    }
}
