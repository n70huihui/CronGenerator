package cn.edu.hnu.cronplugin.components;

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
public class CronSpecifyRadioPanel extends JPanel {
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
    public CronSpecifyRadioPanel(String description, int rows, int cols, int offset) {
        // region 初始化组件
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
    public CronSpecifyRadioPanel(String description,
                                 int rows, int cols, int offset,
                                 int displayRows, int displayCols) {
        // region 初始化组件
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
    public List<String> getSelectedCheckBoxes() {
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
}
