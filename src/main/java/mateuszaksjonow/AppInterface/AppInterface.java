package mateuszaksjonow.AppInterface;

import mateuszaksjonow.Attendance.AttendanceFunctionality;
import mateuszaksjonow.Participants.ParticipantDatabase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppInterface {

    private final ParticipantDatabase participantDatabase = new ParticipantDatabase();
    private final AttendanceFunctionality attendanceDatabase = new AttendanceFunctionality();
    private boolean quit = false;
    private final Scanner scanner = new Scanner(System.in);


    public void run() {

        while (!quit) {
            try {
                menuInstructions();
                switch (scanner.nextInt()) {
                    case 1:
                        participantDatabase.addParticipant(scanner);
                        break;
                    case 2:
                        attendanceDatabase.addAttendance(scanner, participantDatabase);
                        break;
                    case 3:
                        attendanceDatabase.checkAttendance(scanner);
                        break;
                    case 4:
                        attendanceDatabase.changeSingleAttendance(scanner);
                        break;
                    case 5:
                        attendanceDatabase.displayAttendance();
                        break;
                    case 6:
                        attendanceDatabase.displayAbsentParticipants();
                        break;
                    case 7:

                        break;
                    case 0:
                        quit = true;
                        break;
                }
            }catch (InputMismatchException e) {
//                e.printStackTrace();
                System.out.println("Wrong input. Try again!");
            }catch (Exception e) {
//                e.printStackTrace();
                System.out.println("Something went wrong, try again.");
            }finally {
                scanner.nextLine();
            }
        }
    }

    public void menuInstructions() {
        System.out.println("Welcome!" +
                "\n 1: Add new participant" +
                "\n 2: Add new attendance entry" +
                "\n 3: Check attendance. Mark Present or Absent" +
                "\n 4: Edit attendance of an individual participant in a given date" +
                "\n 5: Display attendance" +
                "\n 6: Display all absent participants" +
                "\n 7: Save program data" +
                "\n 0: Exit ");
    }
}
