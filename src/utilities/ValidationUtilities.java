package utilities;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtilities {
    public static boolean validateDate(String date) {
        SimpleDateFormat vDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date1, date2;
        Date currentDate, preferredDate;
        Date newDate;
        try {
            vDate.setLenient(false);
            newDate = vDate.parse(date);
            date1 = vDate.format(new Date());
            date2 = vDate.format(newDate);
            currentDate = vDate.parse(date1);
            preferredDate = vDate.parse(date2);
            if ((preferredDate.after(currentDate)) || (preferredDate.equals(currentDate))) {
                return false;
            } else {
                System.out.println(date + " is Invalid Date format");
            }
        } catch (Exception e) {
            System.out.println(date + " is Invalid Date format");
        }
        return true;
    }
    public static boolean validateDOB(String date){
        SimpleDateFormat vDate = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate;
        try{
            newDate = vDate.parse(date);
        }
        catch (ParseException e) {
            newDate = null;
            System.out.println(date + " is Invalid DOB");
        }
        return newDate != null;
    }
    public static boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()]).{8,20}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("^[0-9].{7,15}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        return !matcher.matches();
    }

    public static boolean isEqual(int day, int month, int year, String date) {
        String[] dateOnlyPart = date.split(" ");
        String[] dateParts = dateOnlyPart[0].split("/");
        int dayPart = Integer.parseInt(dateParts[0]);
        int monthPart = Integer.parseInt(dateParts[1]);
        int yearPart = Integer.parseInt(dateParts[2]);
        return ((dayPart == day) && (monthPart - 1 == month) && (yearPart == year));
    }
}
