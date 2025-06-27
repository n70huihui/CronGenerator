package cn.edu.hnu.cronplugin.components.resultcomponents;

import com.intellij.ui.JBColor;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

/**
 * 执行时间面板
 */
public class CronExecutionTimePanel extends JPanel {

    private JLabel[] timeLabels;

    public CronExecutionTimePanel() {
        // region 初始化组件
        timeLabels = new JLabel[5];
        for (int i = 0; i < timeLabels.length; ++i) {
            timeLabels[i] = new JLabel("");
        }
        // endregion

        // region 初始化布局
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(JBColor.GRAY, 1),
                "最近5次执行时间",
                TitledBorder.LEFT,
                TitledBorder.TOP
        ));
        for (JLabel timeLabel : timeLabels) {
            add(timeLabel);
            add(Box.createVerticalStrut(5));
        }
        // endregion
    }

    public void setExecutionTime(List<String> executionTimes) {
        if (executionTimes.isEmpty()) {
            return;
        }
        // 有异常
        if (executionTimes.size() == 1) {
            String exceptionMsg = executionTimes.getFirst();
            // 处理异常信息，显示换行，否则会显示在一行，不方便查看
            exceptionMsg = exceptionMsg.replaceAll("\\. ", ".<br>");
            this.timeLabels[0].setText("<html>" + exceptionMsg + "</html>");
            // 异常染色
            this.timeLabels[0].setForeground(JBColor.RED);
            for (int i = 1; i < timeLabels.length; ++i) {
                this.timeLabels[i].setForeground(JBColor.BLACK);    // 正常染色
                this.timeLabels[i].setText("");
            }
        } else {
            for (int i = 0; i < executionTimes.size(); ++i) {
                this.timeLabels[i].setForeground(JBColor.BLACK);    // 正常染色
                this.timeLabels[i].setText("    " + (i + 1) + ". " + executionTimes.get(i));
            }
        }
    }

}
