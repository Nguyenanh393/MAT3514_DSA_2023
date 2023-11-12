package Hw6_21000663_NguyenNgocAnh.exercise06;

import java.io.*;

import Hw6_21000663_NguyenNgocAnh.exercise02.MinHeapPriorityQueue;

public class Trading {
    MinHeapPriorityQueue<Double, StockOrder> buyStock, sellStock;

    public Trading() {
        buyStock = new MinHeapPriorityQueue<>();
        sellStock = new MinHeapPriorityQueue<>();
    }

    public void addOrder(StockOrder order) {
        if (order.getStatus().equals("buy")) {
            buyStock.insert(order.getPrice(), order);
        } else {
            sellStock.insert(order.getPrice(), order);
        }
    }

    public void processOrder(FileWriter fw) {
        try {
            fw.write("status quantity price\n");
            while (!buyStock.isEmpty() && !sellStock.isEmpty()) {
                StockOrder buyOrder = buyStock.min().getValue();
                StockOrder sellOrder = sellStock.min().getValue();
                if (buyOrder.getPrice() >= sellOrder.getPrice()) {
                    if (buyOrder.getQuantity() > sellOrder.getQuantity()) {
                        buyOrder.setQuantity(buyOrder.getQuantity() - sellOrder.getQuantity());
                        fw.write("trade " + sellOrder.getQuantity() + " " + sellOrder.getPrice() + "\n");
                        sellStock.removeMin();
                    } else if (buyOrder.getQuantity() < sellOrder.getQuantity()) {
                        sellOrder.setQuantity(sellOrder.getQuantity() - buyOrder.getQuantity());
                        fw.write("trade " + buyOrder.getQuantity() + " " + sellOrder.getPrice() + "\n");
                        buyStock.removeMin();
                    } else {
                        fw.write("trade " + buyOrder.getQuantity() + " " + sellOrder.getPrice() + "\n");
                        buyStock.removeMin();
                        sellStock.removeMin();
                    }
                } else {
                    break;
                }
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
