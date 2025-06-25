package cn.edu.hnu.cronplugin.utils;

import cn.edu.hnu.cronplugin.panels.resultpanels.CronResultPanel;

/**
 * 表达式结果工具类
 */
public class CronResultPanelUtil {

    private CronResultPanelUtil() {}

    private static final CronResultPanel CRON_RESULT_PANEL = new CronResultPanel();

    public static CronResultPanel getCronResultPanel() {
        return CRON_RESULT_PANEL;
    }

    public static void updateCronExpression() {
        CRON_RESULT_PANEL.setCronExpression(CronExpressionUtil.getCronExpression());
    }

    public static void setCronExpression(String cronExpression) {
        CRON_RESULT_PANEL.setCronExpression(cronExpression);
    }

}
