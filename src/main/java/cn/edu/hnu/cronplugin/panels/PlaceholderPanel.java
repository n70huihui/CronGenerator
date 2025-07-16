package cn.edu.hnu.cronplugin.panels;

import com.intellij.openapi.project.Project;

import javax.swing.JLabel;

/**
 * 占位面板
 */
public class PlaceholderPanel extends AbstractPanel {

    private JLabel label;

    public PlaceholderPanel(Project project) {
        super(project);
    }

    @Override
    protected void initializeComponents() {
        label = new JLabel("功能待实现");
    }

    @Override
    protected void setupLayout() {
        add(label);
    }

    @Override
    protected void setupEventHandlers() {

    }
}
