package cn.edu.hnu.cronplugin.components;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 范围选择面板
 */
public class CronRangeRadioPanel extends JPanel {
    // 单选框
    private JRadioButton rangeRadio;
    // 范围选项的组件
    private JTextField rangeFromField;
    private JTextField rangeToField;

    private JLabel rangeFromLabel;
    private JLabel rangeToLabel;

    public CronRangeRadioPanel(String description,
                               String rangeFromField, String rangeFromLabel,
                               String rangeToField, String rangeToLabel,
                               int fromColumns, int toColumns) {
        // region 初始化内部组件
        this.rangeRadio = new JRadioButton(description);
        this.rangeFromField = new JTextField(rangeFromField, fromColumns);
        this.rangeToField = new JTextField(rangeToField, toColumns);
        this.rangeFromLabel = new JLabel(rangeFromLabel);
        this.rangeToLabel = new JLabel(rangeToLabel);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(this.rangeRadio);
        add(Box.createHorizontalStrut(5));
        add(this.rangeFromField);
        add(Box.createHorizontalStrut(5));
        add(this.rangeFromLabel);
        add(Box.createHorizontalStrut(5));
        add(this.rangeToField);
        add(Box.createHorizontalStrut(5));
        add(this.rangeToLabel);
        // endregion

    }

    public JRadioButton getRangeRadio() {
        return rangeRadio;
    }

    public JTextField getRangeFromField() {
        return rangeFromField;
    }

    public JTextField getRangeToField() {
        return rangeToField;
    }

    public JLabel getRangeFromLabel() {
        return rangeFromLabel;
    }

    public JLabel getRangeToLabel() {
        return rangeToLabel;
    }
}
