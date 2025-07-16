package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronLastWeekPanel;
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

public class CronWeeksPanel extends AbstractPanel {
    // 单选组件
    private ButtonGroup radioGroup;
    // 单选面板
    private CronRadioButtonPanel radioButtonPanel;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 间隔面板
    private CronIntervalRadioPanel intervalRadioPanel;
    // 本月最后一个星期
    private CronLastWeekPanel lastWeekDayPanel;
    // 不指定
    private CronRadioButtonPanel noSpecifyRadioPanel;
    // 复选框面板
    private CronSpecifyRadioPanel specifyRadioPanel;

    public CronWeeksPanel(Project project) {
        super(project);
    }

    @Override
    protected void initializeComponents() {
        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每秒执行
        radioButtonPanel = new CronRadioButtonPanel(CronItemEnum.WEEK, "每周 允许的通配符[,-*/L#]", project);
        radioGroup.add(radioButtonPanel.getRadioButton());

        // 选项2：范围执行的单选按钮
        rangeRadioPanel = new CronRangeRadioPanel(CronItemEnum.WEEK, "周期从第",
                "1", "周到第",
                "2", "周",
                5, 5, project
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项3：间隔执行的单选按钮
        intervalRadioPanel = new CronIntervalRadioPanel(CronItemEnum.WEEK, "第",
                "1", "周的星期",
                "1", "",
                5, 5, project
        );
        radioGroup.add(intervalRadioPanel.getIntervalRadio());

        // 选项4：本月最后一个星期
        lastWeekDayPanel = new CronLastWeekPanel(CronItemEnum.WEEK, "本月最后一个星期", project);
        radioGroup.add(lastWeekDayPanel.getLastWeekdayRadio());

        // 选项5：不指定
        noSpecifyRadioPanel = new CronRadioButtonPanel(CronItemEnum.WEEK, "不指定", project);
        noSpecifyRadioPanel.getRadioButton().setSelected(true);
        radioGroup.add(noSpecifyRadioPanel.getRadioButton());

        // 选项6：指定
        specifyRadioPanel = new CronSpecifyRadioPanel(CronItemEnum.WEEK, "指定", 1, 7, 1, project);
        radioGroup.add(specifyRadioPanel.getSpecifyRadio());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());

        // 创建主内容面板
        JPanel contentPanel = ContentPanelUtil.assembledContentPanel(
                radioButtonPanel,
                rangeRadioPanel,
                intervalRadioPanel,
                lastWeekDayPanel,
                noSpecifyRadioPanel,
                specifyRadioPanel
        );

        add(contentPanel, BorderLayout.NORTH);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
