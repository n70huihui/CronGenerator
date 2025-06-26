package cn.edu.hnu.cronplugin.components;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 最近工作日单选框
 */
public class CronNearestWeekDayRadioPanel extends JPanel {
    private JRadioButton nearestWeekDayRadio;
    private JTextField nearestWeekDayField;
    private JLabel nearestWeekDayLabel;

    public CronNearestWeekDayRadioPanel(String description,
                                        String nearestWeekDayField, String nearestWeekDayLabel,
                                        int columns) {
        // region 初始化组件
        this.nearestWeekDayRadio = new JRadioButton(description);
        this.nearestWeekDayField = new JTextField(nearestWeekDayField, columns);
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
