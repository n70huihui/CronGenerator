package cn.edu.hnu.cronplugin.utils;

import cn.edu.hnu.cronplugin.cron.CronExpression;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 单例饿汉模式，创建 Cron 表达式
 */
public class CronExpressionUtil {

    private CronExpressionUtil() {}

    private static final CronExpression CRON_EXPRESSION = new CronExpression();

    public static CronExpression getCronExpressionInstance() {
        return CRON_EXPRESSION;
    }

    public static String getCronExpression() {
        return CRON_EXPRESSION.getExpression();
    }

    /**
     * 设置每秒、每分、每小时、每天、每月、每周、每年
     * @param itemEnum
     */
    public static void setEvery(CronItemEnum itemEnum) {
        CRON_EXPRESSION.setItemByIndex(itemEnum.getIndex(), "*");
    }

    /**
     * 设置范围
     * @param itemEnum
     * @param start
     * @param end
     */
    public static void setRange(CronItemEnum itemEnum, String start, String end) {
        if (!StringUtils.isNumeric(start) || !StringUtils.isNumeric(end)) {
            return;
        }
        CRON_EXPRESSION.setItemByIndex(itemEnum.getIndex(), start + "-" + end);
    }

    /**
     * 设置周期
     * @param itemEnum
     * @param start
     * @param end
     */
    public static void setInterval(CronItemEnum itemEnum, String start, String end) {
        if (!StringUtils.isNumeric(start) || !StringUtils.isNumeric(end)) {
            return;
        }
        CRON_EXPRESSION.setItemByIndex(itemEnum.getIndex(), start + "/" + end);
    }

    /**
     * 指定具体值
     * @param itemEnum
     * @param values
     */
    public static void setSpecify(CronItemEnum itemEnum, List<String> values) {
        if (values.isEmpty()) {
            setNoSpecify(itemEnum);
            return;
        }
        String specifyStr = values.stream()
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(","));
        CRON_EXPRESSION.setItemByIndex(itemEnum.getIndex(), specifyStr);
    }

    /**
     * 不指定
     * @param itemEnum
     */
    public static void setNoSpecify(CronItemEnum itemEnum) {
        CRON_EXPRESSION.setItemByIndex(itemEnum.getIndex(), "?");
    }

    /**
     * 不使用，针对“年”这个字段
     * @param itemEnum
     */
    public static void setUnUsed(CronItemEnum itemEnum) {
        if (CronItemEnum.YEAR.getIndex() != itemEnum.getIndex()) {
            return;
        }
        CRON_EXPRESSION.setItemByIndex(itemEnum.getIndex(), "");
    }

    /**
     * 设置每月最近的工作日
     * @param day
     */
    public static void setNearestWeekdayOfMonth(String day) {
        if (!StringUtils.isNumeric(day)) {
            return;
        }
        CRON_EXPRESSION.setItemByIndex(CronItemEnum.DAY.getIndex(), day + "W");
    }

    /**
     * 设置每月最后一天
     */
    public static void setLastDayOfMonth() {
        CRON_EXPRESSION.setItemByIndex(CronItemEnum.DAY.getIndex(), "L");
    }

    /**
     * 设置每月最后一个工作日
     */
    public static void setLastWeekdayOfMonth() {
        CRON_EXPRESSION.setItemByIndex(CronItemEnum.DAY.getIndex(), "LW");
    }

    /**
     * 设置每周第N个星期
     * @param week
     * @param day
     */
    public static void setNthWeek(String week, String day) {
        if (!StringUtils.isNumeric(week) || !StringUtils.isNumeric(day)) {
            return;
        }
        CRON_EXPRESSION.setItemByIndex(CronItemEnum.WEEK.getIndex(), week + "#" + day);
    }

    /**
     * 设置每月最后一个星期
     * @param day
     */
    public static void setLastWeekOfMonth(String day) {
        if (!StringUtils.isNumeric(day)) {
            return;
        }
        CRON_EXPRESSION.setItemByIndex(CronItemEnum.WEEK.getIndex(), day + "L");
    }
}
