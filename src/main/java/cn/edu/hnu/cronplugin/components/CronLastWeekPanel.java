package cn.edu.hnu.cronplugin.components;

import com.intellij.openapi.ui.ComboBox;

import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 最后一个星期N面板
 */
public class CronLastWeekPanel extends JPanel {

    private JRadioButton lastWeekdayRadio;

    private ComboBox<String> lastWeekdayCombo;

    private String[] weekdayNames;

    public CronLastWeekPanel(String description) {
        // region 初始化组件
        this.weekdayNames = new String[]{"日", "一", "二", "三", "四", "五", "六"};
        this.lastWeekdayRadio = new JRadioButton(description);
        this.lastWeekdayCombo = new ComboBox<>(this.weekdayNames);
        this.lastWeekdayCombo.setSelectedIndex(0);  // 默认选择周日
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(lastWeekdayRadio);
        add(Box.createHorizontalStrut(5));
        add(lastWeekdayCombo);
        // endregion
    }

    public JRadioButton getLastWeekdayRadio() {
        return lastWeekdayRadio;
    }

    public ComboBox<String> getLastWeekdayCombo() {
        return lastWeekdayCombo;
    }
}
