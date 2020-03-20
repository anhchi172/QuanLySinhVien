import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class StudentTester {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        StudentManager s = new StudentManager();
        int act;
        do {
            System.out.println("Chon: \n1.Add student" +
                    "\n2.Edit student" +
                    "\n3.Delete student" +
                    "\n4.Sort student" +
                    "\n5.Show Student" +
                    "\n6.Exit");
            act = checkInput(1, 6);
            if (act == 1) {
                Student n = nhap();
                s.addStudent(n);
            } else if (act == 2) {
                System.out.print("Nhap id: ");
                int id = checkInput(1, Integer.MAX_VALUE);
                Student old = s.findStudentById(id);

                System.out.println("Nhap lai thong tin can thay doi: ");
                Student n = nhap();

                s.editStudent(id, n);

            } else if (act == 3) {
                System.out.print("Nhap id: ");
                int id = checkInput(1, Integer.MAX_VALUE);
                s.deleteStudent(id);
            }
            else if (act == 4) {
                System.out.println("Chon: \n1.Sort by Name" +
                        "\n2.Sort by GPA" );
                int choice = checkInput(1,2);
                if (choice == 1) {
                    s.sortStudent("name");
                }
                else {
                    s.sortStudent("gpa");
                }
            }

            else if (act == 5) {
                s.showStudent();
            }
        }while (act!=6);
        s.exit();
    }


    private static Student nhap() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap id: ");
        int id = checkInput(1, Integer.MAX_VALUE);
        System.out.print("Nhap ten: ");
        String hoTen = scan.nextLine();
        System.out.print("Nhap tuoi: ");
        int tuoi = checkInput(1, Integer.MAX_VALUE);
        System.out.print("Nhap dia chi: ");
        String diaChi = scan.nextLine();
        System.out.print("Nhap gpa: ");
        int gpa = checkInput(1, 100);
        Student n = new Student(id, hoTen, tuoi, diaChi, gpa);
        return n;
    }


    private static int checkInput(int a, int b) {
        Scanner scan = new Scanner(System.in);
        try {
            int choice = scan.nextInt();

            while (choice < a || choice > b) {
                System.out.println("Du lieu nhap khong phu hop voi yeu cau. Vui long nhap lai:");
                choice = scan.nextInt();
            }


            return choice;
        } catch (Exception e) {
            System.out.println("Du lieu nhap khong phu hop voi yeu cau. Vui long nhap lai:");
            return checkInput(a, b);
        }
    }
}







