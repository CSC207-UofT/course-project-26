package Usecase;

import Entity.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BookManager is a use case for Book.
 *
 * IdToBook is a Map storing Id as key and Book as value
 */
public class BookManager {
    private final Map<String, Book> idToBook = new HashMap<>();

    /**
     * Create an BookManager with given books
     * @param allItems all current items in the system (if any)
     */
    public BookManager(List<Book> allItems) {
        for (Book book: allItems){
            idToBook.put(book.getName(), book);
        }
    }

    /**
     * Add Book to the BookManager
     * @param book Book to be added
     */
    public void addBook(Book book){
        if (idToBook.containsKey(book.getName())) return;
        idToBook.put(book.getName(), book);
    }

    /**
     * Create a new Book with given name and description of the item, add it to the BookManager
     * @param inputName The assigned Book name.
     * @param inputDescription The assigned Book description
     * @return String The Name of the newly created Book.
     */
    public String createNewBook(String inputName, String inputDescription){
        Book newBook = new Book(inputName, inputDescription);
        addBook(newBook);
        return newBook.getName();
    }

    /**
     * Find a book with given Name
     * @param bookId The given Item id
     */
    public Book findItem(String itemId){
        return idToItem.get(itemId);
    }

    /**
     * Get name of an item with given id
     * @param itemId The given Item id
     * @return ItemStatus of the status of the item
     */
    public ItemStatus getItemStatus(String itemId) {
        return findItem(itemId).getStatus();
    }

    /**
     * Represent all items in the system.
     * @return A list of all itemId in the system
     */
    public List<String> getAllItems() {
        return new ArrayList<>(idToItem.keySet());
    }

    /**
     * Get the map of item objects
     * @return Map of item id to item object
     */
    public Map<String, Item> getIdToItem() {
        return idToItem;
    }

    /**
     * Sets the itemId's status to AVAILABLE.
     * @param itemId the item which status we want to change.
     */
    public void makeItemAvailable(String itemId)  {
        changeItemStatus(itemId, ItemStatus.AVAILABLE);
    }


    /**
     * Sets the itemId's status to UNAVAILABLE.
     * @param itemId the item which status we want to change.
     */
    public void makeItemUnavailable(String itemId)  {
        changeItemStatus(itemId, ItemStatus.UNAVAILABLE);
    }

    /**
     * Sets the itemId's status to status
     * @param itemId the itemId with status to be changed
     * @param status the new status
     */
    public void changeItemStatus(String itemId, ItemStatus status) {
        Item temp = findItem(itemId);
        if (temp!=null) temp.setStatus(status);
    }

    /**
     * Removes the given itemId from the system by changing the status into REMOVED
     * @param itemId the item to be removed.
     * @return true iff successfully removed
     */
    public boolean removeItemFromSystem(String itemId) {
        Item item = findItem(itemId);
        if (item.getStatus().equals(ItemStatus.UNCHECKED)||item.getStatus().equals(ItemStatus.AVAILABLE)) {
            item.setStatus(ItemStatus.REMOVED);
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Get itemIds with status
     * @param status the ItemStatus wanted
     * @return a list of itemIds with status
     */
    public List<String> getIdsByStatus(ItemStatus status) {
        List<String> ids = new ArrayList<>();
        for (String id: idToItem.keySet()) {
            if (findItem(id).getStatus().equals(status)) ids.add(id);
        }
        return ids;
    }

    /**
     * Gives the itemId based on Item Object
     * @param item the Item object
     * @return the itemId in String
     */
    public String getItemIdByItem(Item item) {
        return item.getId();
    }

    /**
     * Set the item name
     * @param itemId itemId of the Item
     * @param newName the new name
     */
    public void setItemName(String itemId, String newName) {
        Item item = findItem(itemId);
        item.setName(newName);
    }

    /**
     * Set the item description
     * @param itemId itemId of the Item
     * @param newDescription the new description
     */
    public void setItemDescription(String itemId, String newDescription) {
        Item item = findItem(itemId);
        item.setDescription(newDescription);
    }

    /**
     * Converts itemIds into Item
     * @param itemIds List of itemIds to be converted
     * @return list of Item objects
     */
    public List<Item> giveListItem(List<String> itemIds) {
        List<Item> al = new ArrayList<>();
        for (String itemId: itemIds) {
            al.add(findItem(itemId));
        }
        return al;
    }

    /**
     * Get itemName based on itemId
     * @param itemId itemId of an Item
     * @return String of item name
     */
    public String getItemNameByItemId(String itemId) {
        return findItem(itemId).getName();
    }

    /**
     * Checks whether there exists available itemId
     * @param itemIds list of itemId
     * @return false iff all itemIds are not available
     */
    public boolean hasAvailableItems(List<String> itemIds) {
        for (String itemId: itemIds) {
            if (findItem(itemId).getStatus().equals(ItemStatus.AVAILABLE)) {
                return true;
            }
        }
        return false;
    }
}
