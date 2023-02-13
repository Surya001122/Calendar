package themes;
import java.util.HashMap;

public class Theme {
    private String meetingTheme;
    private String taskTheme;
    private String birthdayTheme;
    private String holidayTheme;
    private final String resetTheme = "\u001B[0m";
    private final HashMap<String, String> themesList = new HashMap<>();

    public Theme() {
        themesList.put("BLACK", "\033[1;90m");
        themesList.put("RED", "\033[1;91m");
        themesList.put("GREEN", "\033[1;92m");
        themesList.put("YELLOW", "\033[1;93m");
        themesList.put("BLUE", "\033[1;94m");
        themesList.put("PURPLE", "\033[1;95m");
        themesList.put("CYAN", "\033[1;96m");
        themesList.put("WHITE", "\033[1;97m");
        meetingTheme = "\033[1;91m"; // RED
        taskTheme = "\033[1;94m"; // BLUE
        holidayTheme = "\033[1;95m"; // PURPLE
        birthdayTheme = "\033[1;96m"; //CYAN
    }

    public String getMeetingTheme() {
        return meetingTheme;
    }

    public void setMeetingTheme(String meetingTheme) {
        if(themesList.containsKey(meetingTheme)) {
            this.meetingTheme = themesList.get(meetingTheme);
        }
    }
    public void resetMeetingTheme(){
        this.meetingTheme = "";
    }

    public String getTaskTheme() {
        return taskTheme;
    }

    public void setTaskTheme(String taskTheme) {
        if(themesList.containsKey(taskTheme)) {
            this.taskTheme = themesList.get(taskTheme);
        }
    }
    public void resetTaskTheme(){
        this.taskTheme = "";
    }

    public String getBirthdayTheme() {
        return birthdayTheme;
    }

    public void setBirthdayTheme(String birthdayTheme) {
        if(themesList.containsKey(birthdayTheme)) {
            this.birthdayTheme = themesList.get(birthdayTheme);
        }
    }
    public void resetBirthdayTheme(){
        this.birthdayTheme = "";
    }

    public String getHolidayTheme() {
        return holidayTheme;
    }

    public void setHolidayTheme(String holidayTheme) {
        if (themesList.containsKey(holidayTheme)) {
            this.holidayTheme = themesList.get(holidayTheme);
        }
    }
    public void resetHolidayTheme(){
        this.holidayTheme = "";
    }
    public String getResetTheme() {
        return resetTheme;
    }

    public void viewAvailableThemes(){
        System.out.println("\nAvailableThemes : \n");
        for(String colourName : themesList.keySet()){
            System.out.println(themesList.get(colourName)+colourName+resetTheme);
        }
    }
}
