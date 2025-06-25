package cn.edu.hnu.cronplugin.utils;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronDaysPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronHoursPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronMinutesPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronMonthsPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronSecondsPanel;
import cn.edu.hnu.cronplugin.panels.PlaceholderPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronWeeksPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronYearsPanel;

import java.util.HashMap;
import java.util.Map;

/**
 * 标签页工具类
 */
public class TabbedPaneUtil {

    private final static Map<String, AbstractPanel> panelMap = new HashMap<>();

    static {
        panelMap.put("秒", new CronSecondsPanel());
        panelMap.put("分钟", new CronMinutesPanel());
        panelMap.put("小时", new CronHoursPanel());
        panelMap.put("日", new CronDaysPanel());
        panelMap.put("月", new CronMonthsPanel());
        panelMap.put("周", new CronWeeksPanel());
        panelMap.put("年", new CronYearsPanel());
    }

    public static AbstractPanel getSubPanels(String name) {
        return panelMap.getOrDefault(name, new PlaceholderPanel());
    }


}
