package cn.edu.hnu.cronplugin.utils;

import javax.swing.JCheckBox;
import java.util.ArrayList;
import java.util.List;

/**
 * 多选框工具类
 */
public class CheckBoxUtil {

    private CheckBoxUtil() {}

    /**
     * 获取选中的多选框
     * @param checkboxes 二维数组
     * @return
     */
    public static List<String> getSelectedCheckBoxes(JCheckBox[][] checkboxes) {
        List<String> selectedCheckboxes = new ArrayList<>();
        for (int row = 0; row < checkboxes.length; row++) {
            for (int col = 0; col < checkboxes[0].length; col++) {
                JCheckBox checkbox = checkboxes[row][col];
                if (checkbox.isSelected() ) {
                    selectedCheckboxes.add(checkbox.getText());
                }
            }
        }
        return selectedCheckboxes;
    }

    /**
     * 获取选中的多选框
     * @param checkboxes 一维数组
     * @return
     */
    public static List<String> getSelectedCheckBoxes(JCheckBox[] checkboxes) {
        List<String> selectedCheckboxes = new ArrayList<>();
        for (int row = 0; row < checkboxes.length; row++) {
            JCheckBox checkbox = checkboxes[row];
            if (checkbox.isSelected() ) {
                selectedCheckboxes.add(checkbox.getText());
            }
        }
        return selectedCheckboxes;
    }

}
