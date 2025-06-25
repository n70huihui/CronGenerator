package cn.edu.hnu.cronplugin.cron;

/**
 * Cron 表达式子项枚举
 */
public enum CronItemEnum {

    SECOND("秒", 0),
    MINUTE("分钟", 1),
    HOUR("小时", 2),
    DAY("日", 3),
    MONTH("月", 4),
    WEEK("周", 5),
    YEAR("年", 6);

    private String item;
    private int index;

    CronItemEnum(String item, int index) {
        this.index = index;
        this.item = item;
    }

    public int getIndex() {
        return this.index;
    }

    public String getItem() {
        return this.item;
    }
}
