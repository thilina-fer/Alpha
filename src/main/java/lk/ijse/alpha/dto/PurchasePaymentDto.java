package lk.ijse.alpha.dto;


public class PurchasePaymentDto {
    private String paymentId;
    private String orderId;
    private String paymentType;
    private String payDayTime;

    public PurchasePaymentDto(String paymentId, String orderId, String paymentType, String payDayTime) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentType = paymentType;
        this.payDayTime = payDayTime;
    }

    public PurchasePaymentDto() {
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPayDayTime() {
        return payDayTime;
    }

    public void setPayDayTime(String payDayTime) {
        this.payDayTime = payDayTime;
    }
    public String toString() {
        return "PurchasePaymentDto{" + "paymentId=" + paymentId + ", orderId=" + orderId + ", paymentType=" + paymentType + ", payDayTime=" + payDayTime + '}';
    }

}