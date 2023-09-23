package ra.entity;

import java.util.Comparator;
import  java.util.Scanner;
public class Product implements Comparator<Integer> {
    private String productId = "";
    private String productName = "";
    private float importPrice = 0f;
    private float exportPrice = 0f;
    private float profit = 0f;
    private int quantity = 0;
    private String descriptions = "";
    private boolean status = false;

    private Double[] array;
    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status,Double[] array) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        this.array = array;
    }

    public Double[] getArray() {
        return array;
    }

    public void setArray(double[] array) {
        this.array = array;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Hay nhap ma san pham");
        productId = scanner.nextLine();
        System.out.println("Hay nhap ten san pham");
        productName = scanner.nextLine();
        System.out.println("Hay nhap gia nhap vao san pham");
        importPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Hay nhap gia xuat san pham");
        exportPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Hay nhap so luong san pham");
        quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Hay nhap mo ta san pham");
        descriptions = scanner.nextLine();
    }

    public void displayData(int i) {
        System.out.printf("San pham %d:  ", i + 1);
        System.out.printf("Ma san pham:%s  ", productId.toUpperCase());
        System.out.printf("Ten san pham:%s  ", productName.toUpperCase());
        System.out.printf("Gia nhap san pham:%.2f  ", importPrice);
        System.out.printf("Gia xuat san pham:%.2f  ", exportPrice);
        System.out.printf("So luong san pham:%d  ", quantity);
        System.out.printf("Mo ta san pham:%s  ", descriptions.toUpperCase());
        if (status) {
            System.out.println("San pham dang duoc ban");
        } else {
            System.out.println("San pham dang ngung ban");
        }
    }
    public double calProfit() {
        return exportPrice - importPrice;
    }


    public Integer[] createIndexArray()
    {
        Integer[] indexes = new Integer[array.length];
        for (int i = 0; i < array.length; i++)
        {
            indexes[i] = i; // Autoboxing
        }
        return indexes;
    }

    public int compare(Integer index1, Integer index2)
    {
        return array[index1].compareTo(array[index2]);
    }
}
