import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book
{
    private String id;
    private String title;
    private String author;
    private String ISBN;

    //Default Constructor
    Book()
    {}

    Book(String id, String title, String author, String ISBN)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    public String toString() {
        return "Id : " + id + " Title : " + title + " Author : " + author;
    }

    public String getId(){return this.id;}

    public void setId(String id)
    {
        this.id = id;
    }
}


class BookService
{
    private List<Book> bookList = new ArrayList<Book>();



    public void addBook(Book book)
    {
        bookList.add(book);
    }

    public void displayAllBooks()
    {
        for (Book book : bookList)
        {
            System.out.println(book);
        }
    }

    public void searchByID(Scanner in) {
        System.out.print("Enter (#) to search :: ");
        String id = in.nextLine();

        Book bookFound = null;

        for (Book book : bookList)
        {
            if (book.getId().equals(id))
            {
                bookFound = book;
                break;
            }
        }

        if (bookFound != null) {
            System.out.println(bookFound);
        } else {
            System.out.println("Sorry, your Id is not valid.");
        }
    }

    public void updateById(Scanner in)
    {

        System.out.print("Enter (#) to update :: "); String id = in.nextLine();

        Book bookUpdated = null;
        int flag = 0;

        for (int i = 0; i < bookList.size(); i++)
        {
            Book temp = bookList.get(i);
            if (temp.getId().equals(id))
            {
                System.out.print("Enter New Title  :: "); String title = in.nextLine();
                System.out.print("Enter New Author :: "); String author = in.nextLine();
                System.out.print("Enter New ISBN   :: "); String isbn = in.nextLine();

                bookUpdated = new Book(id, title, author, isbn);
                flag = i;

                break;
            }
        }
        if (bookUpdated != null)
        {
            System.out.println("You hava updated successfully.");
            bookList.set(flag, bookUpdated);
        }else {
            System.out.println("Your ID is invalid. Please try to enter the correct ID.");
        }
    }

    public void deleteById(Scanner in)
    {
        System.out.print("Enter (#) to delete :: "); String id = in.nextLine();
        Book bookDeleted = null;

        for (int i = 0; i < bookList.size(); i++)
        {
            Book tmp = bookList.get(i);
            if (tmp.getId().equals(id))
            {
                bookDeleted = tmp;
                break;
            }
        }
        if (bookDeleted != null)
        {
            System.out.println("Your have deleted successfully.");
            bookList.remove(bookDeleted);
        }else {
            System.out.println("Your Id is invalid!");
        }
    }
}



public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        BookService bookService = new BookService();

        boolean programOn = true;
        int userOpt = 0;


        while (programOn)
        {
            menu();
            System.out.println("Please choose option above :: "); userOpt = in.nextInt(); in.nextLine();
            switch (userOpt)
            {
                case 1:
                {
                    System.out.print("Enter ID     ::"); String id = in.nextLine();
                    System.out.print("Enter Title  :: "); String title = in.nextLine();
                    System.out.print("Enter Author :: "); String author = in.nextLine();
                    System.out.print("Enter ISBN   :: "); String isbn = in.nextLine();

                    Book newBook = new Book(id,title,author,isbn);
                    bookService.addBook(newBook);
                    break;
                }

                case 2:
                {
                    bookService.displayAllBooks();
                    break;
                }

                case 3:
                {
                    bookService.searchByID(in);
                    break;
                }

                case 4:
                {
                    bookService.updateById(in);
                    break;
                }

                case 5:
                {
                    bookService.deleteById(in);
                    break;
                }

                case 6:
                {
                    System.exit(0);
                }

            }
        }




    }
    public static void menu()
    {
        System.out.println("1). Add Book");
        System.out.println("2). Display All Books");
        System.out.println("3). Search Book");
        System.out.println("4). Update Book");
        System.out.println("5). Delete Book");
        System.out.println("6). Exit");
    }
}