import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BootcampersList bootcampersList = new BootcampersList(50);
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        System.out.println("Menu");
        System.out.println("help - Display this list of orders");
        System.out.println("add - Add a new person (registration)");
        System.out.println("check - Check if a person is registered for the event");
        System.out.println("remove - Remove an existing person from the list");
        System.out.println("update - Update a person's details");
        System.out.println("bootcampers - List of people attending the event");
        System.out.println("java - List of people that wish to join the Java course");
        System.out.println("c++ - List of people that wish to join the C++ course");
        System.out.println("python - List of people that wish to join the Python course");
        System.out.println("waitlist - People on the waiting list");
        System.out.println("available - Number of available seats");
        System.out.println("bootcampers_number - Number of people attending the event");
        System.out.println("waitlist_number - Number of people on the waiting list");
        System.out.println("subscribe_number - Total number of people registered");
        System.out.println("search - Search for all guests according to the string entered");
        System.out.println("quit - Close the application");

        while (!quit) {
            System.out.print("Enter your command: ");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "help":
                    System.out.println("Menu");
                    System.out.println("help - Display this list of orders");
                    System.out.println("add - Add a new person (registration)");
                    System.out.println("check - Check if a person is registered for the event");
                    System.out.println("remove - Remove an existing person from the list");
                    System.out.println("update - Update a person's details");
                    System.out.println("bootcampers - List of people attending the event");
                    System.out.println("java - List of people that wish to join the Java course");
                    System.out.println("c++ - List of people that wish to join the C++ course");
                    System.out.println("python - List of people that wish to join the Python course");
                    System.out.println("waitlist - People on the waiting list");
                    System.out.println("available - Number of available seats");
                    System.out.println("bootcampers_number - Number of people attending the event");
                    System.out.println("waitlist_number - Number of people on the waiting list");
                    System.out.println("subscribe_number - Total number of people registered");
                    System.out.println("search - Search for all guests according to the string entered");
                    System.out.println("quit - Close the application");
                    break;
                case "add":
                    System.out.println("Enter the details of the person to add:");
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Programming Language (Java, C++, Python): ");
                    String programmingLanguageInput = scanner.nextLine();
                    ProgrammingLanguage programmingLanguage = null;
                    switch (programmingLanguageInput.toLowerCase()) {
                        case "java":
                            programmingLanguage = ProgrammingLanguage.Java;
                            break;
                        case "c++":
                            programmingLanguage = ProgrammingLanguage.Cpp;
                            break;
                        case "python":
                            programmingLanguage = ProgrammingLanguage.Python;
                            break;
                        default:
                            System.out.println("Invalid programming language. Person not added.");
                            continue;
                    }

                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    Bootcamper bootcamper = new Bootcamper(firstName, lastName, programmingLanguage,
                            new ArrayList<>(), email, phoneNumber);
                    String result = bootcampersList.addBootcamper(bootcamper);
                    System.out.println(result);
                    break;
                case "check":
                    System.out.println("Enter the details of the person to check:");
                    System.out.print("First Name: ");
                    String checkFirstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String checkLastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String checkEmail = scanner.nextLine();

                    Bootcamper checkBootcamper = new Bootcamper(checkFirstName, checkLastName,
                            null, new ArrayList<>(), checkEmail, null);
                    boolean isRegistered = bootcampersList.isRegistered(checkBootcamper);

                    if (isRegistered) {
                        System.out.println("The person is registered for the event.");
                    } else {
                        System.out.println("The person is not registered for the event.");
                    }
                    break;
                case "remove":
                    System.out.println("Enter the details of the person to remove:");
                    System.out.print("First Name: ");
                    String removeFirstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String removeLastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String removeEmail = scanner.nextLine();

                    Bootcamper removeBootcamper = new Bootcamper(removeFirstName, removeLastName,
                            null, new ArrayList<>(), removeEmail, null);
                    boolean removed = bootcampersList.removeBootcamper(removeBootcamper);

                    if (removed) {
                        System.out.println("The person has been removed from the list.");
                    } else {
                        System.out.println("The person was not found in the list.");
                    }
                    break;
                case "update":
                    System.out.println("Enter the details of the person to update:");
                    System.out.print("First Name: ");
                    String updateFirstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String updateLastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String updateEmail = scanner.nextLine();

                    Bootcamper updateBootcamper = new Bootcamper(updateFirstName, updateLastName, null,
                            new ArrayList<>(), updateEmail, null);
                    boolean isUpdateRegistered = bootcampersList.isRegistered(updateBootcamper);

                    if (!isUpdateRegistered) {
                        System.out.println("The person is not registered for the event. Update not possible.");
                        continue;
                    }

                    System.out.println("Enter the new details:");
                    System.out.print("New First Name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("New Last Name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("New Email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("New Programming Language: ");
                    ProgrammingLanguage newProgrammingLanguage
                            = ProgrammingLanguage.valueOf(scanner.nextLine());
                    System.out.print("New Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();

                    Bootcamper newBootcamper = new Bootcamper(newFirstName, newLastName,
                            newProgrammingLanguage, new ArrayList<>(), newEmail, newPhoneNumber);

                    boolean update = bootcampersList.updateBootcamper(updateBootcamper, newBootcamper);
                    if (update)
                        System.out.println("Bootcamper details updated");
                    else
                        System.out.println("Error updating Bootcamper details");
                    break;
                case "bootcampers":
                    ArrayList<Bootcamper> bootcampers = bootcampersList.getAttendanceList();
                    System.out.println("People attending the event:");
                    for (Bootcamper bootcamper1 : bootcampers) {
                        System.out.println(bootcamper1.getFirstName() + " " + bootcamper1.getLastName());
                    }
                    break;
                case "java":
                    ArrayList<Bootcamper> javaList = bootcampersList.getAttendanceListByLanguage(ProgrammingLanguage.Java);
                    System.out.println("People interested in Java:");
                    for (Bootcamper bootcamper1 : javaList) {
                        System.out.println(bootcamper1.getFirstName() + " " + bootcamper1.getLastName());
                    }
                    break;
                case "c++":
                    ArrayList<Bootcamper> cppList = bootcampersList.getAttendanceListByLanguage(ProgrammingLanguage.Cpp);
                    System.out.println("People interested in C++:");
                    for (Bootcamper bootcamper1 : cppList) {
                        System.out.println(bootcamper1.getFirstName() + " " + bootcamper1.getLastName());
                    }
                    break;
                case "python":
                    ArrayList<Bootcamper> pythonList = bootcampersList.getAttendanceListByLanguage(ProgrammingLanguage.Python);
                    System.out.println("People interested in Python:");
                    for (Bootcamper bootcamper1 : pythonList) {
                        System.out.println(bootcamper1.getFirstName() + " " + bootcamper1.getLastName());
                    }
                    break;
                case "waitlist":
                    ArrayList<Bootcamper> waitingList = bootcampersList.getWaitingList();
                    System.out.println("People on the waiting list:");
                    for (Bootcamper bootcamper1 : waitingList) {
                        System.out.println(bootcamper1.getFirstName() + " " + bootcamper1.getLastName());
                    }
                    break;
                case "available":
                    int availableSeats = bootcampersList.getAvailableSeats();
                    System.out.println("Number of available seats: " + availableSeats);
                    break;
                case "bootcampers_number":
                    int numberOfParticipants = bootcampersList.getNumberOfParticipants();
                    System.out.println("Number of people attending the event: " + numberOfParticipants);
                    break;
                case "waitlist_number":
                    int numberOfPeopleOnWaitingList = bootcampersList.getWaitingListNo();
                    System.out.println("Number of people on the waiting list: " + numberOfPeopleOnWaitingList);
                    break;
                case "subscribe_number":
                    int totalNumberOfPeople = bootcampersList.getNumberOfParticipants() + bootcampersList.getWaitingListNo();
                    System.out.println("Total number of people registered: " + totalNumberOfPeople);
                    break;
                case "search":
                    System.out.print("Enter the search string: ");
                    String searchQuery = scanner.nextLine();
                    ArrayList<Bootcamper> searchResults = bootcampersList.searchBySubstring(searchQuery);
                    System.out.println("Search results:");
                    for (Bootcamper bootcamper1 : searchResults) {
                        System.out.println(bootcamper1.getFirstName() + " " + bootcamper1.getLastName());
                    }
                    break;
                case "quit":
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }
}
