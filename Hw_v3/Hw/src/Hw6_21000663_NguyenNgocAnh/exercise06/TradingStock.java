package Hw6_21000663_NguyenNgocAnh.exercise06;
// An online computer system for trading stocks needs to process orders of the form
// “buy 100 shares at $x each” or “sell 100 shares at $y each.” A buy order for $x
// can only be processed if there is an existing sell order with price $y such that
// y ≤ x. Likewise, a sell order for $y can only be processed if there is an existing
// buy order with price $x such that y ≤ x. If a buy or sell order is entered but
// cannot be processed, it must wait for a future order that allows it to be processed.
// Describe a scheme that allows buy and sell orders to be entered in O(logn) time,
// independent of whether or not they can be immediately processed.

// Sử dụng HeapPriorityQueue ở bài tập 2 viết chương trình mô phỏng hệ thống điều khiển giao dịch
// chứng khoán đơn giản, quản lí các lệnh mua và bán.

// Mỗi lệnh mua và bán được biểu diễn bởi một đối tượng có các thuộc tính: mã chứng khoán, số lượng,
// giá mua/bán, thời gian đặt lệnh. Hệ thống quản lí các lệnh mua và bán theo thứ tự giá mua/bán tăng dần.
// Khi có lệnh mua/bán mới được đưa vào hệ thống, hệ thống sẽ kiểm tra xem có lệnh mua/bán nào có giá
// mua/bán thấp hơn và số lượng lớn hơn lệnh mua/bán mới không. Nếu có, hệ thống sẽ thực hiện giao dịch
// và xóa lệnh mua/bán cũ. Nếu không, lệnh mua/bán mới sẽ được đưa vào hệ thống và chờ đến khi có lệnh
// mua/bán khác có giá mua/bán thấp hơn và số lượng lớn hơn lệnh mua/bán mới thì hệ thống sẽ thực hiện
// giao dịch và xóa lệnh mua/bán mới.

// Để đơn giản, ta giả sử rằng mã chứng khoán là một số nguyên, số lượng là một số nguyên, giá mua/bán
// là một số nguyên, thời gian đặt lệnh là một số nguyên.

// Viết chương trình mô phỏng hệ thống điều khiển giao dịch chứng khoán đơn giản, quản lí các lệnh mua và bán.
// Mỗi lệnh mua và bán được biểu diễn bởi một đối tượng có các thuộc tính: mã chứng khoán, số lượng,
// giá mua/bán, thời gian đặt lệnh. Hệ thống quản lí các lệnh mua và bán theo thứ tự giá mua/bán tăng dần.
// Khi có lệnh mua/bán mới được đưa vào hệ thống, hệ thống sẽ kiểm tra xem có lệnh mua/bán nào có giá
// mua/bán thấp hơn và số lượng lớn hơn lệnh mua/bán mới không. Nếu có, hệ thống sẽ thực hiện giao dịch
// và xóa lệnh mua/bán cũ. Nếu không, lệnh mua/bán mới sẽ được đưa vào hệ thống và chờ đến khi có lệnh
// mua/bán khác có giá mua/bán thấp hơn và số lượng lớn hơn lệnh mua/bán mới thì hệ thống sẽ thực hiện
// giao dịch và xóa lệnh mua/bán mới.

public class TradingStock {
    /**
     * OrderTrade
     */
    public class OrderTrade {

        private int stockCode;
        private int quantity;
        private int price;
        private int time;

        public OrderTrade(int stockCode, int quantity, int price, int time) {
            this.stockCode = stockCode;
            this.quantity = quantity;
            this.price = price;
            this.time = time;
        }

        public int getStockCode() {
            return stockCode;
        }

        public void setStockCode(int stockCode) {
            this.stockCode = stockCode;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
        
    }
}