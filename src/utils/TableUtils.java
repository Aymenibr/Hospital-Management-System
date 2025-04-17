package utils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;

public class TableUtils {
    public static void setupDummyTable(JTable table, JScrollPane scrollPane, JPanel panel, String[] columnTitles) {
        table.setModel(new DefaultTableModel(
            new Object[][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            columnTitles
        ));
        scrollPane.setViewportView(table);
        panel.setBackground(new Color(0, 204, 204));
    }
}
