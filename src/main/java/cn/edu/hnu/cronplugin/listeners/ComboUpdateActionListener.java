package cn.edu.hnu.cronplugin.listeners;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 下拉选择框变换时触发此监听器
 */
public class ComboUpdateActionListener implements ActionListener {

    private final CronItemEnum cronItemEnum;

    private final AbstractPanelComponent component;

    public ComboUpdateActionListener(CronItemEnum cronItemEnum, AbstractPanelComponent component) {
        this.cronItemEnum = cronItemEnum;
        this.component = component;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.component.updateInnerComponentsAvailability();
        this.component.updateResultCronExpression(this.cronItemEnum);
    }
}
