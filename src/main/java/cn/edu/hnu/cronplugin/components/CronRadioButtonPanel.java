package cn.edu.hnu.cronplugin.components;

import cn.edu.hnu.cronplugin.cron.CronItemEnum;

import javax.swing.Box;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 单选框面板
 */
public class CronRadioButtonPanel extends AbstractPanelComponent {

    private JRadioButton radioButton;

    public CronRadioButtonPanel(String description) {
        // region 初始化内部组件
        radioButton = new JRadioButton(description);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(this.radioButton);
        add(Box.createHorizontalStrut(5));
        // endregion
    }

    @Override
    public void updateInnerComponentsAvailability() {

    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {

    }

    public JRadioButton getRadioButton() {
        return radioButton;
    }
}
