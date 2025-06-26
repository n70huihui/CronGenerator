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

    public RadioActionUpdateListener(CronItemEnum cronItemEnum) {
        this.cronItemEnum = cronItemEnum;
    }

    public CronItemEnum getCronItemEnum() {
        return cronItemEnum;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractPanelComponent component = (AbstractPanelComponent) e.getSource();
        component.updateInnerComponentsAvailability();
        component.updateResultCronExpression(this.cronItemEnum);
    }
}
