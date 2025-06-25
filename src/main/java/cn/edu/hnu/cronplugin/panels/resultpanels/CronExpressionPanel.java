package cn.edu.hnu.cronplugin.panels.resultpanels;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;

public class CronExpressionPanel extends AbstractPanel {

    private JLabel cronExpressionLabel;
    private JTextField cronExpressionField;

    @Override
    protected void initializeComponents() {
        cronExpressionLabel = new JLabel("表达式: ");
        cronExpressionField = new JTextField("* * * * * *");
    }

    @Override
    protected void setupLayout() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 0 ,5));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        add(cronExpressionLabel);
        add(Box.createHorizontalStrut(10));
        add(cronExpressionField);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
