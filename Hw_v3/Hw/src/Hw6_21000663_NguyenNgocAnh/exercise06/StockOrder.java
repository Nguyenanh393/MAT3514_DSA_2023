package Hw6_21000663_NguyenNgocAnh.exercise06;

public class StockOrder{
    private String status; // "buy" or "sell"
    private double quantity;
    private double price;

    public StockOrder(String status, double quantity, double price) {
        this.status = status;
        this.quantity = quantity;
        this.price = price;
    }
    public String getStatus() {
        return status;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return status + " " + quantity + " " + price;
    }
}
