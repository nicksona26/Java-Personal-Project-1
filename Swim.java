import java.util.*;

public class SwimSchedules {
    static String[][] jeff = {{"_","_","_","_"},
            {"_","_","_","_"},
            {"_","_","_","_"},
            {"_","_","_","_"}};

    static String[][] anna = {{"_","_","_","_"},
            {"_","_","_","_"},
            {"_","_","_","_"},
            {"_","_","_","_"}};

    static String[][] ind = {{"I","_","I","_"},
            {"_","I","_","_"},
            {"_","_","I","I"},
            {"_","_","_","I"}};

    static String[][] group = {{"_","G","G","_"},
            {"G","_","_","G"},
            {"_","G","_","_"},
            {"G","G","_","G"}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            pMenu();
            String input = scanner.nextLine();

            switch (input) {
                case "p":
                    pScheds();
                    break;
                case "s":
                    String[] selection = select();
                    edit(selection, input);
                    break;
                case "f":
                    String[] selection2 = select();
                    edit(selection2, input);
                    break;
                case "i":
                    pSched(ind);
                    break;
                case "g":
                    pSched(group);
                    break;
                case "q":
                    return;
                default:
                    System.out.println("Invalid command, try again");
            }
        }
    }

    public static void pMenu() {
        System.out.println(" ");
        System.out.println("Enter one of the following commands:");
        System.out.println("p - Print schedules");
        System.out.println("s - Schedule a slot");
        System.out.println("f - Free a slot");
        System.out.println("i - Show slots available for individual lessons");
        System.out.println("g - Show slots available for group lessons");
        System.out.println("q - Quit");
    }

    public static void pScheds() {
        System.out.println("Jeff:");
        pSched(jeff);
        System.out.println(" ");
        System.out.println("Anna:");
        pSched(anna);
        System.out.println(" ");
    }

    public static void pSched(String[][] sched) {
        String[] times = {"11-12","12-1","1-2","2-3"};

        System.out.printf("%-6s%-4s%-4s%-4s%-4s\n", " ", "Mon", "Tue", "Wed", "Thu");

        for (int i = 0; i < sched.length; i++) {
            String time = times[i];
            System.out.printf("%-6s",time);
            for (int j = 0; j < sched[i].length; j++) {
                System.out.print(sched[i][j] + "   ");
            }
            System.out.println();
        }
    }


    public static String[] select() {
        String[] selection = new String[3];
        Scanner scanner = new Scanner(System.in);

        // select instructor
        System.out.println("Select instructor (1 - Jeff, 2 - Anna):");
        int instructor = scanner.nextInt();

        if (instructor != 1 && instructor != 2) {
            System.out.println("Invalid instructor, try again.");
        }

        if (instructor == 1) {
            selection[0] = "Jeff";
        } else {
            selection[0] = "Anna";
        }

        // select day
        System.out.println("Select Day (1 - Mon, 2 - Tue, 3 - Wed, 4 - Thu):");
        int day = scanner.nextInt();
        if (day < 1 || day > 4) {
            System.out.println("Invalid day, try again.");
        }

        if (day == 1) {
            selection[1] = "Mon";
        } else if (day == 2) {
            selection[1] = "Tue";
        } else if (day == 3) {
            selection[1] = "Wed";
        } else {
            selection[1] = "Thu";
        }

        // select slot
        System.out.println("Select Slot (1 - 11-12, 2 - 12-1, 3 - 1-2, 4 - 2-3):");
        int slot = scanner.nextInt();
        if (slot < 1 || slot > 4) {
            System.out.println("Invalid slot, try again.");
        }

        if (slot == 1) {
            selection[2] = "11-12";
        } else if (slot == 2) {
            selection[2] = "12-1";
        } else if (slot == 3) {
            selection[2] = "1-2";
        } else if (slot == 4) {
            selection[2] = "2-3";
        }

        return selection;
    }


    public static void edit(String[] selection, String choice) {
        int day = 0;
        int slot = 0;

        if (selection[1].equals("Mon")) {
            day = 0;
        } else if (selection[1].equals("Tue")) {
            day = 1;
        } else if (selection[1].equals("Wed")) {
            day = 2;
        } else if (selection[1].equals("Thur")) {
            day = 3;
        }

        if (selection[2].equals("11-12")) {
            slot = 0;
        } else if (selection[2].equals("12-1")) {
            slot = 1;
        } else if (selection[2].equals("1-2")) {
            slot = 2;
        } else if (selection[2].equals("2-3")) {
            slot = 3;
        }

        if (choice.equals("s")) {
            if (selection[0].equals("Jeff")) {
                jeff[day][slot] = "X";
            } else if (selection[0].equals("Anna")) {
                anna[day][slot] = "X";
            }
        } else {
            if (selection[0].equals("Jeff")) {
                jeff[day][slot] = "_";
            } else if (selection[0].equals("Anna")) {
                anna[day][slot] = "_";
            }

        }
    }

}
