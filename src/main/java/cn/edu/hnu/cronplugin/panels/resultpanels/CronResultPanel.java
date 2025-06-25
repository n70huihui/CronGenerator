package cn.edu.hnu.cronplugin.panels.resultpanels;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import com.intellij.ui.JBColor;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

/**
 * Cron 表达式结果
 */
public class CronResultPanel extends AbstractPanel {
    // TODO 创建表达式表格
    private CronExpressionPanel cronExpressionPanel;

    @Override
    protected void initializeComponents() {
        cronExpressionPanel = new CronExpressionPanel();
    }

    @Override
    protected void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(cronExpressionPanel);

        MatteBorder topBorder = new MatteBorder(1, 0, 0, 0, JBColor.LIGHT_GRAY);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                topBorder,
                "Cron 表达式",
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        setBorder(titledBorder);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
