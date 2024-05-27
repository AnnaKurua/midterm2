package organization;
import java.util.ArrayList;
import java.util.List;
public class Farmer {

    private String name;
    private int id;
    private String product;
    private double price;



    public Farmer( String name,int id, String product, double price){

        this.name = name;
        this.id = id;
        this.product = product;
        this.price = price;
    }
    public int getId(){
        return id;
    }
    public void  setId(java.lang.Integer id){
        this.id = id;
    }
    public String getName(){
        return name;
    }


    public void setName(java.lang.String name) {
        this.name = name;
    }
    public String getProduct(){
        return product;
    }

    public void setProduct(java.lang.String product) {
        this.product = product;
    }
    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
