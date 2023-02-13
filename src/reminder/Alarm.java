package reminder;

import java.awt.*;


public class Alarm{
    public void playAlarm() {
        long start = System.currentTimeMillis();
        long end = start + (10*1000L);
        while (System.currentTimeMillis() < end ) {
            Toolkit.getDefaultToolkit().beep();
            try {
                Thread.sleep( 100 );
            }
            catch ( InterruptedException ignored) {}
        }
    }
}
