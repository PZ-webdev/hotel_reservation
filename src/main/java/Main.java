import Controllers.GuestController;
import Controllers.RoomController;
import Controllers.UserController;

public class Main{

    public static void main(String[] args) {

        new RoomController();
        new UserController();
        new GuestController();
    }
}