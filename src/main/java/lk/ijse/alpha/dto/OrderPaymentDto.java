package lk.ijse.alpha.dto;

public class OrderPaymentDto {
    private String opId;
    private String supId;
    private String soId;
    private Double amount;
    private String payType;

    public OrderPaymentDto() {
    }

    public OrderPaymentDto(String opId, String supId, String soId, Double amount, String payType) {
        this.opId = opId;
        this.supId = supId;
        this.soId = soId;
        this.amount = amount;
        this.payType = payType;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSoId() {
        return soId;
    }

    public void setSoId(String soId) {
        this.soId = soId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "OrderPaymentDto{" + "opId=" + opId + ", supId=" + supId + ", soId=" + soId + ", amount=" + amount + ", payType=" + payType + '}';
    }

}
