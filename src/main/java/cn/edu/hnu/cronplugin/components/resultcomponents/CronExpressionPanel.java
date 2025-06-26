package cn.edu.hnu.cronplugin.components.resultcomponents;

import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

public class CronExpressionPanel extends JPanel {

    private JLabel cronExpressionLabel;
    private JTextField cronExpressionField;

    public CronExpressionPanel() {
        // region 初始化组件
        cronExpressionLabel = new JLabel("  表达式: ");
        cronExpressionField = new JTextField(CronExpressionUtil.getCronExpression());
        cronExpressionField.setEditable(false);
        cronExpressionField.setColumns(30);
        Font currentFont = cronExpressionField.getFont();
        Font newFont = currentFont.deriveFont(12f);
        cronExpressionField.setFont(newFont);
        // endregion

        // region 初始化布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0 ,5));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        add(cronExpressionLabel);
        add(Box.createHorizontalStrut(10));
        add(cronExpressionField);
        // endregion
    }

    public void setCronExpressionField(String cronExpression) {
        cronExpressionField.setText(cronExpression);
    }
}
