package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CronMonthsPanel extends AbstractPanel {
    private ButtonGroup radioGroup;
    private JRadioButton everyMonthRadio;
    private JRadioButton noSpecifyRadio;
    private JRadioButton rangeRadio;
    private JRadioButton intervalRadio;
    private JRadioButton specifyRadio;

    // 范围选项的组件
    private JTextField rangeFromField;
    private JTextField rangeToField;

    // 间隔选项的组件
    private JTextField intervalStartField;
    private JTextField intervalStepField;

    // 指定选项的复选框（1-12月）
    private JCheckBox[] monthCheckboxes;

    @Override
    protected void initializeComponents() {
        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每月执行 - 左对齐
        everyMonthRadio = new JRadioButton("每月 允许的通配符[,-*/]", true);
        everyMonthRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        radioGroup.add(everyMonthRadio);

        // 选项2：不指定
        noSpecifyRadio = new JRadioButton("不指定");
        noSpecifyRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        radioGroup.add(noSpecifyRadio);

        // 选项3：范围执行的单选按钮
        rangeRadio = new JRadioButton("周期从");
        radioGroup.add(rangeRadio);

        // 范围选项的输入框
        rangeFromField = new JTextField("1", 3);
        rangeToField = new JTextField("2", 3);

        // 选项4：间隔执行的单选按钮
        intervalRadio = new JRadioButton("周期从");
        radioGroup.add(intervalRadio);

        // 间隔选项的输入框
        intervalStartField = new JTextField("1", 3);
        intervalStepField = new JTextField("1", 3);

        // 选项5：指定月份的单选按钮
        specifyRadio = new JRadioButton("指定");
        radioGroup.add(specifyRadio);

        // 初始化月份复选框数组（1-12）
        monthCheckboxes = new JCheckBox[12];
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
        rangePanel.add(Box.createHorizontalStrut(5));
        rangePanel.add(new JLabel("月"));

        // 选项4：间隔 - 左对齐并包含组件
        JPanel intervalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        intervalPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        intervalPanel.add(intervalRadio);
        intervalPanel.add(Box.createHorizontalStrut(5));
        intervalPanel.add(intervalStartField);
        intervalPanel.add(Box.createHorizontalStrut(5));
        intervalPanel.add(new JLabel("月开始, 每"));
        intervalPanel.add(Box.createHorizontalStrut(5));
        intervalPanel.add(intervalStepField);
        intervalPanel.add(Box.createHorizontalStrut(5));
        intervalPanel.add(new JLabel("月执行一次"));

        // 选项5：指定 - 复选框网格在右侧
        JPanel specifyPanel = new JPanel(new BorderLayout());
        specifyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 创建单选按钮面板
        JPanel specifyRadioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        specifyRadioPanel.add(specifyRadio);

        // 创建月份复选框网格
        JPanel checkboxPanel = createMonthCheckboxGrid();

        // 将单选按钮放在左侧（西），复选框放在中央
        specifyPanel.add(specifyRadioPanel, BorderLayout.WEST);
        specifyPanel.add(checkboxPanel, BorderLayout.CENTER);

        // 将所有组件添加到主内容面板，并设置适当的间距
        contentPanel.add(everyMonthRadio);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(noSpecifyRadio);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(rangePanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(intervalPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(specifyPanel);

        add(contentPanel, BorderLayout.NORTH);
    }

    private JPanel createMonthCheckboxGrid() {
        JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 10));

        // 创建1-12月的复选框
        for (int i = 0; i < 12; i++) {
            int monthValue = i + 1;
            String text = String.format("%02d", monthValue);
            JCheckBox checkbox = new JCheckBox(text);
            checkbox.setHorizontalAlignment(SwingConstants.CENTER);
            checkbox.setEnabled(false); // 初始状态为禁用

            // 添加复选框变化监听器
            checkbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });

            monthCheckboxes[i] = checkbox;
            gridPanel.add(checkbox);
        }

        return gridPanel;
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

        everyMonthRadio.addActionListener(radioListener);
        noSpecifyRadio.addActionListener(radioListener);
        rangeRadio.addActionListener(radioListener);
        intervalRadio.addActionListener(radioListener);
        specifyRadio.addActionListener(radioListener);

        // 为输入框添加变化监听器
        ActionListener fieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };

        rangeFromField.addActionListener(fieldListener);
        rangeToField.addActionListener(fieldListener);
        intervalStartField.addActionListener(fieldListener);
        intervalStepField.addActionListener(fieldListener);

        // 设置初始状态
        updateComponentStates();
    }

    private void updateComponentStates() {
        // 启用/禁用范围输入框
        rangeFromField.setEnabled(rangeRadio.isSelected());
        rangeToField.setEnabled(rangeRadio.isSelected());

        // 启用/禁用间隔输入框
        intervalStartField.setEnabled(intervalRadio.isSelected());
        intervalStepField.setEnabled(intervalRadio.isSelected());

        // 启用/禁用复选框
        boolean checkboxesEnabled = specifyRadio.isSelected();
        for (JCheckBox checkbox : monthCheckboxes) {
            if (checkbox != null) {
                checkbox.setEnabled(checkboxesEnabled);
            }
        }
    }
}
