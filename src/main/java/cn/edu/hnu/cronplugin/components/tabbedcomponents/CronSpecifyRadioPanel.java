package cn.edu.hnu.cronplugin.components.tabbedcomponents;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.listeners.RadioUpdateItemListener;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

/**
 * 复选框指定面板
 */
public class CronSpecifyRadioPanel extends AbstractPanelComponent {
    private JRadioButton specifyRadio;
    // 统一用二维的
    private JCheckBox[][] checkboxes;

    // 面板
    private JPanel specifyRadioPanel;
    private JPanel checkboxPanel;

    /**
     * 简单构造方法，用于 checkboxes 的行和列与实际展示的行和列相同的场景，且文本为两位数数字
     * @param description 单选描述
     * @param rows 行
     * @param cols 列
     * @param offset 显示数字的偏移量
     */
    public CronSpecifyRadioPanel(CronItemEnum cronItemEnum, String description, int rows, int cols, int offset) {
        // region 初始化组件
        this.cronItemEnum = cronItemEnum;
        this.specifyRadio = new JRadioButton(description);
        this.checkboxes = new JCheckBox[rows][cols];
        this.specifyRadioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.specifyRadioPanel.add(specifyRadio);
        this.checkboxPanel = createCheckboxGrid(rows, cols, offset);
        // endregion

        // region 设置布局
        setLayout(new BorderLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(specifyRadioPanel, BorderLayout.WEST);
        add(checkboxPanel, BorderLayout.CENTER);
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    /**
     * 构造方法，用于 checkboxes 的行和列与实际展示的行和列不同的场景，且文本为两位数数字
     * @param description 单选描述
     * @param rows 行
     * @param cols 列
     * @param offset 显示数字的偏移量
     * @param displayRows 实际展示的行数
     * @param displayCols 实际展示的列数
     */
    public CronSpecifyRadioPanel(CronItemEnum cronItemEnum, String description,
                                 int rows, int cols, int offset,
                                 int displayRows, int displayCols) {
        // region 初始化组件
        this.cronItemEnum = cronItemEnum;
        this.specifyRadio = new JRadioButton(description);
        this.checkboxes = new JCheckBox[rows][cols];
        this.specifyRadioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.specifyRadioPanel.add(specifyRadio);
        this.checkboxPanel = createCheckboxGrid(rows, cols, offset, displayRows, displayCols);
        // endregion

        // region 设置布局
        setLayout(new BorderLayout());
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(specifyRadioPanel, BorderLayout.WEST);
        add(checkboxPanel, BorderLayout.CENTER);
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    private JPanel createCheckboxGrid(int rows, int cols, int offset) {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(rows, cols, 3, 3));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 10));

        // 创建复选框网格
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int value = row * cols + col + offset;
                String text = String.format("%02d", value);
                JCheckBox checkbox = new JCheckBox(text);
                checkbox.setHorizontalAlignment(SwingConstants.CENTER);
                checkbox.setEnabled(false); // 初始状态为禁用

                checkboxes[row][col] = checkbox;
                gridPanel.add(checkbox);
            }
        }

        return gridPanel;
    }

    private JPanel createCheckboxGrid(int rows, int cols, int offset,
                                      int displayRows, int displayCols) {
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(displayRows, displayCols, 3, 3));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 10, 10));

        // 创建复选框网格
        for (int row = 0; row < rows; ++row) {
            for (int col = 0; col < cols; ++col) {
                int value = row * cols + col + offset;
                String text = String.format("%02d", value);
                JCheckBox checkbox = new JCheckBox(text);
                checkbox.setHorizontalAlignment(SwingConstants.CENTER);
                checkbox.setEnabled(false); // 初始状态为禁用

                checkboxes[row][col] = checkbox;
                gridPanel.add(checkbox);
            }
        }

        return gridPanel;
    }

    @Override
    public void setupItemListener() {
        RadioUpdateItemListener radioUpdateItemListener = new RadioUpdateItemListener(cronItemEnum, this);
        this.specifyRadio.addItemListener(radioUpdateItemListener);
        for (JCheckBox[] jCheckBoxes : this.checkboxes) {
            for (JCheckBox checkbox : jCheckBoxes) {
                checkbox.addItemListener(radioUpdateItemListener);
            }
        }
    }

    @Override
    public void setupDocumentListener() {

    }

    @Override
    public void setupActionListener() {

    }

    @Override
    public void updateInnerComponentsAvailability() {
        boolean selected = this.specifyRadio.isSelected();
        for (JCheckBox[] jCheckBoxes : this.checkboxes) {
            for (JCheckBox checkbox : jCheckBoxes) {
                checkbox.setEnabled(selected);
            }
        }
    }

    public JRadioButton getSpecifyRadio() {
        return specifyRadio;
    }

    public JCheckBox[][] getCheckboxes() {
        return checkboxes;
    }

    /**
     * 获取选中的多选框内容
     * @return
     */
    private List<String> getSelectedCheckBoxes() {
        List<String> selectedCheckboxes = new ArrayList<>();
        for (JCheckBox[] jCheckBoxes : this.checkboxes) {
            for (JCheckBox checkbox : jCheckBoxes) {
                if (checkbox.isSelected()) {
                    selectedCheckboxes.add(checkbox.getText());
                }
            }
        }
        return selectedCheckboxes;
    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {
        if (this.specifyRadio.isSelected()) {
            List<String> selectedCheckboxes = getSelectedCheckBoxes();
            CronExpressionUtil.setSpecify(cronItemEnum, selectedCheckboxes);
            CronResultPanelUtil.updateCronExpression();
        }
    }
}
