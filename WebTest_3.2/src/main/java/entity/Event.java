package entity;


//import core.Model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//public class Event implements Model {
public class Event   {
    @NotNull
    private int eventId;
    @NotNull @Size(min = 2, max = 45)
    private String name;
    @NotNull @Size(min = 2, max = 128)
    private String type;
    @Size(min = 2, max = 10)
    private String mdate;

    public static String tableName = "event";

    public Event(String name, String type, String mdate) {
        this.name = name;
        this.type = type;
        this.mdate = mdate;
    }

    public Event() {

    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", mdate='" + mdate + '\'' +
                '}';
    }
}
