package cn.edu.hnu.cronplugin.components.resultcomponents;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.table.JBTable;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.BorderLayout;

/**
 * Cron 表达式结果表格
 */
public class CronResultTablePanel extends JPanel {
    // 创建表达式表格
    private String[] tableHeader;
    private String[][] tableData;
    private JBScrollPane scrollPane;
    private JBTable cronExpressionTable;

    public CronResultTablePanel() {
        // region 初始化组件
        tableHeader = new String[]{"", "秒", "分钟", "小时", "日", "月", "周", "年"};
        tableData = new String[][] {{"表达式字段: ", "*", "*", "*", "*", "*", "?", "*"}};

        TableModel tableModel = new DefaultTableModel(tableData, tableHeader) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;   // 设置为不可编辑
            }
        };
        cronExpressionTable = new JBTable(tableModel);
        cronExpressionTable.setAutoResizeMode(JBTable.AUTO_RESIZE_OFF);

        scrollPane = new JBScrollPane(cronExpressionTable);
        // endregion

        // region 设置布局
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        // endregion
    }
}
