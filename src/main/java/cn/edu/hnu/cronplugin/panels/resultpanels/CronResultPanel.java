package cn.edu.hnu.cronplugin.panels.resultpanels;

import cn.edu.hnu.cronplugin.components.resultcomponents.CronExpressionPanel;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.utils.ContentPanelUtil;
import com.intellij.ui.JBColor;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;

/**
 * Cron 表达式结果
 */
public class CronResultPanel extends AbstractPanel {
    // TODO private CronResultTablePanel cronResultTablePanel;
    private CronExpressionPanel cronExpressionPanel;

    /**
     * 设置 Cron 表达式
     * @param cronExpression Cron 表达式
     */
    public void setCronExpression(String cronExpression) {
        cronExpressionPanel.setCronExpressionField(cronExpression);
    }

    @Override
    protected void initializeComponents() {
        // cronResultTablePanel = new CronResultTablePanel();
        cronExpressionPanel = new CronExpressionPanel();
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());
        // 将所有组件添加到主内容面板，并设置适当的间距
        JPanel contentPanel = ContentPanelUtil.assembledContentPanel(
                // cronResultTablePanel,
                cronExpressionPanel
        );
        // 设置标题
        MatteBorder topBorder = new MatteBorder(1, 0, 0, 0, JBColor.LIGHT_GRAY);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                topBorder,
                "Cron 表达式",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        contentPanel.setBorder(titledBorder);
        add(contentPanel, BorderLayout.NORTH);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
