package organization;

public class OrganizationTester {
    public static void main(String[] args) {
        AgroMarket market = new AgroMarket();
        market.addFarmer(new Farmer("Rusudan Kobalava", 010670, "Tomatoes", 2.49));
        market.addFarmer(new Farmer("Dato Apshilava", 020775, "Carrots", 1.70));
        market.saveState("state.csv");

        AgroMarket newMarket = new AgroMarket();
        newMarket.restoreState("state.csv");
        for (Farmer farmer : newMarket.farmers) {
            System.out.println(farmer.getName() + " " + farmer.getId() + " " + farmer.getProduct() + " " + farmer.getPrice());
        }
    }
 }


