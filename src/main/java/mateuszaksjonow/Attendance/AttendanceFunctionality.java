package mateuszaksjonow.Attendance;

import mateuszaksjonow.Participants.Participant;
import mateuszaksjonow.Participants.ParticipantDatabase;

import java.util.*;

public class AttendanceFunctionality {

    List<AttendanceEntries> listOfAttendance = new LinkedList<>();
    int iterator;

    public void addAttendance(Scanner scanner, ParticipantDatabase participantDatabase) {
        System.out.println("Add new attendance entry:");

        System.out.println("Add date:");
        String date = scanner.next();
        scanner.nextLine();
        System.out.println("Add subject:");
        String subject = scanner.next();
        scanner.nextLine();

        AttendanceEntries attendanceEntries = new AttendanceEntries(date, subject);

        System.out.println("Select participants");
        int iter = 0;
        for (Participant participant : participantDatabase.getListOfParticipants()) {
            iter++;
            System.out.println(iter + ": " + participant.getFirstName() + " " + participant.getLastName());
        }

        boolean quit = false;
        System.out.println("Type number of persons you want to add" +
                "\n Type 0 to end");
        while (!quit) {
            int choice = scanner.nextInt();

            if (choice != 0) {
                attendanceEntries.getParticipantMap().put(participantDatabase.getParticipant(choice-1), false);
            }else {
                quit = true;
            }
        }

        listOfAttendance.add(attendanceEntries);
    }

    public void checkAttendance(Scanner scanner) {
        iterator = 0;

        try {
            System.out.println("Select entry");
            if (listOfAttendance.isEmpty()) {
                System.out.println("No entries");
            } else {
                printListOfAttendance(iterator);

                int choice = scanner.nextInt();
                scanner.nextLine();
                Map<Participant, Boolean> chosenMap = listOfAttendance.get(choice).getParticipantMap();

                int personNumber = 0;
                for (Map.Entry<Participant, Boolean> entry : chosenMap.entrySet()) {
                    personNumber++;
                    System.out.println(personNumber + ": " + entry.getKey().getFirstName() + " " + entry.getKey().getLastName());
                    System.out.println("Type true if attended, type false if absent:");
                    if (scanner.next().equalsIgnoreCase("true")) {
                        entry.setValue(true);
                    } else if (scanner.next().equalsIgnoreCase("false")) {
                        entry.setValue(false);
                    } else {
                        System.out.println("Wrong command");
                    }
                    scanner.nextLine();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("oops");
        }
    }

    public void changeSingleAttendance(Scanner scanner) {
        iterator = 0;

        try {
            System.out.println("Select entry");
            if (listOfAttendance.isEmpty()) {
                System.out.println("No entries");
            } else {
                printListOfAttendance(iterator);

                int choice = scanner.nextInt();
                scanner.nextLine();
                Map<Participant, Boolean> chosenMap = listOfAttendance.get(choice).getParticipantMap();

                int personNumber = 0;
                System.out.println("Select person: ");
                for (Map.Entry<Participant, Boolean> entry : chosenMap.entrySet()) {
                    System.out.println(personNumber + ": " + entry.getKey().getFirstName() + " " + entry.getKey().getLastName());
                }

                personNumber = scanner.nextInt();
                scanner.next();

                int iter = 0;
                for (Map.Entry<Participant, Boolean> entry : chosenMap.entrySet()) {
                    if (iter == personNumber) {
                        System.out.println("Set attendance" +
                                "\n Type true if attended" +
                                "\n Type false if absent");
                        String decision = scanner.next();
                        scanner.nextLine();
                        if (decision.equalsIgnoreCase("true")) {
                            chosenMap.replace(entry.getKey(), true);
                        }else if (decision.equalsIgnoreCase("false")) {
                            chosenMap.replace(entry.getKey(), false);
                        }else {
                            System.out.println("Wrong command!");
                        }
                    }
                    iter++;
                }

            }
        } catch (InputMismatchException e) {
            System.out.println("oops");
        }
    }

    public void displayAttendance() {
        iterator = 0;
        int personNumber = 0;

        try {
            System.out.println("Select entry");
            if (listOfAttendance.isEmpty()) {
                System.out.println("No entries");
            } else {
                printListOfAttendance(iterator);

                for (AttendanceEntries attendanceEntries : listOfAttendance) {
                    Map<Participant, Boolean> chosenMap = attendanceEntries.getParticipantMap();

                    for (Map.Entry<Participant, Boolean> entry : chosenMap.entrySet()) {
                        personNumber++;
                        System.out.println("    " + personNumber + ": " + entry.getKey().getFirstName() + " " + entry.getValue());
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("oops");
        }
    }

    public void displayAbsentParticipants() {
        iterator = 0;
        int personNumber = 0;

        try {
            System.out.println("Entries:");
            if (listOfAttendance.isEmpty()) {
                System.out.println("No entries");
            } else {
                printListOfAttendance(iterator);

                System.out.println("Absent participants:");
                for (AttendanceEntries attendanceEntries : listOfAttendance) {
                    Map<Participant, Boolean> chosenMap = attendanceEntries.getParticipantMap();

                    for (Map.Entry<Participant, Boolean> entry : chosenMap.entrySet()) {
                        personNumber++;
                        if (!entry.getValue()) {
                            System.out.println(personNumber + ": " + entry.getKey().getFirstName() +
                                    " " + entry.getKey().getLastName() +
                                    " " + entry.getKey().getDateOfBirth() +
                                    " " + entry.getKey().getTelephoneNumber());
                        }
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("oops");
        }
    }

    public void printListOfAttendance(int iterator) {
        for (AttendanceEntries entry : listOfAttendance) {
            System.out.println(iterator + ": " + entry.getDate() + " " + entry.getSubject());
            iterator++;
        }
    }

}
