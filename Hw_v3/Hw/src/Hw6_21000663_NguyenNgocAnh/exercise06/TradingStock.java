package Hw6_21000663_NguyenNgocAnh.exercise06;

import java.io.*;
import java.util.*;

public class TradingStock {
    public static void main(String[] args) {
        Trading trading = new Trading();
        
        try {
            File file = new File("src\\Hw6_21000663_NguyenNgocAnh\\exercise06\\data\\order.txt");
            Scanner sc = new Scanner(file); 
            sc.nextLine();
            int count1 = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] arr = line.split(" ");
                StockOrder order = new StockOrder(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
                trading.addOrder(order);
                count1++;

                if (count1 % 100 == 0) {
                    System.out.println("Reading..." + count1);
                }
            }
            FileWriter fw = new FileWriter("src\\Hw6_21000663_NguyenNgocAnh\\exercise06\\data\\trade.txt");
            trading.processOrder(fw); 
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}