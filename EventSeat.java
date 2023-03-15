public class EventSeat extends Seat {
    int status;
    int eventID;
    int seatID;
    int rowNum;
    int sectionNum;
    int price;

    EventSeat(){
        this.status = 1;
    }

    public int checkStatus(){
        return this.status;
    }

    // seat bought, status = 0
    public void updateStatus() {
        this.status = 0;
    }
}
