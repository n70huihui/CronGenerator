package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class CronYearsPanel extends AbstractPanel {

    private ButtonGroup radioGroup;
    private JRadioButton everyYearRadio;
    private JRadioButton noSpecifyRadio;
    private JRadioButton rangeRadio;
    private JRadioButton unUsedRadio;

    // 范围选项的组件
    private JTextField rangeFromField;
    private JTextField rangeToField;

    @Override
    protected void initializeComponents() {
        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每年执行（默认选中）
        everyYearRadio = new JRadioButton("每年 允许的通配符[,-*/]", true);
        everyYearRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        radioGroup.add(everyYearRadio);

        // 选项2：不指定
        noSpecifyRadio = new JRadioButton("不指定");
        noSpecifyRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        radioGroup.add(noSpecifyRadio);

        // 选项3：范围执行的单选按钮
        rangeRadio = new JRadioButton("周期从");
        radioGroup.add(rangeRadio);

        // 获取当前年份作为默认值
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // 范围选项的输入框
        rangeFromField = new JTextField(String.valueOf(currentYear), 6);
        rangeToField = new JTextField(String.valueOf(currentYear + 1), 6);

        // 选项4：不使用（支持 Unix Cron）
        unUsedRadio = new JRadioButton("不使用");
        unUsedRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        radioGroup.add(unUsedRadio);
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());

        // 创建主内容面板
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // 选项3：范围 - 左对齐并包含组件
        JPanel rangePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        rangePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        rangePanel.add(rangeRadio);
        rangePanel.add(Box.createHorizontalStrut(5));
        rangePanel.add(rangeFromField);
        rangePanel.add(Box.createHorizontalStrut(5));
        rangePanel.add(new JLabel("到"));
        rangePanel.add(Box.createHorizontalStrut(5));
        rangePanel.add(rangeToField);

        // 将所有组件添加到主内容面板，并设置适当的间距
        contentPanel.add(everyYearRadio);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(noSpecifyRadio);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(rangePanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(unUsedRadio);

        add(contentPanel, BorderLayout.NORTH);
    }

    @Override
    protected void setupEventHandlers() {
        // 根据单选按钮选择启用/禁用组件
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateComponentStates();
            }
        };

        noSpecifyRadio.addActionListener(radioListener);
        everyYearRadio.addActionListener(radioListener);
        rangeRadio.addActionListener(radioListener);

        // 为输入框添加变化监听器
        ActionListener fieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };

        rangeFromField.addActionListener(fieldListener);
        rangeToField.addActionListener(fieldListener);

        // 设置初始状态
        updateComponentStates();
    }

    private void updateComponentStates() {
        // 启用/禁用范围输入框
        rangeFromField.setEnabled(rangeRadio.isSelected());
        rangeToField.setEnabled(rangeRadio.isSelected());
    }
}
