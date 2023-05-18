import java.util.ArrayList;

public class Bootcamper {
    private String firstName;
    private String lastName;
    private ProgrammingLanguage programmingLanguage;
    private ArrayList<String> certificates = new ArrayList<>(0);
    private String email;
    private String phoneNumber;

    public Bootcamper(String firstName, String lastName, ProgrammingLanguage programmingLanguage,
                      ArrayList<String> certificates, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.programmingLanguage = programmingLanguage;
        this.certificates = certificates;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ProgrammingLanguage getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public ArrayList<String> getCertificates() {
        return certificates;
    }

    public void setCertificates(ArrayList<String> certificates) {
        this.certificates = certificates;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Bootcamper{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", programmingLanguage=" + programmingLanguage +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
