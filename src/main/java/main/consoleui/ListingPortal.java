package main.consoleui;

import com.google.common.collect.Lists;
import main.controller.ListingPortalController;
import main.entity.Book;
import main.entity.User;
import main.service.BookService;
import main.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import main.presenter.ListingPortalPresenter;

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

    public final ListingPortalPresenter listingPortalPresenter = new ListingPortalPresenter();

    /**
     * This is one of the portal UI for viewing the listings as well as other commands corresponding to the listings.
     * It is the user interface for both the Users that is in our system and Guests.
     *
     *
     * Showing the listings for Users in our system
     **/
    public void ListingUser(Scanner scanner, User user) {
        listingPortalPresenter.printBookPortal();
        listingPortalPresenter.printAskForCommandMessage();
        String command = scanner.nextLine();
        List<Book> books = listingPortalController.getAllBooks();

        while (!command.equals("exit")) {
            if (command.equals("buy")) {
                List<List<Book>> booksPartitions = Lists.partition(books, 7);

                int page = 0;

                helper_listing_user(scanner, command, books, booksPartitions, page);
                if (books.isEmpty()) {
                    listingPortalPresenter.printNoListedBookMessage();
                }


            } else if (command.equals("sell")) {
                helper_sell_book(scanner, user);
                listingPortalPresenter.printBookSellSuccessMessage();
            } else {
                listingPortalPresenter.incorrectCommandMessage();
            }

            listingPortalPresenter.printAskForCommandMessage();
            command = scanner.nextLine();
        }

    }

    // A helper method for selling a book
    private void helper_sell_book(Scanner scanner, User user) {
        listingPortalPresenter.askBookName();
        String book_name = scanner.nextLine();

        listingPortalPresenter.askBookPrice();
        double book_price = Double.parseDouble(scanner.nextLine());

        listingPortalPresenter.askForAuthorName();
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

                listingPortalPresenter.showListingsPage(booksPartitions, page, page_number);

                listingPortalPresenter.printAskForCommandMessageforUser();
                command = scanner.nextLine();

                // Checks for the input command
                switch (command) {
                    case "1":
                        String username1 = booksPartitions.get(page).get(0).getUser();
                        User user1 = userService.getUserByUsername(username1);
                        listingPortalPresenter.showSellerInfoForBook(user1);
                        break;
                    case "2":
                        String username2 = booksPartitions.get(page).get(1).getUser();
                        User user2 = userService.getUserByUsername(username2);
                        listingPortalPresenter.showSellerInfoForBook(user2);
                        break;
                    case "3":
                        String username3 = booksPartitions.get(page).get(2).getUser();
                        User user3 = userService.getUserByUsername(username3);
                        listingPortalPresenter.showSellerInfoForBook(user3);
                        break;
                    case "4":
                        String username4 = booksPartitions.get(page).get(3).getUser();
                        User user4 = userService.getUserByUsername(username4);
                        listingPortalPresenter.showSellerInfoForBook(user4);
                        break;
                    case "5":
                        String username5 = booksPartitions.get(page).get(4).getUser();
                        User user5 = userService.getUserByUsername(username5);
                        listingPortalPresenter.showSellerInfoForBook(user5);
                        break;
                    case "6":
                        String username6 = booksPartitions.get(page).get(5).getUser();
                        User user6 = userService.getUserByUsername(username6);
                        listingPortalPresenter.showSellerInfoForBook(user6);
                        break;
                    case "7":
                        String username7 = booksPartitions.get(page).get(6).getUser();
                        User user7 = userService.getUserByUsername(username7);
                        listingPortalPresenter.showSellerInfoForBook(user7);
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
                        listingPortalPresenter.printAskForCommandMessageforUser();
                        command = scanner.nextLine();
                }
            } else {
                listingPortalPresenter.showIncorrectPageMessage();
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

            listingPortalPresenter.showListingsPage(booksPartitions, page, page_number);

            listingPortalPresenter.printAskForCommandMessageforGuest();
            String command = scanner.nextLine();

            if ("8".equals(command)) {
                page--;
            } else if ("9".equals(command)) {
                page++;
            } else {
                listingPortalPresenter.printAskForCommandMessageforGuest();
                command = scanner.nextLine();
            }
            helper_for_book_page_guest(scanner, page, booksPartitions, command);
        } else {
            listingPortalPresenter.printNoListedBookMessage();
        }

    }

    // A helper method for ListingGuest
    private void helper_for_book_page_guest(Scanner scanner, int page, List<List<Book>> booksPartitions, String command) {
        int page_number;
        while (!command.equals("exit")) {
            if (page < booksPartitions.size() && page >= 0) {

                page_number = page + 1;

                listingPortalPresenter.showListingsPage(booksPartitions, page, page_number);

                listingPortalPresenter.printAskForCommandMessageforGuest();
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
                        listingPortalPresenter.printAskForCommandMessageforGuest();
                        command = scanner.nextLine();
                }
            } else {
                listingPortalPresenter.showIncorrectPageMessage();
                break;
            }
        }
    }


}
