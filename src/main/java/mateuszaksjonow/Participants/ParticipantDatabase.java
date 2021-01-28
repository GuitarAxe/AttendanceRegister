package mateuszaksjonow.Participants;

import java.util.LinkedList;
import java.util.Scanner;

public class ParticipantDatabase {

    LinkedList<Participant> listOfParticipants = new LinkedList<>();

    public void addParticipant(Scanner scanner) {
        System.out.println("Add participant:");

        System.out.println("Enter name:");
        String name = scanner.next();
        scanner.nextLine();
        System.out.println("Enter last name:");
        String surname = scanner.next();
        scanner.nextLine();
        System.out.println("Enter date of birth:");
        String dateOfBirth = scanner.next();
        scanner.nextLine();
        System.out.println("Enter telephone number:");
        String telephoneNumber = scanner.next();

        Participant participant = new Participant(name, surname, dateOfBirth, telephoneNumber);

        boolean alreadyExist = listOfParticipants.contains(participant);
        if (!alreadyExist) {
            listOfParticipants.add(participant);
        }else {
            System.out.println("Already exists");
        }
    }

    public LinkedList<Participant> getListOfParticipants() {
        return listOfParticipants;
    }

    public Participant getParticipant(int index) {
        return listOfParticipants.get(index);
    }
}
