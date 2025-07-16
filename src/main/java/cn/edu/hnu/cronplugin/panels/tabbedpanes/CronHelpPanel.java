package cn.edu.hnu.cronplugin.panels.tabbedpanes;

import cn.edu.hnu.cronplugin.components.tabbedcomponents.CronHelpSectionPanel;
import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import com.intellij.openapi.project.Project;
import com.intellij.ui.TitledSeparator;
import com.intellij.ui.components.JBScrollPane;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 * 帮助页
 */
public class CronHelpPanel extends AbstractPanel {
    private JPanel helpContentPanel;
    private JScrollPane scrollPane;

    public CronHelpPanel(Project project) {
        super(project);
    }

    @Override
    protected void initializeComponents() {
        helpContentPanel = createHelpContentPanel();

        // 创建滚动面板
        scrollPane = new JBScrollPane(helpContentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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

    private JPanel createHelpContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Section 1
        CronHelpSectionPanel section1 = new CronHelpSectionPanel(
                "Cron 表达式介绍",
                "<html>Cron 表达式是一种用于精确指定定时任务执行时间的字符串表示形式，在任务调度系统中广泛应用。<br>" +
                        "它通过特定规则组合不同时间字段，实现灵活的定时设置。<br>" +
                        "其由 6 个必需字段和 1 个可选字段组成，各字段依次表示秒、分钟、小时、日、月、星期、年。<br>" +
                        "</html>"
        );
        contentPanel.add(section1);
        contentPanel.add(Box.createVerticalStrut(15));

        // Section 2
        CronHelpSectionPanel section2 = new CronHelpSectionPanel(
                "支持的通配符",
                "<html>" +
                        "除了基本的数字范围外，Cron 表达式还支持一些特殊符号和字符：<br>" +
                        "<ul>" +
                        "<li>星号（*）：表示匹配任意值。例如，* 在分钟字段中表示每分钟都执行。</li>" +
                        "<li>逗号（,）：用于分隔多个值。例如，1,3,5 在小时字段中表示 1 点、3 点和 5 点执行。</li>" +
                        "<li>斜线（/）：用于指定间隔值。例如，*/5 在分钟字段中表示每 5 分钟执行一次。</li>" +
                        "<li>连字符（-）：用于指定范围。例如，10-20 在日期字段中表示从 10 号到 20 号。</li>" +
                        "<li>问号（?）：仅用于日期和星期几字段，表示不指定具体值。通常用于避免冲突。</li>" +
                        "<li>字母（L）：表示最后一个值。例如，L 在日字段中表示月末最后一天。</li>" +
                        "<li>字母（W）：表示最接近某日的工作日。例如，15W 表示离每月15日最近的工作日。</li>" +
                        "</ul>" +
                        "</html>"
        );
        contentPanel.add(section2);
        contentPanel.add(Box.createVerticalStrut(15));

        // Section 3
        CronHelpSectionPanel section3 = new CronHelpSectionPanel(
                "注意事项",
                "<html>Cron 表达式非常灵活，可以满足各种定时任务的需求。<br>" +
                        "但需要注意的是，Cron 表达式只能表示固定的时间点，无法处理复杂的时间逻辑。<br>" +
                        "如果需要更复杂的定时任务调度，可能需要借助专门的调度框架或库。</html>"
        );
        contentPanel.add(section3);
        contentPanel.add(Box.createVerticalStrut(15));
        return contentPanel;
    }
}