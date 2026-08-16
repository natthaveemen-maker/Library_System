import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String bookId;
    String bookName;
    String borrower;
    boolean borrowed;

    Book(String bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.borrower = "";
        this.borrowed = false;
    }

    void showBook() {
        System.out.println("รหัสหนังสือ : " + bookId);
        System.out.println("ชื่อหนังสือ : " + bookName);

        if (borrowed) {
            System.out.println("สถานะ       : ถูกยืม");
            System.out.println("ผู้ยืม       : " + borrower);
        } else {
            System.out.println("สถานะ       : ว่าง");
        }

        System.out.println("----------------------------");
    }
}

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n===== ระบบจัดการรายการยืม-คืนหนังสือ =====");
            System.out.println("1. เพิ่มหนังสือ");
            System.out.println("2. แสดงรายการหนังสือ");
            System.out.println("3. ยืมหนังสือ");
            System.out.println("4. คืนหนังสือ");
            System.out.println("5. ค้นหาหนังสือ");
            System.out.println("6. ลบหนังสือ");
            System.out.println("7. แสดงจำนวนหนังสือ");
            System.out.println("8. ออกจากโปรแกรม");
            System.out.print("เลือกเมนู : ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // =========================
                // 1. เพิ่มหนังสือ
                // =========================
                case 1:

                    System.out.println("\n--- เพิ่มหนังสือ ---");

                    System.out.print("รหัสหนังสือ : ");
                    String id = sc.nextLine();

                    System.out.print("ชื่อหนังสือ : ");
                    String name = sc.nextLine();

                    books.add(new Book(id, name));

                    System.out.println("เพิ่มหนังสือเรียบร้อยแล้ว!");

                    break;

                // =========================
                // 2. แสดงรายการหนังสือ
                // =========================
                case 2:

                    System.out.println("\n--- รายการหนังสือทั้งหมด ---");

                    if (books.isEmpty()) {

                        System.out.println("ยังไม่มีหนังสือในระบบ");

                    } else {

                        for (Book book : books) {
                            book.showBook();
                        }
                    }

                    break;

                // =========================
                // 3. ยืมหนังสือ
                // =========================
                case 3:

                    System.out.println("\n--- ยืมหนังสือ ---");

                    System.out.print("กรอกรหัสหนังสือ : ");
                    String borrowId = sc.nextLine();

                    boolean borrowFound = false;

                    for (Book book : books) {

                        if (book.bookId.equals(borrowId)) {

                            borrowFound = true;

                            if (book.borrowed) {

                                System.out.println("หนังสือเล่มนี้ถูกยืมไปแล้ว");

                            } else {

                                System.out.print("ชื่อผู้ยืม : ");
                                String borrowerName = sc.nextLine();

                                book.borrower = borrowerName;
                                book.borrowed = true;

                                System.out.println("ยืมหนังสือเรียบร้อยแล้ว!");
                            }

                            break;
                        }
                    }

                    if (!borrowFound) {
                        System.out.println("ไม่พบรหัสหนังสือ");
                    }

                    break;

                // =========================
                // 4. คืนหนังสือ
                // =========================
                case 4:

                    System.out.println("\n--- คืนหนังสือ ---");

                    System.out.print("กรอกรหัสหนังสือ : ");
                    String returnId = sc.nextLine();

                    boolean returnFound = false;

                    for (Book book : books) {

                        if (book.bookId.equals(returnId)) {

                            returnFound = true;

                            if (book.borrowed) {

                                book.borrowed = false;
                                book.borrower = "";

                                System.out.println("คืนหนังสือเรียบร้อยแล้ว!");

                            } else {

                                System.out.println(
                                        "หนังสือเล่มนี้ไม่ได้ถูกยืม"
                                );
                            }

                            break;
                        }
                    }

                    if (!returnFound) {
                        System.out.println("ไม่พบรหัสหนังสือ");
                    }

                    break;

                // =========================
                // 5. ค้นหาหนังสือ
                // =========================
                case 5:

                    System.out.println("\n--- ค้นหาหนังสือ ---");

                    System.out.print("กรอกรหัสหนังสือ : ");
                    String searchId = sc.nextLine();

                    boolean searchFound = false;

                    for (Book book : books) {

                        if (book.bookId.equals(searchId)) {

                            book.showBook();

                            searchFound = true;

                            break;
                        }
                    }

                    if (!searchFound) {
                        System.out.println("ไม่พบหนังสือ");
                    }

                    break;

                // =========================
                // 6. ลบหนังสือ
                // =========================
                case 6:

                    System.out.println("\n--- ลบหนังสือ ---");

                    System.out.print("กรอกรหัสหนังสือ : ");
                    String deleteId = sc.nextLine();

                    boolean deleteFound = false;

                    for (int i = 0; i < books.size(); i++) {

                        if (books.get(i).bookId.equals(deleteId)) {

                            if (books.get(i).borrowed) {

                                System.out.println(
                                        "ไม่สามารถลบได้ เพราะหนังสือถูกยืมอยู่"
                                );

                            } else {

                                books.remove(i);

                                System.out.println(
                                        "ลบหนังสือเรียบร้อยแล้ว!"
                                );
                            }

                            deleteFound = true;

                            break;
                        }
                    }

                    if (!deleteFound) {
                        System.out.println("ไม่พบรหัสหนังสือ");
                    }

                    break;

                // =========================
                // 7. จำนวนหนังสือ
                // =========================
                case 7:

                    System.out.println("\n--- จำนวนหนังสือ ---");

                    System.out.println(
                            "มีหนังสือทั้งหมด : "
                                    + books.size()
                                    + " เล่ม"
                    );

                    break;

                // =========================
                // 8. ออกจากโปรแกรม
                // =========================
                case 8:

                    System.out.println(
                            "\nขอบคุณที่ใช้บริการระบบห้องสมุด"
                    );

                    break;

                default:

                    System.out.println(
                            "กรุณาเลือกเมนู 1-8"
                    );
            }

        } while (choice != 8);

        sc.close();
    }
}