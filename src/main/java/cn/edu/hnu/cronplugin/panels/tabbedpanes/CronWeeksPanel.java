package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import com.intellij.openapi.ui.ComboBox;

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

public class CronWeeksPanel extends AbstractPanel {

    private ButtonGroup radioGroup;
    private JRadioButton everyWeekRadio;
    private JRadioButton noSpecifyRadio;
    private JRadioButton rangeRadio;
    private JRadioButton nthWeekRadio;
    private JRadioButton lastWeekdayRadio;
    private JRadioButton specifyRadio;

    // 范围选项的组件
    private JTextField rangeFromField;
    private JTextField rangeToField;

    // 第N周选项的组件
    private JTextField nthWeekField;
    private JTextField nthWeekdayField;

    // 最后一个星期选项的组件
    private ComboBox<String> lastWeekdayCombo;

    // 指定选项的复选框（1-7，代表周日到周六）
    private JCheckBox[] weekCheckboxes;

    // 星期名称数组
    private String[] weekdayNames;

    @Override
    protected void initializeComponents() {
        weekdayNames = new String[]{"日", "一", "二", "三", "四", "五", "六"};

        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每周执行 - 左对齐
        everyWeekRadio = new JRadioButton("每周 允许的通配符[,-*/L#]", true);
        everyWeekRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        radioGroup.add(everyWeekRadio);

        // 选项2：不指定
        noSpecifyRadio = new JRadioButton("不指定");
        noSpecifyRadio.setAlignmentX(Component.LEFT_ALIGNMENT);
        radioGroup.add(noSpecifyRadio);

        // 选项3：范围执行的单选按钮
        rangeRadio = new JRadioButton("周期从星期");
        radioGroup.add(rangeRadio);

        // 范围选项的输入框
        rangeFromField = new JTextField("1", 3);
        rangeToField = new JTextField("2", 3);

        // 选项4：第N周执行的单选按钮
        nthWeekRadio = new JRadioButton("第");
        radioGroup.add(nthWeekRadio);

        // 第N周选项的输入框
        nthWeekField = new JTextField("1", 3);
        nthWeekdayField = new JTextField("1", 3);

        // 选项5：本月最后一个星期
        lastWeekdayRadio = new JRadioButton("本月最后一个星期");
        radioGroup.add(lastWeekdayRadio);

        // 最后一个星期选项的下拉框
        lastWeekdayCombo = new ComboBox<>(weekdayNames);
        lastWeekdayCombo.setSelectedIndex(0); // 默认选择周日

        // 选项6：指定星期的单选按钮
        specifyRadio = new JRadioButton("指定");
        radioGroup.add(specifyRadio);

        // 初始化星期复选框数组（1-7，代表周日到周六）
        weekCheckboxes = new JCheckBox[7];
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
        rangePanel.add(new JLabel("到星期"));
        rangePanel.add(Box.createHorizontalStrut(5));
        rangePanel.add(rangeToField);

        // 选项4：第N周 - 左对齐并包含组件
        JPanel nthWeekPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        nthWeekPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        nthWeekPanel.add(nthWeekRadio);
        nthWeekPanel.add(Box.createHorizontalStrut(5));
        nthWeekPanel.add(nthWeekField);
        nthWeekPanel.add(Box.createHorizontalStrut(5));
        nthWeekPanel.add(new JLabel("周的星期"));
        nthWeekPanel.add(Box.createHorizontalStrut(5));
        nthWeekPanel.add(nthWeekdayField);

        // 选项5：最后一个星期 - 左对齐并包含组件
        JPanel lastWeekdayPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        lastWeekdayPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        lastWeekdayPanel.add(lastWeekdayRadio);
        lastWeekdayPanel.add(Box.createHorizontalStrut(5));
        lastWeekdayPanel.add(lastWeekdayCombo);

        // 选项6：指定 - 复选框网格在右侧
        JPanel specifyPanel = new JPanel(new BorderLayout());
        specifyPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // 创建单选按钮面板
        JPanel specifyRadioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        specifyRadioPanel.add(specifyRadio);

        // 创建星期复选框网格
        JPanel checkboxPanel = createWeekCheckboxGrid();

        // 将单选按钮放在左侧（西），复选框放在中央
        specifyPanel.add(specifyRadioPanel, BorderLayout.WEST);
        specifyPanel.add(checkboxPanel, BorderLayout.CENTER);

        // 将所有组件添加到主内容面板，并设置适当的间距
        contentPanel.add(everyWeekRadio);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(noSpecifyRadio);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(rangePanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(nthWeekPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(lastWeekdayPanel);
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(specifyPanel);

        add(contentPanel, BorderLayout.NORTH);
    }

    private JPanel createWeekCheckboxGrid() {
        JPanel gridPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 10));

        // 创建1-7的复选框（代表周日到周六）
        for (int i = 0; i < 7; i++) {
            String text = String.format("%02d", i + 1);
            JCheckBox checkbox = new JCheckBox(text);
            checkbox.setHorizontalAlignment(SwingConstants.CENTER);
            checkbox.setEnabled(false); // 初始状态为禁用

            // 添加工具提示显示星期名称
            checkbox.setToolTipText(weekdayNames[i]);

            // 添加复选框变化监听器
            checkbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                }
            });

            weekCheckboxes[i] = checkbox;
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
        updateComponentStates();
    }

    private void updateComponentStates() {
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
    }
}
