import java.util.Scanner;

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Object[][] books = new Object[2][4];
        int secim;
        do {
            System.out.print("1. Kitap Ekle\n2. Kitap Listele\n3. Kitap Kirala\n4. Kitap İade Et\n0. Çıkış\nLütfen Yapmak İstediğiniz İşlemi Seçiniz: ");
            switch (secim = scanner.nextInt()) {
                case 1:
                    ekle(books);
                    break;
                case 2:
                    listele(books);
                    break;
                case 3:
                    kiralama(books);
                    break;
                case 4:
                    iade(books);
                    break;
                case 0:
                    System.out.println("Program Sonlandı");
                    break;
                default:
                    System.out.println("Lüttfen 0 ile 4 arasında bir sayı giriniz");
                    break;
            }
            System.out.println("-".repeat(50));
        } while (secim != 0);
    }

    private static void listele(Object[][] books) {
        int index = ilkBosIndex(books);
        if (index != -1) {

        }
        System.out.println("ID\t\t\t\t\tAd\t\t\t\t\tYazar\t\t\t\t\tKira Durumu");
        for (Object[] book: books) {
            System.out.println(book[0] + "\t\t\t\t\t" + book[1] + "\t\t\t\t\t" + book[2] + "\t\t\t\t\t" + book[3]);
        }
    }

    private static void ekle(Object[][] books) {
        Scanner scanner = new Scanner(System.in);
        int index = ilkBosIndex(books);
        if (index != -1) {
            System.out.println("Kitap Ekle");
            System.out.print("Id= ");
            books[index][0] = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Ad= ");
            books[index][1] = scanner.nextLine();
            System.out.print("Yazar= ");
            books[index][2] = scanner.nextLine();
            System.out.print("Kiralama Durumu(0/1)= ");
            books[index][3] = scanner.nextInt() == 1;
        } else {
            System.out.println("Kitaplık Dolu");
        }
    }

    private static void kiralama(Object[][] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kiralamak istenilen kitabın id'sini giriniz: ");
        int id = scanner.nextInt();
        boolean isFound = false;
        for (Object[] book: books) {
            if (book[0] != null && ((Integer) book[0]) == id) {
                if (!((Boolean) book[3])) {
                    book[3] = true;
                    System.out.println("Kitap kiralandı");
                } else {
                    System.out.println("Kitap zaten kirada");
                }
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Kitap Bulunamadı");
        }
    }

    private static void iade(Object[][] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("İade edilmek istenilen kitabın id'sini giriniz: ");
        int id = scanner.nextInt();
        boolean isFound = false;
        for (Object[] book: books) {
            if (book[0] != null && ((Integer) book[0]) == id) {
                if (((Boolean) book[3])) {
                    book[3] = false;
                    System.out.println("Kitap iade edildi");
                } else {
                    System.out.println("Kitap zaten mevcut");
                }
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Kitap Bulunamadı");
        }
    }

    private static int ilkBosIndex(Object[][] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i][0] == null) {
                return i;
            }
        }
        return -1;
    }
}
