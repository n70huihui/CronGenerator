package cn.edu.hnu.cronplugin.panels;

import com.intellij.openapi.project.Project;

import javax.swing.JPanel;

/**
 * 面板抽象类
 */
public abstract class AbstractPanel extends JPanel {
    protected Project project;
    protected abstract void initializeComponents();
    protected abstract void setupLayout();
    protected abstract void setupEventHandlers();
    protected AbstractPanel(Project project) {
        this.project = project;
        initializeComponents();
        setupLayout();
        setupEventHandlers();
    }
}
