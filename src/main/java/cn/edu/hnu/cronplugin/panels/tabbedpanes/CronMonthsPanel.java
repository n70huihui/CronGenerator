package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronIntervalRadioPanel;
import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronRadioButtonPanel;
import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronSpecifyRadioPanel;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.ContentPanelUtil;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class CronMonthsPanel extends AbstractPanel {
    // 单选组件
    private ButtonGroup radioGroup;
    // 单选面板
    private CronRadioButtonPanel radioButtonPanel;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 间隔面板
    private CronIntervalRadioPanel intervalRadioPanel;
    // 不指定面板
    private CronRadioButtonPanel noSpecifyRadioPanel;
    // 复选框面板
    private CronSpecifyRadioPanel specifyRadioPanel;

    @Override
    protected void initializeComponents() {
        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每秒执行
        radioButtonPanel = new CronRadioButtonPanel(CronItemEnum.MONTH, "每秒 允许的通配符[,-*/]");
        radioButtonPanel.getRadioButton().setSelected(true);
        radioGroup.add(radioButtonPanel.getRadioButton());

        // 选项2：范围执行的单选按钮
        rangeRadioPanel = new CronRangeRadioPanel(CronItemEnum.MONTH, "周期从",
                "1", "月到",
                "2", "月",
                5, 5
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项3：间隔执行的单选按钮
        intervalRadioPanel = new CronIntervalRadioPanel(CronItemEnum.MONTH, "周期从",
                "1", "月开始, 每",
                "1", "月执行一次",
                5, 5
        );
        radioGroup.add(intervalRadioPanel.getIntervalRadio());

        // 选项4：不指定
        noSpecifyRadioPanel = new CronRadioButtonPanel(CronItemEnum.MONTH, "不指定");
        radioGroup.add(noSpecifyRadioPanel.getRadioButton());

        // 选项5：指定月的单选按钮
        specifyRadioPanel = new CronSpecifyRadioPanel(CronItemEnum.MONTH, "指定", 2, 6, 1);
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
                noSpecifyRadioPanel,
                specifyRadioPanel
        );

        add(contentPanel, BorderLayout.NORTH);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
