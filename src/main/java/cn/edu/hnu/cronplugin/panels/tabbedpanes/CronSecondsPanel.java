package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.CronRadioButton;
import cn.edu.hnu.cronplugin.components.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.components.CronSpecifyRadioPanel;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.CheckBoxUtil;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;
import org.apache.commons.lang3.StringUtils;

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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

/**
 * 秒标签
 */
public class CronSecondsPanel extends AbstractPanel {

    // 单选组件
    private ButtonGroup radioGroup;
    // 单选按钮
    private CronRadioButton everySecondRadioButton;
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
        everySecondRadioButton = new CronRadioButton("每秒 允许的通配符[,-*/]");
        everySecondRadioButton.setSelected(true);
        radioGroup.add(everySecondRadioButton);

        // 选项2：范围执行的单选按钮
        rangeRadioPanel = new CronRangeRadioPanel("周期从",
                "1", "秒到",
                "2", "秒",
                5, 5
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项3：间隔执行的单选按钮
        intervalRadioPanel = new CronIntervalRadioPanel("周期从",
                "0", "秒开始, 每",
                "1", "秒执行一次",
                5, 5
        );
        radioGroup.add(intervalRadioPanel.getIntervalRadio());

        // 选项4：指定秒数的单选按钮
        specifyRadioPanel = new CronSpecifyRadioPanel("指定", 6, 10, 0);
        radioGroup.add(specifyRadioPanel.getSpecifyRadio());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // 将所有组件添加到主内容面板，并设置适当的间距
        add(everySecondRadioButton);
        add(Box.createVerticalStrut(15));
        add(rangeRadioPanel);
        add(Box.createVerticalStrut(15));
        add(intervalRadioPanel);
        add(Box.createVerticalStrut(15));
        add(specifyRadioPanel);
    }

    @Override
    protected void setupEventHandlers() {

        /*ActionListener updateActionListener = e -> {
            updateComponentStates();
            updateSeconds();
        };

        DocumentListener updateDocumentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateComponentStates();
                updateSeconds();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateComponentStates();
                updateSeconds();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };

        // 根据单选按钮选择启用/禁用组件
        everySecondRadio.addActionListener(updateActionListener);
        rangeRadio.addActionListener(updateActionListener);
        intervalRadio.addActionListener(updateActionListener);
        specifyRadio.addActionListener(updateActionListener);

        // 为输入框添加变化监听器
        rangeFromField.getDocument().addDocumentListener(updateDocumentListener);
        rangeToField.getDocument().addDocumentListener(updateDocumentListener);
        intervalStartField.getDocument().addDocumentListener(updateDocumentListener);
        intervalStepField.getDocument().addDocumentListener(updateDocumentListener);

        // 为复选框添加变化监听器
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 10; col++) {
                if (secondCheckboxes[row][col] != null) {
                    secondCheckboxes[row][col].addActionListener(updateActionListener);
                }
            }
        }

        // 设置初始状态
        updateComponentStates();*/
    }

/*    private void updateComponentStates() {
        // 启用/禁用范围输入框
        rangeFromField.setEnabled(rangeRadio.isSelected());
        rangeToField.setEnabled(rangeRadio.isSelected());

        // 启用/禁用间隔输入框
        intervalStartField.setEnabled(intervalRadio.isSelected());
        intervalStepField.setEnabled(intervalRadio.isSelected());

        // 启用/禁用复选框
        boolean checkboxesEnabled = specifyRadio.isSelected();
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 10; col++) {
                if (secondCheckboxes[row][col] != null) {
                    secondCheckboxes[row][col].setEnabled(checkboxesEnabled);
                }
            }
        }
    }

    private void updateSeconds() {
        if (everySecondRadio.isSelected()) {
            // 每秒执行
            CronExpressionUtil.setEvery(CronItemEnum.SECOND);
        } else if (rangeRadio.isSelected()) {
            // 范围执行
            CronExpressionUtil.setRange(CronItemEnum.SECOND, rangeFromField.getText(), rangeToField.getText());
        } else if (intervalRadio.isSelected()) {
            // 间隔执行
            CronExpressionUtil.setInterval(CronItemEnum.SECOND, intervalStartField.getText(), intervalStepField.getText());
        } else if (specifyRadio.isSelected()) {
            // 指定秒数
            CronExpressionUtil.setSpecify(CronItemEnum.SECOND, CheckBoxUtil.getSelectedCheckBoxes(secondCheckboxes));
        }
        CronResultPanelUtil.updateCronExpression();
    }*/
}
