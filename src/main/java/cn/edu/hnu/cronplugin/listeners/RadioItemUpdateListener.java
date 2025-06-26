package cn.edu.hnu.cronplugin.listeners;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * 单选动作发生改变时，触发此监听器
 */
public class RadioItemUpdateListener implements ItemListener {

    private final CronItemEnum cronItemEnum;

    private final AbstractPanelComponent component;

    public RadioItemUpdateListener(CronItemEnum cronItemEnum, AbstractPanelComponent component) {
        this.cronItemEnum = cronItemEnum;
        this.component = component;
    }

    public CronItemEnum getCronItemEnum() {
        return cronItemEnum;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        int stateChange = e.getStateChange();
        // 选中或不选中都触发
        if (stateChange == ItemEvent.SELECTED || stateChange == ItemEvent.DESELECTED) {
            this.component.updateInnerComponentsAvailability();
            this.component.updateResultCronExpression(this.cronItemEnum);
        }
    }

}
