package problem2.management;

import problem2.dao.TraineeDAO;
import problem2.entities.Trainee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;


public class TraineeManagement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TraineeDAO traineeDAO = new TraineeDAO();



        boolean flag = true;
        do {
            System.out.println("\n------- FA System -------");
            System.out.println("1. Create Trainee");
            System.out.println("2. Update Trainee");
            System.out.println("3. Remove a specific Trainee");
            System.out.println("4. Report incompleted training");
            System.out.println("5. List excellent trainees");
            System.out.println("6. Exit");

            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("------------------------------");

            switch (choice) {
                case 1:
                    Trainee trainee = new Trainee();
                    System.out.println("------------Create Trainee------------");
                    System.out.println("Enter account: ");
                    trainee.setAccount(scanner.nextLine());
                    System.out.println("Enter full name: ");
                    trainee.setFullName(scanner.nextLine());
                    String input;
                    boolean check = true;
                    System.out.println("Enter gender: ");
                    do {
                        input = scanner.nextLine();
                        if(input.equals("0") || input.equals("1")){
                            check = false;
                        }else{
                            System.out.println("Wrong! Enter gender again: ");
                        }
                    } while (check);
                    trainee.setGender(Byte.parseByte(input));
                    System.out.println("Enter date of birth: ");
                    try {
                        trainee.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Enter phone number: ");
                    trainee.setPhoneNumber(scanner.nextLine());
                    System.out.println("Enter gpa: ");
                    trainee.setGpa(scanner.nextLine());
                    if (traineeDAO.save(trainee)) {
                        System.out.println("Save Successfully !");
                    } else {
                        System.out.println("Save Fail !");
                    }
                    break;
                case 2:
                    Trainee trainee1 = new Trainee();
                    System.out.println("------------Update Trainee------------");
                    System.out.println("Enter account: ");
                    trainee1.setAccount(scanner.nextLine());
                    System.out.println("Enter full name: ");
                    trainee1.setFullName(scanner.nextLine());
                    String input1 = null;
                    boolean check1 = true;
                    System.out.println("Enter gender: ");
                    do {
                        input = scanner.nextLine();
                        if(input.equals("0") || input.equals("1")){
                            check1 = false;
                        }else{
                            System.out.println("Wrong! Enter gender again: ");
                        }
                    } while (check1);
                    trainee1.setGender(Byte.parseByte(input));

                    System.out.println("Enter date of birth: ");

                        try {
                            trainee1.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    System.out.println("Enter phone number: ");
                    trainee1.setPhoneNumber(scanner.nextLine());
                    System.out.println("Enter gpa: ");
                    trainee1.setGpa(scanner.nextLine());
                    System.out.println("Enter status: ");
                    check1 = true;
                    do {
                        input = scanner.nextLine();
                        if(input.equals("active") || input.equals("in-active")){
                            check1 = false;
                        }else{
                            System.out.println("Wrong! Enter status again: ");
                        }
                    } while (check1);
                    trainee1.setStatus(input);
                    if (traineeDAO.update(trainee1)) {
                        System.out.println("Update Successfully !");
                    } else {
                        System.out.println("Update Fail !");
                    }
                    break;
                case 3:
                    System.out.println("------------Remove Trainee------------");
                    if (traineeDAO.remove()) {
                        System.out.println("Remove Successfully !");
                    } else {
                        System.out.println("Remove Fail !");
                    }
                    break;
                case 4:
                    System.out.println("------------Report incompleted training------------");
                    List<Trainee> list = traineeDAO.findIncompletedTrainee();
                    for (Trainee trainee2 : list) {
                        System.out.println(trainee2);
                    }
                    break;
                case 5:
                    System.out.println("------------List excellent trainees------------");
                    List<Trainee> list1 = traineeDAO.findExcellentTrainee();
                    for (Trainee trainee2 : list1) {
                        System.out.println(trainee2);
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Only choose 1 - 6.");
            }
        } while (flag);
    }
}
