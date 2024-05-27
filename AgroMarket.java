package organization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AgroMarket {
    protected List<Farmer> farmers;

    protected AgroMarket() {
        this.farmers = new ArrayList<>();
    }

    public void addFarmer(Farmer farmer) {
        farmers.add(farmer);
    }

    public void removeFarmer(int farmerId) {
        farmers.removeIf(farmer -> farmer.getId() == farmerId);
    }

    public void saveState(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("name, id, product, price");
            writer.newLine();
            for (Farmer farmer : farmers) {
                writer.write(farmer.getName() + "," + farmer.getId() + "," + farmer.getProduct() + "," + farmer.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void restoreState(String filename) {
        farmers.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();  // Skip header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {

                    String name = data[0];
                    int id = Integer.parseInt(data[1]);
                    String product = data[2];
                    double price = Double.parseDouble(data[3]);
                    farmers.add(new Farmer(name, id, product, price));

                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File '" + filename + "' not found. No state to restore.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
