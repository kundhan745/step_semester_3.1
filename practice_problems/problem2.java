import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanPeriod();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26).plusDays(getLoanPeriod());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getLoanPeriod() {
        return 3;
    }
}

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            switch (type.toUpperCase()) {
                case "BOOK":
                    items[i] = new Book(title);
                    break;
                case "DVD":
                    items[i] = new DVD(title);
                    break;
                case "MAGAZINE":
                    items[i] = new Magazine(title);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid item type");
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

        for (LibraryItem item : items) {
            System.out.println(
                    item.title + ": " + item.getDueDate().format(formatter)
            );
        }

        sc.close();
    }
}