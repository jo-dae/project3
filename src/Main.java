import java.util.*;

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("please make a selection:");
        System.out.println("(1)add a task");
        System.out.println("(2)remove a task");
        System.out.println("(3)update a task");
        System.out.println("(4)list all tasks");
        System.out.println("(0)exit");
        int userInput = input.nextInt();
        input.nextLine();
        while (true) {
            if (userInput == 1) {
                addTask(tasks);
            } else if (userInput == 0) {
                System.exit(0);

            } else if (userInput == 4) {
                Collections.sort(tasks);
                listTask();
            }
            else if (userInput == 2) {
                removeTask(tasks);

            }

            System.out.println("please make a selection");
            userInput = input.nextInt();
            input.nextLine();

        }

    }

    static ArrayList<Task> addTask(ArrayList<Task> a) {
        System.out.println("please enter a title for the task");
        String title = input.nextLine();

        System.out.println("please provide a description for the task");
        String desc = input.nextLine();

        System.out.println("what is the tasks priority");
        int prio = input.nextInt();

        Task newTask = new Task(title, desc, prio);
        a.add(newTask);

        return a;
    }

    static ArrayList<Task> removeTask(ArrayList<Task> a) {
        System.out.println("what task would you like to remove");
        String task = input.nextLine();
        a.remove(task);
        return a;
    }

    static void listTask() {
        System.out.println(tasks);
    }
}




//remove function myList.remove();
class Task implements Comparable<Task>, Iterable<Task>{
    private String title;

    private String desc;

    private int priority;

    public Task(String title, String desc, int priority) {
        this.title = title;
        this.desc = desc;
        this.priority = priority;
    }




    //int compareResult = this.title.compareTo(other.title);

    //if (compareResult == 0){
    // if(this.getPriority() < other.getPriority){
    //   return -1;
    // }
    // }
    public String getTitle () {
        return title;
    }

    public void setTitle (String title){
        this.title = title;
    }

    public String getDesc () {
        return desc;
    }

    public void setDesc (String desc){
        this.desc = desc;
    }

    public int getPriority () {
        return priority;
    }

    public void setPriority ( int priority){
        this.priority = priority;
    }

    @Override
    public String toString () {
        return "Task{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }

    @Override
    public int compareTo(Task o) {
        int compareResult = this.title.compareTo(o.title);

        if(compareResult == 0){
            if(this.getPriority() < o.getPriority()){
                return-1;
            }
        }

        return compareResult;
    }

    @Override
    public Iterator iterator() {
        return Task.this.iterator();
    }
}




