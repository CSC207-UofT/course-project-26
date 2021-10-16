import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;
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
            if (Objects.equals(buyer.name, name)){
                return buyer.password;
            }
        }
    }

    public String getSellerPassword(String name){
        for (Seller seller : sellerList) {
            if (Objects.equals(seller.name, name)){
                return seller.password;
            }
        }
    }

    public void setBuyer(Buyer buyer) {
        this.buyerList.add(this.buyerList.size() + 1, buyer);
    }

    public void setSeller(Seller seller) {
        this.sellerList.add(this.sellerList.size() + 1, seller);
    }
}





