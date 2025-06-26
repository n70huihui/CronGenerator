package cn.edu.hnu.cronplugin.components;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 间隔选择面板
 */
public class CronIntervalRadioPanel extends JPanel {
    // 单选框
    private JRadioButton intervalRadio;
    // 间隔选项的组件
    private JTextField intervalFromField;
    private JTextField intervalToField;

    private JLabel intervalFromLabel;
    private JLabel intervalToLabel;

    public CronIntervalRadioPanel(String description,
                                  String intervalFromField, String intervalFromLabel,
                                  String intervalToField, String intervalToLabel,
                                  int fromColumns, int toColumns) {
        // region 初始化内部组件
        this.intervalRadio = new JRadioButton(description);
        this.intervalFromField = new JTextField(intervalFromField, fromColumns);
        this.intervalToField = new JTextField(intervalToField, toColumns);
        this.intervalFromLabel = new JLabel(intervalFromLabel);
        this.intervalToLabel = new JLabel(intervalToLabel);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(this.intervalRadio);
        add(Box.createHorizontalStrut(5));
        add(this.intervalFromField);
        add(Box.createHorizontalStrut(5));
        add(this.intervalFromLabel);
        add(Box.createHorizontalStrut(5));
        add(this.intervalToField);
        add(Box.createHorizontalStrut(5));
        add(this.intervalToLabel);
        // endregion

    }

    public JRadioButton getIntervalRadio() {
        return intervalRadio;
    }

    public JTextField getIntervalFromField() {
        return intervalFromField;
    }

    public JTextField getIntervalToField() {
        return intervalToField;
    }

    public JLabel getIntervalFromLabel() {
        return intervalFromLabel;
    }

    public JLabel getIntervalToLabel() {
        return intervalToLabel;
    }
}
