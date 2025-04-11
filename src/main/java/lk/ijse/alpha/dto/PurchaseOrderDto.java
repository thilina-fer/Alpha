package lk.ijse.alpha.dto;



public class PurchaseOrderDto {
    private String orderId;
    private String custId;
    private String orderDate;
    private double totAmount;

    public PurchaseOrderDto(String reportId, String orderId, String reportDescription) {
    }

    public PurchaseOrderDto(String orderId, String custId, String orderDate, double totAmount) {
        this.orderId = orderId;
        this.custId = custId;
        this.orderDate = orderDate;
        this.totAmount = totAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotAmount() {
        return totAmount;
    }

    public void setTotAmount(double totAmount) {
        this.totAmount = totAmount;
    }

    @Override
    public String toString() {
        return "PurchaseOrderDto{" + "orderId=" + orderId + ", custId=" + custId + ", orderDate=" + orderDate + ", totAmount=" + totAmount + '}';
    }
}
