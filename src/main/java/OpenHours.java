/**
 * Created by Mélanie on 28/07/2016.
 */
public class OpenHours {

    private String name;
    public String openTime = "09:00";
    public String closeTime = "18:00";

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    @Override
    public String toString() {
        return "OpenHours{" +
                "openTime='" + openTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                '}';
    }
}
