package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.CronRadioButton;
import cn.edu.hnu.cronplugin.components.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.components.CronSpecifyRadioPanel;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.ContentPanelUtil;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CronHoursPanel extends AbstractPanel {
    // 单选组件
    private ButtonGroup radioGroup;
    // 单选按钮
    private CronRadioButton everyHoursRadioButton;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 间隔面板
    private CronIntervalRadioPanel intervalRadioPanel;
    // 复选框面板
    private CronSpecifyRadioPanel specifyRadioPanel;

    @Override
    protected void initializeComponents() {

        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每秒执行
        everyHoursRadioButton = new CronRadioButton("每小时 允许的通配符[,-*/]");
        everyHoursRadioButton.setSelected(true);
        radioGroup.add(everyHoursRadioButton);

        // 选项2：范围执行的单选按钮
        rangeRadioPanel = new CronRangeRadioPanel("周期从",
                "1", "小时到",
                "2", "小时",
                5, 5
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项3：间隔执行的单选按钮
        intervalRadioPanel = new CronIntervalRadioPanel("周期从",
                "0", "小时开始, 每",
                "1", "小时执行一次",
                5, 5
        );
        radioGroup.add(intervalRadioPanel.getIntervalRadio());

        // 选项4：指定小时的单选按钮
        specifyRadioPanel = new CronSpecifyRadioPanel("指定", 2, 12, 0);
        radioGroup.add(specifyRadioPanel.getSpecifyRadio());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());
        // 将所有组件添加到主内容面板，并设置适当的间距
        JPanel contentPanel = ContentPanelUtil.assembledContentPanel(
                everyHoursRadioButton,
                rangeRadioPanel,
                intervalRadioPanel,
                specifyRadioPanel
        );
        // 这里需要添加一个 contentPanel 并且放在 NORTH 位置，这样组件显示紧凑一些，好看点~
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

        everyHourRadio.addActionListener(radioListener);
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
        updateComponentStates();*/
    }

    /*private void updateComponentStates() {
        // 启用/禁用范围输入框
        rangeFromField.setEnabled(rangeRadio.isSelected());
        rangeToField.setEnabled(rangeRadio.isSelected());

        // 启用/禁用间隔输入框
        intervalStartField.setEnabled(intervalRadio.isSelected());
        intervalStepField.setEnabled(intervalRadio.isSelected());

        // 启用/禁用复选框
        boolean checkboxesEnabled = specifyRadio.isSelected();

        // 启用/禁用上午复选框
        for (JCheckBox checkbox : amCheckboxes) {
            if (checkbox != null) {
                checkbox.setEnabled(checkboxesEnabled);
            }
        }

        // 启用/禁用下午复选框
        for (JCheckBox checkbox : pmCheckboxes) {
            if (checkbox != null) {
                checkbox.setEnabled(checkboxesEnabled);
            }
        }
    }*/
}
