package view.roles;

import util.ViewUtil;
import view.auth.ChangePasswordView;
import view.auth.UpdateProfileView;

import java.util.UUID;

public class ClientView {

    public static void showMenu(UUID id) {
        ViewUtil.printHeader();
        boolean running = true;

        while (running) {
            System.out.println("""
                1. Search available rooms \n
                2. View all rooms \n
                3. Create reservation \n
                4. My reservations \n
                5. Reservation details \n
                6. Update reservation \n
                7. Cancel reservation \n
                8. Update profile \n
                9. Change password \n
                10. Logout \n
                0. Exit \n
                """);

            int choice = ViewUtil.readIntChoice();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    UpdateProfileView.showMenu(id);
                    break;
                case 9:
                    ChangePasswordView.changePasswordView(id);
                    break;
                case 10:

                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. \n");
                    break;
            }
        }


    }
}
