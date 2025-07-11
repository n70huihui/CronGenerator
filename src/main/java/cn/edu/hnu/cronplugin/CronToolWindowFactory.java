package cn.edu.hnu.cronplugin;

import cn.edu.hnu.cronplugin.panels.CronMainBuilderPanel;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import org.jetbrains.annotations.NotNull;

public class CronToolWindowFactory implements ToolWindowFactory, DumbAware {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        CronMainBuilderPanel cronMainBuilderPanel = new CronMainBuilderPanel();
        Content content = ContentFactory.getInstance().createContent(cronMainBuilderPanel, "", false);
        toolWindow.getContentManager().addContent(content);
    }
}
