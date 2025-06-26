package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.CronNearestWeekDayRadioPanel;
import cn.edu.hnu.cronplugin.components.CronRadioButton;
import cn.edu.hnu.cronplugin.components.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.components.CronSpecifyRadioPanel;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CronDaysPanel extends AbstractPanel {
    // 单选组件
    private ButtonGroup radioGroup;
    // 单选按钮
    private CronRadioButton everyDaysRadioButton;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 间隔面板
    private CronIntervalRadioPanel intervalRadioPanel;
    // 最近的工作日
    private CronNearestWeekDayRadioPanel nearestWeekDayRadioPanel;
    // 本月最后一天
    private CronRadioButton lastDayOfMonthRadioButton;
    // 本月最后一个工作日
    private CronRadioButton lastWeekDayOfMonthRadioButton;
    // 不指定
    private CronRadioButton noSpecifyRadioButton;
    // 复选框面板
    private CronSpecifyRadioPanel specifyRadioPanel;

    @Override
    protected void initializeComponents() {

        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每日执行
        everyDaysRadioButton = new CronRadioButton("每日 允许的通配符[,-*/LW]");
        everyDaysRadioButton.setSelected(true);
        radioGroup.add(everyDaysRadioButton);

        // 选项2：范围执行的单选按钮
        rangeRadioPanel = new CronRangeRadioPanel("周期从",
                "1", "日到",
                "2", "日",
                5, 5
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项3：间隔执行的单选按钮
        intervalRadioPanel = new CronIntervalRadioPanel("周期从",
                "0", "日开始, 每",
                "1", "日执行一次",
                5, 5
        );
        radioGroup.add(intervalRadioPanel.getIntervalRadio());

        // 选项4：指定最近工作日
        nearestWeekDayRadioPanel = new CronNearestWeekDayRadioPanel("每月",
                "1", "日最近的那个工作日",
                5);
        radioGroup.add(nearestWeekDayRadioPanel.getNearestWeekDayRadio());

        // 选项5：本月最后一天
        lastDayOfMonthRadioButton = new CronRadioButton("本月最后一天");
        radioGroup.add(lastDayOfMonthRadioButton);

        // 选项6：本月最后一个工作日
        lastWeekDayOfMonthRadioButton = new CronRadioButton("本月最后一个工作日");
        radioGroup.add(lastWeekDayOfMonthRadioButton);

        // 选项7：不指定
        noSpecifyRadioButton = new CronRadioButton("不指定");
        radioGroup.add(noSpecifyRadioButton);

        // 选项8：指定
        specifyRadioPanel = new CronSpecifyRadioPanel("指定", 1, 31, 1, 3, 13);
        radioGroup.add(specifyRadioPanel.getSpecifyRadio());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());

        // 创建主内容面板
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // 将所有组件添加到主内容面板，并设置适当的间距
        contentPanel.add(everyDaysRadioButton);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(rangeRadioPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(intervalRadioPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(nearestWeekDayRadioPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(lastDayOfMonthRadioButton);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(lastWeekDayOfMonthRadioButton);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(noSpecifyRadioButton);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(specifyRadioPanel);

        add(contentPanel, BorderLayout.NORTH);
    }

    @Override
    protected void setupEventHandlers() {
        /*// 根据单选按钮选择启用/禁用组件
        ActionListener radioListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateComponentStates();
            }
        };

        everyDayRadio.addActionListener(radioListener);
        noSpecifyRadio.addActionListener(radioListener);
        rangeRadio.addActionListener(radioListener);
        intervalRadio.addActionListener(radioListener);
        nearestWeekdayRadio.addActionListener(radioListener);
        lastDayRadio.addActionListener(radioListener);
        lastWeekDayRadio.addActionListener(radioListener);
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
        nearestWeekdayField.addActionListener(fieldListener);

        // 设置初始状态
        updateComponentStates();*/
    }

    /*private void updateComponentStates() {
        // 启用/禁用范围输入框
        rangeFromField.setEnabled(rangeRadio.isSelected());
        rangeToField.setEnabled(rangeRadio.isSelected());

        // 启用/禁用间隔输入框
        intervalStartField.setEnabled(intervalRadio.isSelected());
        intervalStepField.setEnabled(intervalRadio.isSelected());

        // 启用/禁用最近工作日输入框
        nearestWeekdayField.setEnabled(nearestWeekdayRadio.isSelected());

        // 启用/禁用复选框
        boolean checkboxesEnabled = specifyRadio.isSelected();
        for (JCheckBox checkbox : dayCheckboxes) {
            if (checkbox != null) {
                checkbox.setEnabled(checkboxesEnabled);
            }
        }
    }*/
}
