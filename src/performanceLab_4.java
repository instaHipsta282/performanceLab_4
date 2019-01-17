import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class performanceLab_4 {
    public static void main(String[] args) {
        int[] hourArray = new int[12];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            String s;
            while ((s = reader.readLine()) != null) {
                String startTime = s.split("-")[0];
                String endTime = s.split("-")[1];

                int startTimeHour = Integer.parseInt(startTime.split(":")[0]);
                int endTimeHour = Integer.parseInt(endTime.split(":")[0]);

                if (startTimeHour == endTimeHour) {
                    hourArray[startTimeHour - 8]++;
                }
                else {
                    hourArray[startTimeHour - 8]++;
                    hourArray[endTimeHour - 8]++;
                }
            }
            int maxClients = 0;
            for (int i = 0; i < hourArray.length; i++) {
                if (hourArray[i] > maxClients) maxClients = hourArray[i];
            }
            for (int i = 0; i < hourArray.length; i++) {
                if (hourArray[i] == maxClients) {
                    int startHour = i + 8;
                    int endHour = startHour + 1;
                    System.out.println(startHour + ":00 to " + endHour + ":00 the Bank had " + hourArray[i] + " customers");
                }
            }
        }
        catch (IOException e) { e.printStackTrace(); }
        finally {
            if (reader != null) {
                try { reader.close(); }
                catch (IOException ignore) {}
            }
        }
    }
}
