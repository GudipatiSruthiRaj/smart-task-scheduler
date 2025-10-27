import java.io.*;
import java.util.*;

public class TaskManager {
    private PriorityQueue<Task> tasks;

    public TaskManager() {
        tasks = new PriorityQueue<>();
        loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveTasks();
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
        saveTasks();
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.dat"))) {
            oos.writeObject(new ArrayList<>(tasks));
        } catch (IOException e) { e.printStackTrace(); }
    }

    private void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tasks.dat"))) {
            List<Task> loadedTasks = (List<Task>) ois.readObject();
            tasks.addAll(loadedTasks);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No saved tasks found.");
        }
    }
}
