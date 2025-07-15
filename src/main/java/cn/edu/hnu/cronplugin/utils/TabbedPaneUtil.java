package cn.edu.hnu.cronplugin.utils;

import cn.edu.hnu.cronplugin.panels.AbstractPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronDaysPanel;
import cn.edu.hnu.cronplugin.panels.tabbedpanes.CronHelpPanel;
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
/*  这里不能使用 Map 单例模式，否则在多项目下会出现面板无法正常显示的 bug
    private final static Map<String, AbstractPanel> panelMap = new HashMap<>();

    static {
        panelMap.put("秒", new CronSecondsPanel());
        panelMap.put("分钟", new CronMinutesPanel());
        panelMap.put("小时", new CronHoursPanel());
        panelMap.put("日", new CronDaysPanel());
        panelMap.put("月", new CronMonthsPanel());
        panelMap.put("周", new CronWeeksPanel());
        panelMap.put("年", new CronYearsPanel());
        panelMap.put("帮助", new CronHelpPanel());
    }*/

    public static AbstractPanel getSubPanels(String name) {
        // 根据名称返回类
        switch (name) {
            case "秒":
                return new CronSecondsPanel();
            case "分钟":
                return new CronMinutesPanel();
            case "小时":
                return new CronHoursPanel();
            case "日":
                return new CronDaysPanel();
            case "月":
                return new CronMonthsPanel();
            case "周":
                return new CronWeeksPanel();
            case "年":
                return new CronYearsPanel();
            case "帮助":
                return new CronHelpPanel();
            default:
                return new PlaceholderPanel();
        }
    }


}
