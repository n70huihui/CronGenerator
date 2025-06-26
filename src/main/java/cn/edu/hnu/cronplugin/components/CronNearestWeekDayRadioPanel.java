package cn.edu.hnu.cronplugin.components;

import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.listeners.RadioUpdateItemListener;
import cn.edu.hnu.cronplugin.listeners.TextFieldUpdateDocumentListener;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 最近工作日单选框
 */
public class CronNearestWeekDayRadioPanel extends AbstractPanelComponent {
    private JRadioButton nearestWeekDayRadio;
    private JTextField nearestWeekDayField;
    private JLabel nearestWeekDayLabel;

    public CronNearestWeekDayRadioPanel(CronItemEnum cronItemEnum, String description,
                                        String nearestWeekDayField, String nearestWeekDayLabel,
                                        int columns) {
        // region 初始化组件
        this.cronItemEnum = cronItemEnum;
        this.nearestWeekDayRadio = new JRadioButton(description);
        this.nearestWeekDayField = new JTextField(nearestWeekDayField, columns);
        this.nearestWeekDayField.setEnabled(false);
        this.nearestWeekDayLabel = new JLabel(nearestWeekDayLabel);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(this.nearestWeekDayRadio);
        add(Box.createHorizontalStrut(5));
        add(this.nearestWeekDayField);
        add(Box.createHorizontalStrut(5));
        add(this.nearestWeekDayLabel);
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    @Override
    public void setupItemListener() {
        RadioUpdateItemListener radioUpdateItemListener = new RadioUpdateItemListener(cronItemEnum, this);
        this.nearestWeekDayRadio.addItemListener(radioUpdateItemListener);
    }

    @Override
    public void setupDocumentListener() {
        TextFieldUpdateDocumentListener textFieldUpdateDocumentListener = new TextFieldUpdateDocumentListener(cronItemEnum, this);
        this.nearestWeekDayField.getDocument().addDocumentListener(textFieldUpdateDocumentListener);
    }

    @Override
    public void setupActionListener() {

    }

    @Override
    public void updateInnerComponentsAvailability() {
        this.nearestWeekDayField.setEnabled(this.nearestWeekDayRadio.isSelected());
    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {
        if (this.nearestWeekDayRadio.isSelected()) {
            CronExpressionUtil.setNearestWeekdayOfMonth(this.nearestWeekDayField.getText());
            CronResultPanelUtil.updateCronExpression();
        }
    }

    public JRadioButton getNearestWeekDayRadio() {
        return nearestWeekDayRadio;
    }

    public JTextField getNearestWeekDayField() {
        return nearestWeekDayField;
    }

    public JLabel getNearestWeekDayLabel() {
        return nearestWeekDayLabel;
    }
}
