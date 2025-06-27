package cn.edu.hnu.cronplugin.components.tabbedcomponents;

import com.intellij.ui.JBColor;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Font;

/**
 * 帮助页章节面板
 */
public class CronHelpSectionPanel extends JPanel {
    private JLabel label;

    public CronHelpSectionPanel(String title, String text) {
        // region 初始化组件
        this.label = new JLabel(text);
        // endregion

        // region 设置布局
        setLayout(new BorderLayout());
        // 设置标题，官方的 TitledSeparator 分割线显示不出来，不知道为什么。。。
        MatteBorder topBorder = new MatteBorder(1, 0, 0, 0, JBColor.LIGHT_GRAY);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(
                topBorder,
                title,
                TitledBorder.LEFT,
                TitledBorder.TOP
        );
        setBorder(titledBorder);
        add(this.label, BorderLayout.CENTER);
        // endregion
    }
}
