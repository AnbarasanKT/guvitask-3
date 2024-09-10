import java.util.Scanner;
public class OopPrinciple {


    static class Book {
        private int bookId;
        private String title;
        private String author;
        private boolean isAvailable;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        @Override
        public String toString() {
            return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
        }
    }

    static class Library {
        private Book[] books;
        private int count;

        public Library(int capacity) {
            books = new Book[capacity];
            count = 0;
        }

        public void addBook(Book book) {
            if (count < books.length) {
                books[count++] = book;
                System.out.println("Book added: " + book);
            } else {
                System.out.println("Library is full. Cannot add more books.");
            }
        }

        public void removeBook(int bookId) {
            for (int i = 0; i < count; i++) {
                if (books[i].getBookId() == bookId) {
                    System.out.println("Removing book: " + books[i]);
                    books[i] = books[count - 1];
                    books[count - 1] = null;
                    count--;
                    return;
                }
            }
            System.out.println("Book not found.");
        }

        public Book searchBook(int bookId) {
            for (int i = 0; i < count; i++) {
                if (books[i].getBookId() == bookId) {
                    return books[i];
                }
            }
            return null;
        }

        public void displayBooks() {
            if (count == 0) {
                System.out.println("No books in the library.");
                return;
            }
            for (int i = 0; i < count; i++) {
                System.out.println(books[i]);
            }
        }
    }

    public class LibraryManagementSystem {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Library library = new Library(10);
            int choice;

            do {
                System.out.println("1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Search Book");
                System.out.println("4. Display Books");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(id, title, author));
                        break;
                    case 2:
                        System.out.print("Enter Book ID to remove: ");
                        int removeId = scanner.nextInt();
                        library.removeBook(removeId);
                        break;
                    case 3:
                        System.out.print("Enter Book ID to search: ");
                        int searchId = scanner.nextInt();
                        Book foundBook = library.searchBook(searchId);
                        if (foundBook != null) {
                            System.out.println("Found: " + foundBook);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;
                    case 4:
                        library.displayBooks();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);

            scanner.close();
        }
    }

