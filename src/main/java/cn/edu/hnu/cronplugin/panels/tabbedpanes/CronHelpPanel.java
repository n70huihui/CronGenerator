package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.util.ui.JBUI;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

/**
 * 帮助页
 */
public class CronHelpPanel extends AbstractPanel {
    private JLabel helpContentLabel;
    private JScrollPane scrollPane;

    public CronHelpPanel() {
        initializeComponents();
        setupLayout();
        loadHelpContent();
    }

    @Override
    protected void initializeComponents() {
        // 设置面板背景色
        setBorder(JBUI.Borders.empty(20));

        // 创建帮助内容显示区域
        helpContentLabel = new JLabel();
        helpContentLabel.setVerticalAlignment(SwingConstants.TOP);

        // 创建滚动面板
        scrollPane = new JBScrollPane(helpContentLabel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    protected void setupLayout() {
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    protected void setupEventHandlers() {

    }

    private void loadHelpContent() {
        String helpContent = generateHelpContent();
        helpContentLabel.setText(helpContent);
    }

    private String generateHelpContent() {
        StringBuilder content = new StringBuilder();
        return content.toString();
    }
}