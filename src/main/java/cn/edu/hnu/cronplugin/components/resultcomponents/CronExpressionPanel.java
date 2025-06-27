package cn.edu.hnu.cronplugin.components.resultcomponents;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.listeners.CronExpressionButtonActionListener;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;

/**
 * Cron 表达式面板
 */
public class CronExpressionPanel extends AbstractPanelComponent {

    private JLabel cronExpressionLabel;
    private JTextField cronExpressionField;
    private JButton button;

    public CronExpressionPanel() {
        // region 初始化组件
        cronExpressionLabel = new JLabel("  表达式: ");

        cronExpressionField = new JTextField(CronExpressionUtil.getCronExpression());
        cronExpressionField.setEditable(false);
        cronExpressionField.setColumns(25);
        Font currentFont = cronExpressionField.getFont();
        Font newFont = currentFont.deriveFont(12f);
        cronExpressionField.setFont(newFont);

        button = new JButton("键入编辑器");
        // endregion

        // region 初始化布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0 ,5));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        add(cronExpressionLabel);
        add(Box.createHorizontalStrut(5));
        add(cronExpressionField);
        add(Box.createHorizontalStrut(5));
        add(button);
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    public void setCronExpressionField(String cronExpression) {
        cronExpressionField.setText(cronExpression);
    }

    @Override
    public void setupItemListener() {

    }

    @Override
    public void setupDocumentListener() {

    }

    @Override
    public void setupActionListener() {
        CronExpressionButtonActionListener listener = new CronExpressionButtonActionListener();
        button.addActionListener(listener);
    }

    @Override
    public void updateInnerComponentsAvailability() {

    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {

    }
}
