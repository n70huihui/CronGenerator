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
 * 范围选择面板
 */
public class CronRangeRadioPanel extends AbstractPanelComponent {
    // 单选框
    private JRadioButton rangeRadio;
    // 范围选项的组件
    private JTextField rangeFromField;
    private JTextField rangeToField;

    private JLabel rangeFromLabel;
    private JLabel rangeToLabel;

    public CronRangeRadioPanel(CronItemEnum cronItemEnum, String description,
                               String rangeFromField, String rangeFromLabel,
                               String rangeToField, String rangeToLabel,
                               int fromColumns, int toColumns, Project project) {
        // region 初始化内部组件
        this.project = project;
        this.cronItemEnum = cronItemEnum;
        this.rangeRadio = new JRadioButton(description);
        this.rangeFromField = new JTextField(rangeFromField, fromColumns);
        this.rangeFromField.setEnabled(false);
        this.rangeToField = new JTextField(rangeToField, toColumns);
        this.rangeToField.setEnabled(false);
        this.rangeFromLabel = new JLabel(rangeFromLabel);
        this.rangeToLabel = new JLabel(rangeToLabel);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(this.rangeRadio);
        add(Box.createHorizontalStrut(5));
        add(this.rangeFromField);
        add(Box.createHorizontalStrut(5));
        add(this.rangeFromLabel);
        add(Box.createHorizontalStrut(5));
        add(this.rangeToField);
        add(Box.createHorizontalStrut(5));
        add(this.rangeToLabel);
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion

    }

    @Override
    public void setupItemListener() {
        RadioUpdateItemListener radioUpdateItemListener = new RadioUpdateItemListener(cronItemEnum, this);
        this.rangeRadio.addItemListener(radioUpdateItemListener);
    }

    @Override
    public void setupDocumentListener() {
        TextFieldUpdateDocumentListener textFieldUpdateDocumentListener = new TextFieldUpdateDocumentListener(cronItemEnum, this);
        this.rangeFromField.getDocument().addDocumentListener(textFieldUpdateDocumentListener);
        this.rangeToField.getDocument().addDocumentListener(textFieldUpdateDocumentListener);
    }

    @Override
    public void setupActionListener() {

    }

    @Override
    public void updateInnerComponentsAvailability() {
        boolean selected = this.rangeRadio.isSelected();
        this.rangeFromField.setEnabled(selected);
        this.rangeToField.setEnabled(selected);
    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {
        if (this.rangeRadio.isSelected()) {
            CronExpressionUtil.setRange(cronItemEnum, this.rangeFromField.getText(), this.rangeToField.getText(), project);
            CronResultPanelUtil.updateCronExpression(project);
        }
    }

    public JRadioButton getRangeRadio() {
        return rangeRadio;
    }

    public JTextField getRangeFromField() {
        return rangeFromField;
    }

    public JTextField getRangeToField() {
        return rangeToField;
    }

    public JLabel getRangeFromLabel() {
        return rangeFromLabel;
    }

    public JLabel getRangeToLabel() {
        return rangeToLabel;
    }
}
