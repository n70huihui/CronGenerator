package cn.edu.hnu.cronplugin;

import cn.edu.hnu.cronplugin.panels.CronMainBuilderPanel;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import cn.edu.hnu.cronplugin.utils.CronResultPanelUtil;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.project.ProjectUtil;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class CronToolWindowFactory implements ToolWindowFactory, DumbAware {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // 初始化项目和面板的关联关系
        CronExpressionUtil.initExpression(project);
        CronResultPanelUtil.initPanel(project);

        CronMainBuilderPanel cronMainBuilderPanel = new CronMainBuilderPanel(project);
        Content content = ContentFactory.getInstance().createContent(cronMainBuilderPanel, "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
