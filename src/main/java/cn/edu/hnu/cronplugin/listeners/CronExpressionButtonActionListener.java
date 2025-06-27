package cn.edu.hnu.cronplugin.listeners;

import cn.edu.hnu.cronplugin.utils.CronExpressionUtil;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Cron 表达式键入按钮监听器
 */
@Deprecated(since = "由Built-In Button代替")
public class CronExpressionButtonActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取编辑器
        Project openProject = ProjectManager.getInstance().getOpenProjects()[0];
        Editor editor = FileEditorManager.getInstance(openProject).getSelectedTextEditor();

        if (editor != null) {
            Document document = editor.getDocument();
            CaretModel caretModel = editor.getCaretModel();
            int offset = caretModel.getOffset();

            // 插入表达式
            String cronExpression = CronExpressionUtil.getCronExpression();
            // 安全写入
            WriteCommandAction.runWriteCommandAction(openProject, () -> {
                document.insertString(offset, cronExpression);
                // 移动光标到末尾
                caretModel.moveToOffset(offset + cronExpression.length());
            });

        }
    }
}
