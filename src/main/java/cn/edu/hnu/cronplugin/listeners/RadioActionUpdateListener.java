package cn.edu.hnu.cronplugin.listeners;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 单选动作发生改变时，触发此监听器
 */
public class RadioActionUpdateListener implements ActionListener {

    private final CronItemEnum cronItemEnum;

    private final AbstractPanelComponent component;

    public RadioActionUpdateListener(CronItemEnum cronItemEnum, AbstractPanelComponent component) {
        this.cronItemEnum = cronItemEnum;
        this.component = component;
    }

    public CronItemEnum getCronItemEnum() {
        return cronItemEnum;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.component.updateInnerComponentsAvailability();
        this.component.updateResultCronExpression(this.cronItemEnum);
    }
}
