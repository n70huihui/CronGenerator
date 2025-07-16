package cn.edu.hnu.cronplugin.components.tabbedcomponents;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.listeners.RadioUpdateItemListener;
import cn.edu.hnu.cronplugin.listeners.TextFieldUpdateDocumentListener;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;
import com.intellij.openapi.project.Project;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 间隔选择面板
 */
public class CronIntervalRadioPanel extends AbstractPanelComponent {
    // 单选框
    private JRadioButton intervalRadio;
    // 间隔选项的组件
    private JTextField intervalFromField;
    private JTextField intervalToField;

    private JLabel intervalFromLabel;
    private JLabel intervalToLabel;

    public CronIntervalRadioPanel(CronItemEnum cronItemEnum, String description,
                                  String intervalFromField, String intervalFromLabel,
                                  String intervalToField, String intervalToLabel,
                                  int fromColumns, int toColumns, Project project) {
        // region 初始化内部组件
        this.project = project;
        this.cronItemEnum = cronItemEnum;
        this.intervalRadio = new JRadioButton(description);
        this.intervalFromField = new JTextField(intervalFromField, fromColumns);
        this.intervalFromField.setEnabled(false);
        this.intervalToField = new JTextField(intervalToField, toColumns);
        this.intervalToField.setEnabled(false);
        this.intervalFromLabel = new JLabel(intervalFromLabel);
        this.intervalToLabel = new JLabel(intervalToLabel);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(this.intervalRadio);
        add(Box.createHorizontalStrut(5));
        add(this.intervalFromField);
        add(Box.createHorizontalStrut(5));
        add(this.intervalFromLabel);
        add(Box.createHorizontalStrut(5));
        add(this.intervalToField);
        add(Box.createHorizontalStrut(5));
        add(this.intervalToLabel);
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    @Override
    public void setupItemListener() {
        RadioUpdateItemListener radioUpdateItemListener = new RadioUpdateItemListener(cronItemEnum, this);
        this.intervalRadio.addItemListener(radioUpdateItemListener);
    }

    @Override
    public void setupDocumentListener() {
        TextFieldUpdateDocumentListener textFieldUpdateDocumentListener = new TextFieldUpdateDocumentListener(cronItemEnum, this);
        this.intervalFromField.getDocument().addDocumentListener(textFieldUpdateDocumentListener);
        this.intervalToField.getDocument().addDocumentListener(textFieldUpdateDocumentListener);
    }

    @Override
    public void setupActionListener() {

    }

    @Override
    public void updateInnerComponentsAvailability() {
        boolean selected = intervalRadio.isSelected();
        this.intervalFromField.setEnabled(selected);
        this.intervalToField.setEnabled(selected);
    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {
        if (intervalRadio.isSelected()) {
            CronExpressionUtil.setInterval(cronItemEnum, this.intervalFromField.getText(), this.intervalToField.getText(), project);
            CronResultPanelUtil.updateCronExpression(project);
        }
    }

    public JRadioButton getIntervalRadio() {
        return intervalRadio;
    }

    public JTextField getIntervalFromField() {
        return intervalFromField;
    }

    public JTextField getIntervalToField() {
        return intervalToField;
    }

    public JLabel getIntervalFromLabel() {
        return intervalFromLabel;
    }

    public JLabel getIntervalToLabel() {
        return intervalToLabel;
    }
}
