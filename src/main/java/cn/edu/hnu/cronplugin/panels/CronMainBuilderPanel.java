package cn.edu.hnu.cronplugin.panels;

import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;
import cn.edu.hnu.cronplugin.utils.TabbedPaneUtil;
import com.intellij.openapi.project.Project;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.components.JBTabbedPane;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;

/**
 * 面板创建入口
 */
public class CronMainBuilderPanel extends AbstractPanel {
    private JTabbedPane tabbedPane;
    private JBScrollPane resultScrollPane;

    public CronMainBuilderPanel(Project project) {
        super(project);
    }

    @Override
    protected void initializeComponents() {
        tabbedPane = new JBTabbedPane();

        // 添加标签页
        String[] tabNames = {"秒", "分钟", "小时", "日", "月", "周", "年", "帮助"};
        for (String tabName : tabNames) {
            AbstractPanel subPanel = TabbedPaneUtil.getSubPanels(tabName, project);
            // 设置滚动面板
            JBScrollPane scrollPane = new JBScrollPane(subPanel);
            // 使用空边框
            scrollPane.setBorder(BorderFactory.createEmptyBorder());
            tabbedPane.addTab(tabName, scrollPane);
        }

        // 设置第一个标签页为选中状态
        tabbedPane.setSelectedIndex(0);

        resultScrollPane = new JBScrollPane(CronResultPanelUtil.getCronResultPanel(project));
        resultScrollPane.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void setupLayout() {
        setLayout(new GridLayout(2, 1));

        add(tabbedPane);
        add(resultScrollPane);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
