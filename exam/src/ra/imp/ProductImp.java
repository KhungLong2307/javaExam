package ra.imp;
import ra.entity.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class ProductImp {
    public static void main(String[] args){
        int currentIndex = 0;
        Product obj[] = new Product[100];
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("***************************Menu****************************");
            System.out.println("1.Nhap thong tin n san pham");
            System.out.println("2.Hien thi thong tin san pham");
            System.out.println("3.tinh loi nhuan san pham");
            System.out.println("4.Sap xep cac san pham theo loi nhuan giam dan");
            System.out.println("5.Thong ke san pham theo gia");
            System.out.println("6.Tim cac san pham theo ten san pham");
            System.out.println("7.Nhap san pham");
            System.out.println("8.Ban san pham");
            System.out.println("9.Cap nhat trang thai san pham");
            System.out.println("10.Thoat");

            int check = Integer.parseInt(scanner.nextLine());
            switch (check){
                case 1:
                    System.out.println("1.Nhap thong tin n san pham");
                    System.out.println("Hay nhap so luong san pham ban muon nhap vao kho");
                    System.out.printf("kho con %d cho trong %n",obj.length-currentIndex);
                    int inputNumber = Integer.parseInt(scanner.nextLine());
                    while(inputNumber> (obj.length-currentIndex)){
                        System.out.println("Kho trong khong du moi nhap lai");
                        inputNumber = Integer.parseInt(scanner.nextLine());
                    }
                    for(int i = 0; i<inputNumber;i++){
                        obj[i+currentIndex] = new Product();
                        System.out.printf("Nhap lan %d:%n",i+1);
                        obj[i+currentIndex].inputData(scanner);
                        currentIndex++;
                    }
                    break;
                case 2:
                    for(int i=0; i<currentIndex;i++){
                        obj[i].displayData(i);
                    }
                    break;
                case 3:
                    for(int i=0;i<currentIndex;i++){
                        System.out.printf("San pham ma: %s        loi nhuan: %.2f %n",obj[i].getProductId().toUpperCase(),obj[i].calProfit()*obj[i].getQuantity());
                    }
                    break;
                case 4:
                    double arr[] = new double[currentIndex];
                    for(int i=0; i<currentIndex;i++){
                        arr[i]= obj[i].calProfit();
                    }
                    Product comparator = new Product();
                    comparator.setArray(arr);
                    Integer[] indexes = comparator.createIndexArray();
                    Arrays.sort(indexes, comparator);
                    for(int i=0;i<currentIndex;i++){
                        obj[indexes[i]].displayData(i);
                    }
                    break;
                case 5:
                    System.out.println("Hay nhap gia bat dau");
                    float fromPrice = Float.parseFloat(scanner.nextLine());
                    System.out.println("Hay nhap gia ket thuc");
                    float toPrice = Float.parseFloat(scanner.nextLine());
                    for(int i=0;i<currentIndex;i++){
                        if(obj[i].getExportPrice()>fromPrice||obj[i].getExportPrice()<toPrice){
                            obj[i].displayData(i);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Hay nhap ten san pham ban muon tim");
                    String name = scanner.nextLine();
                    for(int i=0;i<currentIndex;i++){
                        if(obj[i].getProductName().contains(name)){
                            obj[i].displayData(i);
                        }
                    }
                    break;
                case 7:
                    System.out.println("Hay nhap ma san pham");
                    String id = scanner.nextLine();
                    int numberProduct = -1;
                    int add = 0;
                    for(int i=0; i<currentIndex;i++){
                        if(obj[i].getProductId()==id){
                            numberProduct=i;
                        }
                    }
                   if(numberProduct==-1){
                       System.out.println("Ma nhap khong hop le!");
                   }
                   else {
                       System.out.println("Hay nhap so luong ban muon them vao");
                       System.out.printf("So luong hien tai la: %d %n",obj[numberProduct].getQuantity());
                       add = Integer.parseInt(scanner.nextLine());
                       obj[numberProduct].setQuantity(obj[numberProduct].getQuantity()+add);
                   }
                    break;
                case 8:
                    System.out.println("Hay nhap ten san pham");
                    name = scanner.nextLine();
                    numberProduct = -1;
                    for(int i=0; i<currentIndex;i++){
                        if(obj[i].getProductName()==name){
                            numberProduct = i;
                        }
                    }
                    if(numberProduct==-1){
                        System.out.println("San pham khong tim thay");
                    }
                    else {
                        System.out.printf("So luong hien co %d %n",obj[numberProduct].getQuantity());
                        System.out.println("Ban muon ban bao nhieu");
                        int sell = Integer.parseInt(scanner.nextLine());
                        while(sell>obj[numberProduct].getQuantity()||sell<0){
                            System.out.println("So luong san pham khong hop le! moi nhap lai");
                            sell = Integer.parseInt(scanner.nextLine());

                        }
                        obj[numberProduct].setQuantity(obj[numberProduct].getQuantity()-sell);
                    }
                    break;
                case 9:
                    System.out.println("Hay nhap ma san pham");
                    id = scanner.nextLine();
                    numberProduct = -1;

                    for(int i=0; i<currentIndex;i++){
                        if(obj[i].getProductId()==id){
                            numberProduct=i;
                        }
                    }
                    if(numberProduct==-1){
                        System.out.println("Ma nhap khong hop le!");
                    }
                    else {
                        if(obj[numberProduct].isStatus()){
                            obj[numberProduct].setStatus(false);
                        }
                        else {
                            obj[numberProduct].setStatus(true);
                        }
                    }
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Chuc nang khong hop le");
            }

        }while(true);

    }
}
