package main.consoleui;

import com.google.common.collect.Lists;
import main.controller.ListingPortalController;
import main.entity.Book;
import main.entity.User;
import main.service.BookService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ListingPortal {

    @Autowired
    ListingPortal listingPortal;

    @Autowired
    ListingPortalController listingPortalController;

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;

    /*
     * This is one of the portal UI for viewing the listings as well as other commands corresponding to the listings.
     * It is the user interface for both the Users that is in our system and Guests.
     */

    /**
     * The following are the messages asking for user command
     **/
    private void printAskForCommandMessage() {
        System.out.print(" Enter command (buy,sell,exit)=> ");
    }

    private void printAskForCommandMessageforUser() {
        System.out.print(" Enter command ('1','2','3','4','5','6','7','8','9' or 'exit')=> ");
    }

    private void printAskForCommandMessageforGuest() {
        System.out.print(" Enter command \"8\", \"9\" or \"exit\" to view previous page, next page or exit the book " +
                "portal (Guests can not view book details) --> ");
    }

    /**
     * Showing the listings for Users in our system
     **/
    public void ListingUser(Scanner scanner, User user) {
        System.out.print("\n\n=== BOOK PORTAL ===\"" +
                "\n1) Type 'buy' to view the list and buy the books you want" +
                "\n2) Type 'sell' to sell books" +
                "\n3) Type 'exit' to exit " +
                "\n===");
        printAskForCommandMessage();
        String command = scanner.nextLine();
        List<Book> books = listingPortalController.getAllBooks();

        while (!command.equals("exit")) {
            if (command.equals("buy")) {
                List<List<Book>> booksPartitions = Lists.partition(books, 7);

                int page = 0;

                helper_listing_user(scanner, command, books, booksPartitions, page);
                if (books.isEmpty()) {
                    System.out.println("There is no listed books! You can view it other times!");
                }


            } else if (command.equals("sell")) {
                helper_sell_book(scanner, user);
            } else {
                System.out.println("No such command!");
            }

            printAskForCommandMessage();
            command = scanner.nextLine();
        }

    }

    // A helper method for selling a book
    private void helper_sell_book(Scanner scanner, User user) {
        System.out.print(" Enter the name of the book => ");
        String book_name = scanner.nextLine();

        System.out.print(" Enter your desired price for the book => ");
        double book_price = Double.parseDouble(scanner.nextLine());

        System.out.print(" Enter the name of the author of the book => ");
        String book_author = scanner.nextLine();
        listingPortalController.sell(user.getUsername(), book_price, book_name, book_author);
    }

    // A helper method for showing the listing portal of the books,
    // and print out the seller's information, including the name, the email, and the address
    private void helper_listing_user(Scanner scanner, String command, List<Book> books, List<List<Book>> booksPartitions, int page) {
        while (!command.equals("exit") && !books.isEmpty()) {
            // Checks if the page is not valid for the number of books in listings.
            if (page < booksPartitions.size() && page >= 0) {

                int page_number = page + 1;

                System.out.print("\n\n=== Page " + page_number + " ===" +
                        getBookMessage(booksPartitions.get(page)) +
                        "\n8) Type 8 to go to the previous page" +
                        "\n9) Type 9 to go to the next page" +
                        "\nExit) Type 'exit' to go back to the BOOK PORTAL\n");

                printAskForCommandMessageforUser();
                command = scanner.nextLine();

                // Checks for the input command
                switch (command) {
                    case "1":
                        String username1 = booksPartitions.get(page).get(0).getUser();
                        User user1 = userService.getUserByUsername(username1);
                        System.out.println("\n====================" + "\n" +
                                "Seller's Name: " + user1.getFirstName() + " " + user1.getLastName() + "\n" +
                                "Seller's Email: " + user1.getEmail() + "\n" +
                                "Seller's Address: " + user1.getAddress() + "\n" +
                                "====================");
                        break;
                    case "2":
                        String username2 = booksPartitions.get(page).get(1).getUser();
                        User user2 = userService.getUserByUsername(username2);
                        System.out.println("\n====================" + "\n" +
                                "Seller's Name: " + user2.getFirstName() + " " + user2.getLastName() + "\n" +
                                "Seller's Email: " + user2.getEmail() + "\n" +
                                "Seller's Address: " + user2.getAddress() + "\n" +
                                "====================");
                        break;
                    case "3":
                        String username3 = booksPartitions.get(page).get(2).getUser();
                        User user3 = userService.getUserByUsername(username3);
                        System.out.println("\n====================" + "\n" +
                                "Seller's Name: " + user3.getFirstName() + " " + user3.getLastName() + "\n" +
                                "Seller's Email: " + user3.getEmail() + "\n" +
                                "Seller's Address: " + user3.getAddress() + "\n" +
                                "====================");
                        break;
                    case "4":
                        String username4 = booksPartitions.get(page).get(3).getUser();
                        User user4 = userService.getUserByUsername(username4);
                        System.out.println("\n====================" + "\n" +
                                "Seller's Name: " + user4.getFirstName() + " " + user4.getLastName() + "\n" +
                                "Seller's Email: " + user4.getEmail() + "\n" +
                                "Seller's Address: " + user4.getAddress() + "\n" +
                                "====================");
                        break;
                    case "5":
                        String username5 = booksPartitions.get(page).get(4).getUser();
                        User user5 = userService.getUserByUsername(username5);
                        System.out.println("\n====================" + "\n" +
                                "Seller's Name: " + user5.getFirstName() + " " + user5.getLastName() + "\n" +
                                "Seller's Email: " + user5.getEmail() + "\n" +
                                "Seller's Address: " + user5.getAddress() + "\n" +
                                "====================");
                        break;
                    case "6":
                        String username6 = booksPartitions.get(page).get(5).getUser();
                        User user6 = userService.getUserByUsername(username6);
                        System.out.println("\n====================" + "\n" +
                                "Seller's Name: " + user6.getFirstName() + " " + user6.getLastName() + "\n" +
                                "Seller's Email: " + user6.getEmail() + "\n" +
                                "Seller's Address: " + user6.getAddress() + "\n" +
                                "====================");
                        break;
                    case "7":
                        String username7 = booksPartitions.get(page).get(6).getUser();
                        User user7 = userService.getUserByUsername(username7);
                        System.out.println("\n====================" + "\n" +
                                "Seller's Name: " + user7.getFirstName() + " " + user7.getLastName() + "\n" +
                                "Seller's Email: " + user7.getEmail() + "\n" +
                                "Seller's Address: " + user7.getAddress() + "\n" +
                                "====================");
                        break;
                    case "8":
                        page--;
                        break;
                    case "9":
                        page++;
                        break;
                    case "exit":
                        break;
                    default:
                        printAskForCommandMessageforUser();
                        command = scanner.nextLine();
                }
            } else {
                System.out.print("Invalid page command( this is the first or last page. You can't go beyond!)\n");
                break;
            }
        }
    }

    // Showing the listing user interface for Guests
    public void ListingGuest(Scanner scanner) {

        List<Book> books = listingPortalController.getAllBooks();
        int page = 0;

        if (!books.isEmpty()) {
            List<List<Book>> booksPartitions = Lists.partition(books, 7);

            int page_number = page + 1;

            System.out.print("\n\n=== Page " + page_number + " === " +
                    getBookMessage(booksPartitions.get(page)) +
                    "\n8) Type '8' to go to the previous page" +
                    "\n9) Type '9' to go to the next page" +
                    "\nExit) Type 'exit' to go back to the BOOK PORTAL\n");

            printAskForCommandMessageforGuest();
            String command = scanner.nextLine();

            if ("8".equals(command)) {
                page--;
            } else if ("9".equals(command)) {
                page++;
            } else {
                printAskForCommandMessageforGuest();
                command = scanner.nextLine();
            }
            helper_for_book_page_guest(scanner, page, booksPartitions, command);
        } else {
            System.out.println("There is no listed books! You can view it other times!");
        }

    }

    // A helper method for ListingGuest
    private void helper_for_book_page_guest(Scanner scanner, int page, List<List<Book>> booksPartitions, String command) {
        int page_number;
        while (!command.equals("exit")) {
            if (page < booksPartitions.size() && page >= 0) {

                page_number = page + 1;

                System.out.print("\n\n=== Page " + page_number + " ===" +
                        getBookMessage(booksPartitions.get(page)) +
                        "\n8) Type '8' to go to the previous page" +
                        "\n9) Type '9' to go to the next page" +
                        "\nExit) Type 'exit' to go back to the BOOK PORTAL\n");

                printAskForCommandMessageforGuest();
                command = scanner.nextLine();

                switch (command) {
                    case "8":
                        page--;
                        break;
                    case "9":
                        page++;
                        break;
                    case "exit":
                        break;
                    default:
                        printAskForCommandMessageforGuest();
                        command = scanner.nextLine();
                }
            } else {
                System.out.print("Invalid page command( this is the first or last page. You can't go" +
                        " beyond!)\n");
                break;
            }
        }
    }

    // a helper method for getting the book
    private String getBookMessage(List<Book> books) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            int number = i + 1;

            message.append("\n").append(number).append(") ").append(books.get(i).toString());
        }

        return message.toString();
    }

}
