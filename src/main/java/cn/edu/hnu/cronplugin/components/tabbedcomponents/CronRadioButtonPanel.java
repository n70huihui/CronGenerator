package cn.edu.hnu.cronplugin.components.tabbedcomponents;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.listeners.RadioUpdateItemListener;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;
import com.intellij.openapi.project.Project;

import javax.swing.Box;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * 单选框面板
 */
public class CronRadioButtonPanel extends AbstractPanelComponent {

    private JRadioButton radioButton;

    public CronRadioButtonPanel(CronItemEnum cronItemEnum, String description, Project project) {
        // region 初始化内部组件
        this.project = project;
        this.cronItemEnum = cronItemEnum;
        this.radioButton = new JRadioButton(description);
        // endregion

        // region 设置布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        add(this.radioButton);
        add(Box.createHorizontalStrut(5));
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    @Override
    public void setupItemListener() {
        RadioUpdateItemListener radioUpdateItemListener = new RadioUpdateItemListener(cronItemEnum, this);
        this.radioButton.addItemListener(radioUpdateItemListener);
    }

    @Override
    public void setupDocumentListener() {

    }

    @Override
    public void setupActionListener() {

    }

    @Override
    public void updateInnerComponentsAvailability() {

    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {
        if (this.radioButton.isSelected()) {
            String text = this.radioButton.getText();
            if (text.startsWith("每")) {
                CronExpressionUtil.setEvery(cronItemEnum, project);
            } else if ("本月最后一天".equals(text)) {
                CronExpressionUtil.setLastDayOfMonth(project);
            } else if ("本月最后一个工作日".equals(text)) {
                CronExpressionUtil.setLastWeekdayOfMonth(project);
            } else if ("不指定".equals(text)) {
                CronExpressionUtil.setNoSpecify(cronItemEnum, project);
            } else if ("不使用".equals(text)) {
                CronExpressionUtil.setUnUsed(cronItemEnum, project);
            }
            CronResultPanelUtil.updateCronExpression(project);
        }
    }

    public JRadioButton getRadioButton() {
        return radioButton;
    }
}
