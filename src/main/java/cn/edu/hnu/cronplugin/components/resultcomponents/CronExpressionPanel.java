package cn.edu.hnu.cronplugin.components.resultcomponents;

import cn.edu.hnu.cronplugin.components.AbstractPanelComponent;
import cn.edu.hnu.cronplugin.cron.CronItemEnum;
import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import com.intellij.icons.AllIcons;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.ui.components.fields.ExtendableTextComponent;
import com.intellij.ui.components.fields.ExtendableTextField;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Cron 表达式面板
 */
public class CronExpressionPanel extends AbstractPanelComponent {

    private JLabel cronExpressionLabel;
    private ExtendableTextField cronExpressionField;

    public CronExpressionPanel() {
        // region 初始化组件
        cronExpressionLabel = new JLabel("  表达式: ");

        cronExpressionField = new ExtendableTextField(CronExpressionUtil.getCronExpression());
        cronExpressionField.setEditable(false);
        cronExpressionField.setColumns(20);
        Font currentFont = cronExpressionField.getFont();
        Font newFont = currentFont.deriveFont(12f);
        cronExpressionField.setFont(newFont);

        // 添加复制按钮扩展
        ExtendableTextComponent.Extension copyExtension = ExtendableTextComponent.Extension.create(
                AllIcons.Actions.Copy,
                "复制到剪贴板",
                () -> copyToClipboard(cronExpressionField.getText())
        );
        cronExpressionField.addExtension(copyExtension);
        // 添加键入编辑器按钮扩展
        ExtendableTextComponent.Extension insertExtension = ExtendableTextComponent.Extension.create(
                AllIcons.Actions.Back,
                "键入编辑器",
                () -> insertToEditor(cronExpressionField.getText())
        );
        cronExpressionField.addExtension(insertExtension);
        // endregion

        // region 初始化布局
        setLayout(new FlowLayout(FlowLayout.LEFT, 0 ,5));
        setAlignmentX(Component.LEFT_ALIGNMENT);

        add(cronExpressionLabel);
        add(Box.createHorizontalStrut(5));
        add(cronExpressionField);
        add(Box.createHorizontalStrut(5));
        // endregion

        // region 设置监听器
        setupEventListener();
        // endregion
    }

    public void setCronExpressionField(String cronExpression) {
        cronExpressionField.setText(cronExpression);
    }

    private void copyToClipboard(String text) {
        // 获取系统剪贴板
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(text), null);

        String groupId = "Clipboard.Notification.Group";
        // 创建气球通知
        Notification notification = new Notification(
                groupId,    // 通知组 ID
                "复制成功",                        // 通知标题
                "内容已复制到剪贴板！",             // 通知内容
                NotificationType.INFORMATION    // 通知类型
        );

        // 显示通知（气球模式）
        ApplicationManager.getApplication().invokeLater(() ->
                Notifications.Bus.notify(notification)
        );
    }

    private void insertToEditor(String text) {
        // 获取编辑器
        Project openProject = ProjectManager.getInstance().getOpenProjects()[0];
        Editor editor = FileEditorManager.getInstance(openProject).getSelectedTextEditor();

        if (editor != null) {
            Document document = editor.getDocument();
            CaretModel caretModel = editor.getCaretModel();
            int offset = caretModel.getOffset();

            // 插入表达式
            // 安全写入
            WriteCommandAction.runWriteCommandAction(openProject, () -> {
                document.insertString(offset, text);
                // 移动光标到末尾
                caretModel.moveToOffset(offset + text.length());
            });

            String groupId = "InsertEditor.Notification.Group";
            // 创建气球通知
            Notification notification = new Notification(
                    groupId,    // 通知组 ID
                    "键入成功",                          // 通知标题
                    "内容已键入到编辑器！",               // 通知内容
                    NotificationType.INFORMATION        // 通知类型
            );

            // 显示通知（气球模式）
            ApplicationManager.getApplication().invokeLater(() ->
                    Notifications.Bus.notify(notification)
            );
        }
    }

    @Override
    public void setupItemListener() {

    }

    @Override
    public void setupDocumentListener() {

    }

    @Override
    public void setupActionListener() {
        // CronExpressionButtonActionListener listener = new CronExpressionButtonActionListener();
        // insertButton.addActionListener(listener);
    }

    @Override
    public void updateInnerComponentsAvailability() {

    }

    @Override
    public void updateResultCronExpression(CronItemEnum cronItemEnum) {

    }
}
