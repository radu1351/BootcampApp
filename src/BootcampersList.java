import java.util.ArrayList;
import java.util.Iterator;

public class BootcampersList {
    private ArrayList<Bootcamper> participants = new ArrayList<>(0);
    private ArrayList<Bootcamper> waitingList = new ArrayList<>(0);
    private int noParticipants;

    public BootcampersList(int noParticipants) {
        this.noParticipants = noParticipants;
    }

    public String addBootcamper(Bootcamper bootcamper) {

        if (isRegistered(bootcamper)) return "Registered";

        if (participants.size() >= noParticipants) {
            waitingList.add(bootcamper);
            System.out.println("Congratulations! Your place at the Bootcamp is confirmed. " +
                    "We are waiting for you!");
            return "Succes";
        } else {
            participants.add(bootcamper);
            System.out.println("You have successfully registered on the waiting list " +
                    "and received the order number " + participants.size() + " ." +
                    "We will notify you if a place becomes available.");
            return "Your number on the waiting list is: "
                    + participants.size();
        }
    }

    public boolean isRegistered(Bootcamper bootcamper) {
        for (Bootcamper bootcamper1 : participants)
            if (bootcamper1.getFirstName().equals(bootcamper.getFirstName()) &&
                    bootcamper1.getLastName().equals(bootcamper.getLastName()) &&
                    bootcamper1.getEmail().equals(bootcamper.getEmail()))
                return true;
        for (Bootcamper bootcamper1 : waitingList)
            if (bootcamper1.getFirstName().equals(bootcamper.getFirstName()) &&
                    bootcamper1.getLastName().equals(bootcamper.getLastName()) &&
                    bootcamper1.getEmail().equals(bootcamper.getEmail()))
                return true;
        return false;
    }

    public boolean removeBootcamper(Bootcamper bootcamper) {
        Iterator<Bootcamper> iterator = participants.iterator();
        while (iterator.hasNext()) {
            Bootcamper bootcamper1 = iterator.next();
            if (bootcamper1.getFirstName().equals(bootcamper.getFirstName()) &&
                    bootcamper1.getLastName().equals(bootcamper.getLastName()) &&
                    bootcamper1.getEmail().equals(bootcamper.getEmail())) {
                iterator.remove();
                return true;
            }
        }
        iterator = waitingList.iterator();
        while (iterator.hasNext()) {
            Bootcamper bootcamper1 = iterator.next();
            if (bootcamper1.getFirstName().equals(bootcamper.getFirstName()) &&
                    bootcamper1.getLastName().equals(bootcamper.getLastName()) &&
                    bootcamper1.getEmail().equals(bootcamper.getEmail())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean updateBootcamper(Bootcamper updateBootcamper, Bootcamper newBootcamper) {
        if (isRegistered(updateBootcamper)) {
            for (int i = 0; i < participants.size(); i++) {
                Bootcamper participant = participants.get(i);
                if (participant.getFirstName().equals(updateBootcamper.getFirstName()) &&
                        participant.getLastName().equals(updateBootcamper.getLastName()) &&
                        participant.getEmail().equals(updateBootcamper.getEmail())) {
                    participants.set(i, newBootcamper);
                    return true;
                }
            }
            for (int i = 0; i < waitingList.size(); i++) {
                Bootcamper waitingParticipant = waitingList.get(i);
                if (waitingParticipant.getFirstName().equals(updateBootcamper.getFirstName()) &&
                        waitingParticipant.getLastName().equals(updateBootcamper.getLastName()) &&
                        waitingParticipant.getEmail().equals(updateBootcamper.getEmail())) {
                    waitingList.set(i, newBootcamper);
                    return true;
                }
            }
        }
        return false;
    }


    public ArrayList<Bootcamper> getParticipants() {
        return this.participants;
    }

    public ArrayList<Bootcamper> getAttendanceList() {
        return participants;
    }

    public ArrayList<Bootcamper> getAttendanceListByLanguage(ProgrammingLanguage language) {
        ArrayList<Bootcamper> languageList = new ArrayList<>();
        for (Bootcamper bootcamper : participants) {
            if (bootcamper.getProgrammingLanguage() == language) {
                languageList.add(bootcamper);
            }
        }
        return languageList;
    }

    public ArrayList<Bootcamper> getWaitingList() {
        return waitingList;
    }

    public int getAvailableSeats() {
        return noParticipants - participants.size();
    }

    public int getNumberOfParticipants() {
        return participants.size();
    }

    public int getWaitingListNo() {
        return waitingList.size();
    }


    public ArrayList<Bootcamper> searchBySubstring(String substring) {
        ArrayList<Bootcamper> searchResults = new ArrayList<>();
        String lowercaseSubstring = substring.toLowerCase();

        for (Bootcamper bootcamper : participants) {
            if (bootcamper.getFirstName().toLowerCase().contains(lowercaseSubstring)
                    || bootcamper.getLastName().toLowerCase().contains(lowercaseSubstring)
                    || bootcamper.getEmail().toLowerCase().contains(lowercaseSubstring)) {
                searchResults.add(bootcamper);
            }
        }

        for (Bootcamper bootcamper : waitingList) {
            if (bootcamper.getFirstName().toLowerCase().contains(lowercaseSubstring)
                    || bootcamper.getLastName().toLowerCase().contains(lowercaseSubstring)
                    || bootcamper.getEmail().toLowerCase().contains(lowercaseSubstring)) {
                searchResults.add(bootcamper);
            }
        }
        return searchResults;
    }
}
