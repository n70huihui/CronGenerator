package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.CronLastWeekPanel;
import cn.edu.hnu.cronplugin.components.CronRadioButton;
import cn.edu.hnu.cronplugin.components.CronRadioButtonPanel;
import cn.edu.hnu.cronplugin.components.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.components.CronSpecifyRadioPanel;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.ContentPanelUtil;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class CronWeeksPanel extends AbstractPanel {
    // 单选组件
    private ButtonGroup radioGroup;
    // 单选面板
    private CronRadioButtonPanel radioButtonPanel;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 间隔面板
    private CronIntervalRadioPanel intervalRadioPanel;
    // 本月最后一个星期
    private CronLastWeekPanel lastWeekDayPanel;
    // 不指定
    private CronRadioButton noSpecifyRadioButton;
    // 复选框面板
    private CronSpecifyRadioPanel specifyRadioPanel;

    @Override
    protected void initializeComponents() {
        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每秒执行
        radioButtonPanel = new CronRadioButtonPanel("每周 允许的通配符[,-*/L#]");
        radioGroup.add(radioButtonPanel.getRadioButton());

        // 选项2：范围执行的单选按钮
        rangeRadioPanel = new CronRangeRadioPanel("周期从第",
                "1", "周到第",
                "2", "周",
                5, 5
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项3：间隔执行的单选按钮
        intervalRadioPanel = new CronIntervalRadioPanel("第",
                "1", "周的星期",
                "1", "",
                5, 5
        );
        radioGroup.add(intervalRadioPanel.getIntervalRadio());

        // 选项4：本月最后一个星期
        lastWeekDayPanel = new CronLastWeekPanel("本月最后一个星期");
        radioGroup.add(lastWeekDayPanel.getLastWeekdayRadio());

        // 选项5：不指定
        noSpecifyRadioButton = new CronRadioButton("不指定");
        noSpecifyRadioButton.setSelected(true);
        radioGroup.add(noSpecifyRadioButton);

        // 选项6：指定
        specifyRadioPanel = new CronSpecifyRadioPanel("指定", 1, 7, 1);
        radioGroup.add(specifyRadioPanel.getSpecifyRadio());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());

        // 创建主内容面板
        JPanel contentPanel = ContentPanelUtil.assembledContentPanel(
                radioButtonPanel,
                rangeRadioPanel,
                intervalRadioPanel,
                lastWeekDayPanel,
                noSpecifyRadioButton,
                specifyRadioPanel
        );

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

        everyWeekRadio.addActionListener(radioListener);
        noSpecifyRadio.addActionListener(radioListener);
        rangeRadio.addActionListener(radioListener);
        nthWeekRadio.addActionListener(radioListener);
        lastWeekdayRadio.addActionListener(radioListener);
        specifyRadio.addActionListener(radioListener);

        // 为输入框添加变化监听器
        ActionListener fieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };

        rangeFromField.addActionListener(fieldListener);
        rangeToField.addActionListener(fieldListener);
        nthWeekField.addActionListener(fieldListener);
        nthWeekdayField.addActionListener(fieldListener);

        // 为下拉框添加变化监听器
        lastWeekdayCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // 设置初始状态
        updateComponentStates();*/
    }

/*    private void updateComponentStates() {
        // 启用/禁用范围输入框
        rangeFromField.setEnabled(rangeRadio.isSelected());
        rangeToField.setEnabled(rangeRadio.isSelected());

        // 启用/禁用第N周输入框
        nthWeekField.setEnabled(nthWeekRadio.isSelected());
        nthWeekdayField.setEnabled(nthWeekRadio.isSelected());

        // 启用/禁用最后一个星期下拉框
        lastWeekdayCombo.setEnabled(lastWeekdayRadio.isSelected());

        // 启用/禁用复选框
        boolean checkboxesEnabled = specifyRadio.isSelected();
        for (JCheckBox checkbox : weekCheckboxes) {
            if (checkbox != null) {
                checkbox.setEnabled(checkboxesEnabled);
            }
        }
    }*/
}
