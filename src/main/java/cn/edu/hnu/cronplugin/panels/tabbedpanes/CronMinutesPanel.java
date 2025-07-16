package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronRadioButtonPanel;
import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronSpecifyRadioPanel;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.ContentPanelUtil;
import com.intellij.openapi.project.Project;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class CronMinutesPanel extends AbstractPanel {
    // 单选组件
    private ButtonGroup radioGroup;
    // 单选面板
    private CronRadioButtonPanel radioButtonPanel;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 间隔面板
    private CronIntervalRadioPanel intervalRadioPanel;
    // 复选框面板
    private CronSpecifyRadioPanel specifyRadioPanel;

    public CronMinutesPanel(Project project) {
        super(project);
    }

    @Override
    protected void initializeComponents() {

        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每秒执行
        radioButtonPanel = new CronRadioButtonPanel(CronItemEnum.MINUTE, "每分钟 允许的通配符[,-*/]", project);
        radioButtonPanel.getRadioButton().setSelected(true);
        radioGroup.add(radioButtonPanel.getRadioButton());

        // 选项2：范围执行的单选按钮
        rangeRadioPanel = new CronRangeRadioPanel(CronItemEnum.MINUTE, "周期从",
                "1", "分钟到",
                "2", "分钟",
                5, 5, project
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项3：间隔执行的单选按钮
        intervalRadioPanel = new CronIntervalRadioPanel(CronItemEnum.MINUTE, "周期从",
                "0", "分钟开始, 每",
                "1", "分钟执行一次",
                5, 5, project
        );
        radioGroup.add(intervalRadioPanel.getIntervalRadio());

        // 选项4：指定分钟的单选按钮
        specifyRadioPanel = new CronSpecifyRadioPanel(CronItemEnum.MINUTE, "指定", 6, 10, 0, project);
        radioGroup.add(specifyRadioPanel.getSpecifyRadio());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());
        // 将所有组件添加到主内容面板，并设置适当的间距
        JPanel contentPanel = ContentPanelUtil.assembledContentPanel(
                radioButtonPanel,
                rangeRadioPanel,
                intervalRadioPanel,
                specifyRadioPanel
        );
        // 这里需要添加一个 contentPanel 并且放在 NORTH 位置，这样组件显示紧凑一些，好看点~
        add(contentPanel, BorderLayout.NORTH);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
