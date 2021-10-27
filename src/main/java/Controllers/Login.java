package Controllers;

import Entity.Buyer;
import Entity.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Login {

    List<Buyer> buyerList = new ArrayList<>();
    List<Seller> sellerList = new ArrayList<>();


    Login() {
        this.buyerList = new ArrayList<>();
        this.sellerList = new ArrayList<>();
    }

    public String getBuyerPassword(String name){
        for (Buyer buyer : buyerList) {
            if (Objects.equals(buyer.getName(), name)){
                return buyer.getPassword();
            }
        }
        return name;
    }

    public String getSellerPassword(String name){
        for (Seller seller : sellerList) {
            if (Objects.equals(seller.getName(), name)){
                return seller.getPassword();
            }
        }
        return name;
    }

    public void setBuyer(Buyer buyer) {
        this.buyerList.add(this.buyerList.size() + 1, buyer);
    }

    public void setSeller(Seller seller) {
        this.sellerList.add(this.sellerList.size() + 1, seller);
    }
}





