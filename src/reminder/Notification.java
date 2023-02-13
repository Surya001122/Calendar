package reminder;

public class Notification {
    private final String message;

    public Notification(String message) {
        this.message = message;
    }

    public void playNotification(){
        System.out.println("\n\nNew Message : "+message+"\n\n");
    }
}
