package cn.edu.hnu.cronplugin.components;

import javax.swing.JRadioButton;
import java.awt.Component;

/**
 * 单选框组件
 */
public class CronRadioButton extends JRadioButton {
    public CronRadioButton(String description) {
        setText(description);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
