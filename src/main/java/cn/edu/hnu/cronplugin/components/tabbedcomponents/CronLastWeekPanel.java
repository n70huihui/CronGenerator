package cn.edu.hnu.cronplugin.components.tabbedcomponents;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.listeners.ComboUpdateActionListener;
import cn.edu.hnu.cronplugin.listeners.RadioUpdateItemListener;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;
import com.intellij.openapi.ui.ComboBox;

import javax.swing.Box;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 最后一个星期N面板
 */
public class CronLastWeekPanel extends AbstractPanelComponent {

    private JRadioButton lastWeekdayRadio;

    private ComboBox<String> lastWeekdayCombo;

    private String[] weekdayNames;

    public CronLastWeekPanel(CronItemEnum cronItemEnum, String description) {
        // region 初始化组件
        this.cronItemEnum = cronItemEnum;
        this.weekdayNames = new String[]{"日", "一", "二", "三", "四", "五", "六"};
        this.lastWeekdayRadio = new JRadioButton(description);
        this.lastWeekdayCombo = new ComboBox<>(this.weekdayNames);
        this.lastWeekdayCombo.setSelectedIndex(0);  // 默认选择周日
        this.lastWeekdayCombo.setEnabled(false);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(lastWeekdayRadio);
        add(Box.createHorizontalStrut(5));
        add(lastWeekdayCombo);
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    @Override
    public void setupItemListener() {
        RadioUpdateItemListener radioUpdateItemListener = new RadioUpdateItemListener(cronItemEnum, this);
        this.lastWeekdayRadio.addItemListener(radioUpdateItemListener);
    }

    @Override
    public void setupDocumentListener() {

    }

    @Override
    public void setupActionListener() {
        ComboUpdateActionListener comboUpdateActionListener = new ComboUpdateActionListener(cronItemEnum, this);
        this.lastWeekdayCombo.addActionListener(comboUpdateActionListener);
    }

    @Override
    public void updateInnerComponentsAvailability() {
        this.lastWeekdayCombo.setEnabled(this.lastWeekdayRadio.isSelected());
    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {
        if (this.lastWeekdayRadio.isSelected()) {
            int index = this.lastWeekdayCombo.getSelectedIndex();
            CronExpressionUtil.setLastWeekOfMonth(String.valueOf(index + 1));
            CronResultPanelUtil.updateCronExpression();
        }
    }

    public JRadioButton getLastWeekdayRadio() {
        return lastWeekdayRadio;
    }

    public ComboBox<String> getLastWeekdayCombo() {
        return lastWeekdayCombo;
    }
}
