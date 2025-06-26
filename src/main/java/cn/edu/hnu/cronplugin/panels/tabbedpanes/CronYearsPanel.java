package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.CronRadioButtonPanel;
import cn.edu.hnu.cronplugin.components.CronRangeRadioPanel;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.ContentPanelUtil;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class CronYearsPanel extends AbstractPanel {

    // 单选组件
    private ButtonGroup radioGroup;
    // 单选面板
    private CronRadioButtonPanel radioButtonPanel;
    // 不指定
    private CronRadioButtonPanel noSpecifyRadioPanel;
    // 范围面板
    private CronRangeRadioPanel rangeRadioPanel;
    // 不使用
    private CronRadioButtonPanel unUsedRadioPanel;

    @Override
    protected void initializeComponents() {
        // 创建单选按钮组
        radioGroup = new ButtonGroup();

        // 选项1：每秒执行
        radioButtonPanel = new CronRadioButtonPanel(CronItemEnum.YEAR, "每年 允许的通配符[,-*/]");
        radioButtonPanel.getRadioButton().setSelected(true);
        radioGroup.add(radioButtonPanel.getRadioButton());

        // 选项2：不指定
        noSpecifyRadioPanel = new CronRadioButtonPanel(CronItemEnum.YEAR, "不指定");
        radioGroup.add(noSpecifyRadioPanel.getRadioButton());

        // 选项3：周期执行
        rangeRadioPanel = new CronRangeRadioPanel(CronItemEnum.YEAR, "周期从",
                "2025", "年到",
                "9999", "年",
                5, 5
        );
        radioGroup.add(rangeRadioPanel.getRangeRadio());

        // 选项4：不使用
        unUsedRadioPanel = new CronRadioButtonPanel(CronItemEnum.YEAR, "不使用");
        radioGroup.add(unUsedRadioPanel.getRadioButton());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());
        // 创建主内容面板
        JPanel contentPanel = ContentPanelUtil.assembledContentPanel(
                radioButtonPanel,
                noSpecifyRadioPanel,
                rangeRadioPanel,
                unUsedRadioPanel
        );
        add(contentPanel, BorderLayout.NORTH);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
