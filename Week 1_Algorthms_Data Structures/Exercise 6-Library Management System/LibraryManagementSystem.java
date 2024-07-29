class Book {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = title.compareTo(books[mid].title);
            if (res == 0)
                return books[mid];
            if (res > 0)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("B001", "Java Programming", "Author A"),
                new Book("B002", "Data Structures", "Author B"),
                new Book("B003", "Algorithms", "Author C"),
        };

        // Sort books array by title for binary search
        java.util.Arrays.sort(books, (b1, b2) -> b1.title.compareTo(b2.title));

        Book foundBook = linearSearch(books, "Data Structures");
        if (foundBook != null) {
            System.out.println("Book found using linear search: " + foundBook.title);
        } else {
            System.out.println("Book not found using linear search.");
        }

        foundBook = binarySearch(books, "Data Structures");
        if (foundBook != null) {
            System.out.println("Book found using binary search: " + foundBook.title);
        } else {
            System.out.println("Book not found using binary search.");
        }
    }
}
