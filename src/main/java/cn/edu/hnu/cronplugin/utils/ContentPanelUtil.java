package cn.edu.hnu.cronplugin.utils;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

/**
 * 内容面板工具类
 * 内容面板一般用于 panels 包中，用于方便组装各个子组件
 */
public class ContentPanelUtil {

    private ContentPanelUtil() {}

    public static JPanel assembledContentPanel(JComponent... components) {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        for (JComponent component : components) {
            contentPanel.add(component);
            contentPanel.add(Box.createVerticalStrut(15));
        }

        return contentPanel;
    }


}
