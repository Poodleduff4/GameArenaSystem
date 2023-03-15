public class Cart {
    Ticket[] tickets;


    public int cartCounter(){
        return tickets.length;
    }

    public Ticket[] getCartItems(){
        return tickets;
    }
}
