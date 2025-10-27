import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        JFrame frame = new JFrame("Smart Task Scheduler");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(e -> {
            String title = JOptionPane.showInputDialog("Enter Task Title:");
            String desc = JOptionPane.showInputDialog("Enter Task Description:");
            int priority = Integer.parseInt(JOptionPane.showInputDialog("Enter Priority (1-High,2-Med,3-Low):"));
            LocalDate deadline = LocalDate.parse(JOptionPane.showInputDialog("Enter Deadline (YYYY-MM-DD):"));
            manager.addTask(new Task(title, desc, priority, deadline));
            JOptionPane.showMessageDialog(null, "Task Added!");
        });

        JButton viewButton = new JButton("View Tasks");
        viewButton.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for(Task t : manager.getAllTasks()) sb.append(t).append("\n");
            JOptionPane.showMessageDialog(null, sb.length() > 0 ? sb.toString() : "No tasks found.");
        });

        frame.add(addButton);
        frame.add(viewButton);
        frame.setVisible(true);
    }
}
