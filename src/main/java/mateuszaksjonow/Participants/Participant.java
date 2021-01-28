package mateuszaksjonow.Participants;

public class Participant {

    private static int id = 0;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String telephoneNumber;

    public Participant(String firstName, String lastName, String dateOfBirth, String telephoneNumber) {
        id = id++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.telephoneNumber = telephoneNumber;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Participant.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public int hashCode() {
        return 17 * id + 31 * firstName.hashCode() + 7 * lastName.hashCode() + 3 * dateOfBirth.hashCode() + 13 * telephoneNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
