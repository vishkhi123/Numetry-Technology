package tester;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dao.UserDao;
import pojos.User;

public class Test {
    private static SessionFactory sessionFactory;
    private static UserDao userDao;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
            userDao = new UserDao();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add User");
            System.out.println("2. View Users");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Get User By Id");
            System.out.println("6. Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter user details (firstName lastName email password address)");
                  //  String[] userDetails = scanner.next().split(" ");
                    User user = new User();
                    user.setFirstName(scanner.next());
                    user.setLastName(scanner.next());
                    user.setEmail(scanner.next());
                    user.setPassword(scanner.next());
                    user.setAddress(scanner.next());
                    String saveMessage = userDao.saveUser(user);
                    System.out.println(saveMessage);
                    break;
                case 2:
                    List<User> users = userDao.getAllUsers();
                    for (User u : users) {
                        System.out.println(u);
                    }
                    break;
                case 3:
                    System.out.println("Enter user id to update");
                    int idToUpdate = scanner.nextInt();
                    System.out.println("Enter new user details (firstName lastName email password address)");
                 //   String[] newUserDetails = scanner.next().split(" ");
                    User newUser = new User();
                    newUser.setFirstName(scanner.next());
                    newUser.setLastName(scanner.next());
                    newUser.setEmail(scanner.next());
                    newUser.setPassword(scanner.next());
                    newUser.setAddress(scanner.next());
                    String updateMessage = userDao.updateUserDetails(idToUpdate, newUser);
                    System.out.println(updateMessage);
                    break;
                case 4:
                    System.out.println("Enter user id to delete");
                    int idToDelete = scanner.nextInt();
                    String deleteMessage = userDao.deleteUserDetails(idToDelete);
                    System.out.println(deleteMessage);
                    break;
                case 5:
                    System.out.println("Enter user id to get");
                    int idToGet = scanner.nextInt();
                    User userToGet = userDao.getUserDetailsById(idToGet);
                    System.out.println(userToGet);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please choose a valid option");
            }
        }
        sessionFactory.close();
    }
}
	
	
	
	
	
	
		
	
	


