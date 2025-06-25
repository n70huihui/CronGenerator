package cn.edu.hnu.cronplugin.panels;

import javax.swing.JPanel;

public abstract class AbstractPanel extends JPanel {
    protected abstract void initializeComponents();
    protected abstract void setupLayout();
    protected abstract void setupEventHandlers();
    protected AbstractPanel() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
    }
}
