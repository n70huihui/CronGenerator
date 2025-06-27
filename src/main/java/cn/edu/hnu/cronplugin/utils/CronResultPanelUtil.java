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
        // 更新面板显示的表达式
        CRON_RESULT_PANEL.setCronExpression(CronExpressionUtil.getCronExpression());
        // 更新执行时间
        CRON_RESULT_PANEL.setExecutionTime(CronExpressionUtil.getNext5Executions());
    }

    public static void setCronExpression(String cronExpression) {
        CRON_RESULT_PANEL.setCronExpression(cronExpression);
    }

}
