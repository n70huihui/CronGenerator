package cn.edu.hnu.cronplugin.utils;

import cn.edu.hnu.cronplugin.panels.resultpanels.CronResultPanel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 表达式结果工具类
 */
public class CronResultPanelUtil {

    private CronResultPanelUtil() {}

    private static final Map<Project, CronResultPanel> PANEL_MAP = new ConcurrentHashMap<>();

    public static void initPanel(Project project) {
        PANEL_MAP.put(project, new CronResultPanel(project));
    }

    public static CronResultPanel getCronResultPanel(Project project) {
        return PANEL_MAP.get(project);
    }

    public static void updateCronExpression(Project project) {
        // 更新面板显示的表达式
        getCronResultPanel(project).setCronExpression(CronExpressionUtil.getCronExpression(project));
        // 更新执行时间
        getCronResultPanel(project).setExecutionTime(CronExpressionUtil.getNext5Executions(project));
    }

    public static void setCronExpression(String cronExpression, Project project) {
        getCronResultPanel(project).setCronExpression(cronExpression);
    }

}
