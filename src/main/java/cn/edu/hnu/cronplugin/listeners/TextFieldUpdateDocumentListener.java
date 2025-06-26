package cn.edu.hnu.cronplugin.listeners;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 文本框更改时触发此监听器
 */
public class TextFieldUpdateDocumentListener implements DocumentListener {

    private final CronItemEnum cronItemEnum;

    private final AbstractPanelComponent component;

    public TextFieldUpdateDocumentListener(CronItemEnum cronItemEnum, AbstractPanelComponent component) {
        this.cronItemEnum = cronItemEnum;
        this.component = component;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        this.component.updateInnerComponentsAvailability();
        this.component.updateResultCronExpression(this.cronItemEnum);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        this.component.updateInnerComponentsAvailability();
        this.component.updateResultCronExpression(this.cronItemEnum);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
