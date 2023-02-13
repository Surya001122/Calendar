package userInterface;
import events.Task;
import pojo.ReminderListData;
import pojo.inputPojo.TaskData;
import utilities.ValidationUtilities;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskInputHandler extends InputHandler<TaskData,Task>{
    @Override
    public TaskData getInputForCreatingEvent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the task title : ");
        String taskTitle = sc.nextLine().trim();
        System.out.print("\nEnter the task description : ");
        String taskDescription = sc.nextLine().trim();
        String taskStartDate;
        do{
            System.out.print("\nEnter valid task Date (dd/mm/yyyy HH:mm:ss): ");
            taskStartDate = sc.nextLine().trim();
        }while(ValidationUtilities.validateDate(taskStartDate));
        ReminderListData reminderListData = getInputForSettingReminder();
        return new TaskData(taskTitle,taskDescription,taskStartDate,reminderListData);
    }

    @Override
    public int getInputForFetchingEventId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the task id (-1 if not available) to cancel/update : ");
        int taskId = -1;
        try{
            taskId = Integer.parseInt(sc.nextLine().trim());
        }
        catch(NumberFormatException numberFormatException){
            System.out.print("\nEnter the valid option and try again...");
        }
        return taskId;

    }

    @Override
    public TaskData getInputForUpdatingEvent() {
        Scanner sc = new Scanner(System.in);
        boolean updateBool = true;
        String taskTitle = null;
        String taskDescription = null;
        while(updateBool) {
            System.out.print("\nEnter 1 to change the task title\nEnter 2 to change the task description\nEnter 3 to exit\nEnter your choice : ");
            int updateChoice = 0;
            try {
                updateChoice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("\nEnter valid information...Please try again");
            }
            switch (updateChoice) {
                case 1:
                    System.out.print("Enter the new title : ");
                    taskTitle = sc.nextLine().trim();
                    break;
                case 2:
                    System.out.print("Enter the new description: ");
                    taskDescription = sc.nextLine().trim();
                    break;
                case 3:
                    updateBool = false;
                    break;
                default:
                    System.out.println("\nEnter valid choice...");
                    break;
            }
        }
        return new TaskData(taskTitle,taskDescription);
    }

    public boolean displayAllEvents(ArrayList<Task>displayList){
        if(displayList.isEmpty()){
            System.out.println("\nNo tasks available...");
            return false;
        }
        else {
            for(Task task : displayList){
                System.out.println("\nTask ID : "+task.getEventId()+"\nTaskTitle : "+task.getEventTitle()+"\nTask description : "+task.getEventDescription()+"\ntask start date : "+task.getEventStartDate()+"\nEvent type : "+task.getEventType()+"\n-------------------------------------------------------------------------");
            }
        }
        return true;
    }
}
