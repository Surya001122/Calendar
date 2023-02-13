package themes;
import java.util.Scanner;

public class ThemeOperator {
    private final ThemeStorage themeStorage = ThemeStorage.getInstance();
    public void setThemes(String userId) {
        Scanner sc = new Scanner(System.in);
        boolean themeBool = true;
        while (themeBool) {
            String newColour;
            Theme theme = themeStorage.getUserThemeList(userId);
            theme.viewAvailableThemes();
            System.out.print("\nEnter 1 to set theme for meeting\nEnter 2 to set theme for task\nEnter 3 to set theme for birthday\nEnter 4 to set theme for holiday\nEnter 5 to reset theme for event\nEnter 6 to reset theme for task\nEnter 7 to reset theme for birthday\nEnter 8 to reset theme for holiday\nEnter 9 to go back\nEnter your choice : ");
            int themeChoice;
            try {
                themeChoice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException numberFormatException) {
                System.out.print("\nEnter valid option..please try again..");
                return;
            }
            switch (themeChoice) {
                case 1:
                    System.out.print("\nEnter the colour to set : ");
                    newColour = sc.nextLine().trim();
                    theme.setMeetingTheme(newColour);
                    break;
                case 2:
                    System.out.print("\nEnter the colour to set : ");
                    newColour = sc.nextLine().trim();
                    theme.setTaskTheme(newColour);
                    break;
                case 3:
                    System.out.print("\nEnter the colour to set : ");
                    newColour = sc.nextLine().trim();
                    theme.setBirthdayTheme(newColour);
                    break;
                case 4:
                    System.out.print("\nEnter the colour to set : ");
                    newColour = sc.nextLine().trim();
                    theme.setHolidayTheme(newColour);
                    break;
                case 5:
                    theme.resetMeetingTheme();
                    break;
                case 6:
                    theme.resetTaskTheme();
                    break;
                case 7:
                    theme.resetBirthdayTheme();
                    break;
                case 8:
                    theme.resetHolidayTheme();
                    break;
                default:
                    themeBool = false;
                    break;
            }
        }
    }
    public Theme getUserThemeList(String userId){
        return themeStorage.getUserThemeList(userId);
    }
    public void createThemesForUserCalendar(String userId){
        Theme theme = new Theme();
        themeStorage.createThemesForUserCalendar(userId,theme);
    }
}
