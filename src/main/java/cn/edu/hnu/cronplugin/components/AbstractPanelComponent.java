package cn.edu.hnu.cronplugin.components;

import cn.edu.hnu.cronplugin.cron.CronItemEnum;

import javax.swing.JPanel;

/**
 * 抽象面板组件
 */
public abstract class AbstractPanelComponent extends JPanel {
    /**
     * 标识该组件是属于哪个标签页的
     */
    protected CronItemEnum cronItemEnum;
    /**
     * 设置选项监听器
     */
    public abstract void setupItemListener();
    /**
     * 设置文档监听器
     */
    public abstract void setupDocumentListener();
    /**
     * 设置动作监听器
     */
    public abstract void setupActionListener();
    /**
     * 设置监听器
     */
    public void setupEventListener() {
        setupItemListener();
        setupDocumentListener();
        setupActionListener();
    }
    /**
     * 更新内部组件的可用性
     */
    public abstract void updateInnerComponentsAvailability();

    /**
     * 更新最终的cron表达式
     */
    public abstract void updateResultCronExpression(CronItemEnum cronItemEnum);
}
