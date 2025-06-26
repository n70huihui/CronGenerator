package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.CronRadioButton;
import cn.edu.hnu.cronplugin.components.CronRadioButtonPanel;
import cn.edu.hnu.cronplugin.components.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.components.CronSpecifyRadioPanel;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.ContentPanelUtil;

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

    // 单选组件
    private ButtonGroup radioGroup;
    // 单选面板
    private CronRadioButtonPanel radioButtonPanel;
    // 不指定
    private CronRadioButton noSpecifyRadioButton;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 不使用
    private CronRadioButton unUsedRadioButton;

    @Override
    protected void initializeComponents() {
        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每秒执行
        radioButtonPanel = new CronRadioButtonPanel("每年 允许的通配符[,-*/]");
        radioButtonPanel.getRadioButton().setSelected(true);
        radioGroup.add(radioButtonPanel.getRadioButton());

        // 选项2：不指定
        noSpecifyRadioButton = new CronRadioButton("不指定");
        radioGroup.add(noSpecifyRadioButton);

        // 选项3：周期执行
        rangeRadioPanel = new CronRangeRadioPanel("周期从",
                "2025", "年到",
                "9999", "年",
                5, 5
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项4：不使用
        unUsedRadioButton = new CronRadioButton("不使用");
        radioGroup.add(unUsedRadioButton);
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());
        // 创建主内容面板
        JPanel contentPanel = ContentPanelUtil.assembledContentPanel(
                radioButtonPanel,
                noSpecifyRadioButton,
                rangeRadioPanel,
                unUsedRadioButton
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
        updateComponentStates();*/
    }

/*    private void updateComponentStates() {
        // 启用/禁用范围输入框
        rangeFromField.setEnabled(rangeRadio.isSelected());
        rangeToField.setEnabled(rangeRadio.isSelected());
    }*/
}
