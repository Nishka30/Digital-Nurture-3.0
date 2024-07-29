class Task {
    String taskId;
    String taskName;
    String status;
    Task next;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Task head;

    public TaskManagementSystem() {
        head = null;
    }

    public void addTask(Task task) {
        if (head == null) {
            head = task;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = task;
        }
    }

    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId.equals(taskId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName);
            current = current.next;
        }
    }

    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.taskId.equals(taskId)) {
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId.equals(taskId)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        Task task1 = new Task("T001", "Task One", "Pending");
        Task task2 = new Task("T002", "Task Two", "Completed");
        tms.addTask(task1);
        tms.addTask(task2);

        tms.traverseTasks();

        tms.deleteTask("T001");
        tms.traverseTasks();
    }
}
