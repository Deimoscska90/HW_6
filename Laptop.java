import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Laptop {
    private String brand;
    private int ram;
    private int storage;
    private String os;

    public Laptop(String brand, int ram, int storage, String os) {
        this.brand = brand;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
    }

    public String getBrand() {
        return brand;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("HP", 8, 256, "Windows 10"));
        laptops.add(new Laptop("Dell", 16, 512, "Windows 10"));
        laptops.add(new Laptop("Lenovo", 12, 256, "Windows 10"));
        laptops.add(new Laptop("Apple", 16, 512, "macOS"));
        laptops.add(new Laptop("Asus", 8,512, "Windows 10"));

        Map<Integer, String> criteria = new HashMap<>();
        criteria.put(1, "RAM");
        criteria.put(2, "Storage");
        criteria.put(3, "OS");

        Map<String, Integer> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (Map.Entry<Integer, String> entry : criteria.entrySet()) {
            System.out.println("Введите минимальное значение для " + entry.getValue());
            int value = scanner.nextInt();
            filters.put(entry.getValue(), value);
        }

        List<Laptop> filteredLaptops = filterLaptops(laptops, filters);
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop.getBrand() + ": RAM - " + laptop.getRam() + "GB, Storage - " + laptop.getStorage() + "GB, OS - " + laptop.getOs());
        }
    }

    public static List<Laptop> filterLaptops(List<Laptop> laptops, Map<String, Integer> filters) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            int ramFilter = filters.getOrDefault("RAM", 0);
            int storageFilter = filters.getOrDefault("Storage", 0);
            int osFilter = filters.getOrDefault("OS", 0);
            if (laptop.getRam() >= ramFilter && laptop.getStorage() >= storageFilter && (osFilter == 0 || laptop.getOs().equals(osFilter))) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }
}