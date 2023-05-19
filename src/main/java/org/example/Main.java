package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static BootcampersList bootcampersList = new BootcampersList(50);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        showMenu();

        while (!quit) {
            System.out.print("Enter your command: ");
            String command = scanner.nextLine();
            switch (command.toLowerCase()) {
                case "help":
                    showMenu();
                    break;
                case "add":
                    addBootcamper(scanner, bootcampersList);
                    break;
                case "check":
                    checkBootcamper(scanner, bootcampersList);
                    break;
                case "remove":
                    removeBootcamper(scanner, bootcampersList);
                    break;
                case "update":
                    updateBootcamper(scanner, bootcampersList);
                    break;
                case "bootcampers":
                    listBootcampers(bootcampersList);
                    break;
                case "java":
                    listBootcampersByLanguage(bootcampersList, ProgrammingLanguage.Java);
                    break;
                case "c++":
                    listBootcampersByLanguage(bootcampersList, ProgrammingLanguage.Cpp);
                    break;
                case "python":
                    listBootcampersByLanguage(bootcampersList, ProgrammingLanguage.Python);
                    break;
                case "waitlist":
                    listWaitingList(bootcampersList);
                    break;
                case "available":
                    displayAvailableSeats(bootcampersList);
                    break;
                case "bootcampers_number":
                    displayNumberOfParticipants(bootcampersList);
                    break;
                case "waitlist_number":
                    displayNumberOfPeopleOnWaitingList(bootcampersList);
                    break;
                case "subscribe_number":
                    displayTotalNumberOfPeopleRegistered(bootcampersList);
                    break;
                case "search":
                    searchBootcampers(scanner, bootcampersList);
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

    private static void showMenu() {
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
    }

    private static void addBootcamper(Scanner scanner, BootcampersList bootcampersList) {
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
                return;
        }

        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Bootcamper bootcamper = new Bootcamper(firstName, lastName, programmingLanguage,
                new ArrayList<>(), email, phoneNumber);
        String result = bootcampersList.addBootcamper(bootcamper);
        System.out.println(result);
    }

    private static void checkBootcamper(Scanner scanner, BootcampersList bootcampersList) {
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
    }

    private static void removeBootcamper(Scanner scanner, BootcampersList bootcampersList) {
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
    }

    private static void updateBootcamper(Scanner scanner, BootcampersList bootcampersList) {
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
            return;
        }

        System.out.println("Enter the new details:");
        System.out.print("New First Name: ");
        String newFirstName = scanner.nextLine();
        System.out.print("New Last Name: ");
        String newLastName = scanner.nextLine();
        System.out.print("New Email: ");
        String newEmail = scanner.nextLine();
        System.out.print("New Programming Language: ");
        ProgrammingLanguage newProgrammingLanguage = ProgrammingLanguage.valueOf(scanner.nextLine());
        System.out.print("New Phone Number: ");
        String newPhoneNumber = scanner.nextLine();

        Bootcamper newBootcamper = new Bootcamper(newFirstName, newLastName,
                newProgrammingLanguage, new ArrayList<>(), newEmail, newPhoneNumber);

        boolean update = bootcampersList.updateBootcamper(updateBootcamper, newBootcamper);
        if (update) {
            System.out.println("Bootcamper details updated");
        } else {
            System.out.println("Error updating Bootcamper details");
        }
    }

    private static void listBootcampers(BootcampersList bootcampersList) {
        ArrayList<Bootcamper> bootcampers = bootcampersList.getAttendanceList();
        System.out.println("People attending the event:");
        for (Bootcamper bootcamper : bootcampers) {
            System.out.println(bootcamper.getFirstName() + " " + bootcamper.getLastName());
        }
    }

    private static void listBootcampersByLanguage(BootcampersList bootcampersList, ProgrammingLanguage language) {
        ArrayList<Bootcamper> languageList = bootcampersList.getAttendanceListByLanguage(language);
        System.out.println("People interested in " + language + ":");
        for (Bootcamper bootcamper : languageList) {
            System.out.println(bootcamper.getFirstName() + " " + bootcamper.getLastName());
        }
    }

    private static void listWaitingList(BootcampersList bootcampersList) {
        ArrayList<Bootcamper> waitingList = bootcampersList.getWaitingList();
        System.out.println("People on the waiting list:");
        for (Bootcamper bootcamper : waitingList) {
            System.out.println(bootcamper.getFirstName() + " " + bootcamper.getLastName());
        }
    }

    private static void displayAvailableSeats(BootcampersList bootcampersList) {
        int availableSeats = bootcampersList.getAvailableSeats();
        System.out.println("Number of available seats: " + availableSeats);
    }

    private static void displayNumberOfParticipants(BootcampersList bootcampersList) {
        int numberOfParticipants = bootcampersList.getNumberOfParticipants();
        System.out.println("Number of people attending the event: " + numberOfParticipants);
    }

    private static void displayNumberOfPeopleOnWaitingList(BootcampersList bootcampersList) {
        int numberOfPeopleOnWaitingList = bootcampersList.getWaitingListNo();
        System.out.println("Number of people on the waiting list: " + numberOfPeopleOnWaitingList);
    }

    private static void displayTotalNumberOfPeopleRegistered(BootcampersList bootcampersList) {
        int totalNumberOfPeople = bootcampersList.getNumberOfParticipants() + bootcampersList.getWaitingListNo();
        System.out.println("Total number of people registered: " + totalNumberOfPeople);
    }

    private static void searchBootcampers(Scanner scanner, BootcampersList bootcampersList) {
        System.out.print("Enter the search string: ");
        String searchQuery = scanner.nextLine();
        ArrayList<Bootcamper> searchResults = bootcampersList.searchBySubstring(searchQuery);
        System.out.println("Search results:");
        for (Bootcamper bootcamper : searchResults) {
            System.out.println(bootcamper.getFirstName() + " " + bootcamper.getLastName());
        }
    }
}
