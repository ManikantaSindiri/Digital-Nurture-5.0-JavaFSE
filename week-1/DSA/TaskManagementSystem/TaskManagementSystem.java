public class TaskManagementSystem {
    private Node head;

    public void addTask(String title, String priority) {
        Node newNode = new Node(title, priority);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void deleteTask(String title) {
        if (head == null) {
            return;
        }

        if (head.title.equals(title)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.title.equals(title)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void displayTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.title + " [" + current.priority + "]");
            current = current.next;
        }
    }

    private static class Node {
        private final String title;
        private final String priority;
        private Node next;

        public Node(String title, String priority) {
            this.title = title;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.addTask("Write report", "High");
        system.addTask("Attend meeting", "Medium");
        system.addTask("Email client", "Low");

        System.out.println("Tasks before deletion:");
        system.displayTasks();

        system.deleteTask("Attend meeting");

        System.out.println("\nTasks after deletion:");
        system.displayTasks();
    }
}
