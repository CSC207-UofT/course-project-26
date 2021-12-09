package main.presenter;

import main.entity.Book;
import main.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * A main.presenter that prints messages for ListingPortal's
 */
@Component
public class ListingPortalPresenter{

    public void printAskForCommandMessage() {
        System.out.print(" Enter command (buy,sell,exit)=> ");
    }

    public void printAskForCommandMessageforUser() {
        System.out.print(" Enter command ('1','2','3','4','5','6','7','8','9' or 'exit')=> ");
    }

    public void printAskForCommandMessageforGuest() {
        System.out.print(" Enter command \"8\", \"9\" or \"exit\" to view previous page, next page or exit the book " +
                "portal (Guests can not view book details) --> ");
    }

    public void printBookPortal(){
        System.out.print("\n\n=== BOOK PORTAL ===\"" +
                "\n1) Type 'buy' to view the list and buy the books you want" +
                "\n2) Type 'sell' to sell books" +
                "\n3) Type 'exit' to exit " +
                "\n===");
    }

    public void printNoListedBookMessage(){System.out.println("There is no listed books! You can view it other times!");
    }

    public void incorrectCommandMessage(){System.out.println("No such command!");}

    public void askBookName(){System.out.print(" Enter the name of the book => ");}

    public void askBookPrice(){System.out.print(" Enter your desired price for the book => ");}

    public void askForAuthorName(){System.out.print(" Enter the name of the author of the book => ");}

    public void showListingsPage(List<List<Book>> booksPartitions, int page, int page_number) {
        System.out.print("\n\n=== Page " + page_number + " ===" +
                getBookMessage(booksPartitions.get(page)) +
                "\n8) Type 8 to go to the previous page" +
                "\n9) Type 9 to go to the next page" +
                "\nExit) Type 'exit' to go back to the BOOK PORTAL\n");
    }

    public void showSellerInfoForBook(User user) {
        System.out.println("\n====================" + "\n" +
                "Seller's Name: " + user.getFirstName() + " " + user.getLastName() + "\n" +
                "Seller's Email: " + user.getEmail() + "\n" +
                "Seller's Address: " + user.getAddress() + "\n" +
                "====================");
    }

    public void showIncorrectPageMessage(){
        System.out.print("Invalid page command( this is the first or last page. You can't go beyond!)\n");
    }

    public void printBookSellSuccessMessage(){
        System.out.print(" The book has successfully listed! ");
    }

    // a helper method for getting the book's name
    private String getBookMessage(List<Book> books) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < books.size(); i++) {
            int number = i + 1;

            message.append("\n").append(number).append(") ").append(books.get(i).toString());
        }

        return message.toString();
    }

}
