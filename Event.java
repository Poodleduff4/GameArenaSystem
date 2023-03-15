import java.util.Date;

public class Event {
    int EventID;
    String eventName;
    String eventDesc;
    Date eventDate;
    String eventType;
    Section[] sections;
    int numSeats;

    Event(int numSections){
        sections = new Section[numSections];
    }

    public String getEventByType(){
        return "";
    }

    public String getEventDetails(){
        return "";
    }

    public Section[] getSectionsForEvent(){
        return sections;
    }


}
