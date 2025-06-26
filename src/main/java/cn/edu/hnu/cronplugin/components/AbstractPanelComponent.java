package cn.edu.hnu.cronplugin.components;

import cn.edu.hnu.cronplugin.cron.CronItemEnum;

import javax.swing.JPanel;

/**
 * 抽象面板组件
 */
public abstract class AbstractPanelComponent extends JPanel {
    protected CronItemEnum cronItemEnum;
    // public abstract void setupActionListener();
    /**
     * 更新内部组件的可用性
     */
    public abstract void updateInnerComponentsAvailability();

    /**
     * 更新最终的cron表达式
     */
    public abstract void updateResultCronExpression(CronItemEnum cronItemEnum);
}
