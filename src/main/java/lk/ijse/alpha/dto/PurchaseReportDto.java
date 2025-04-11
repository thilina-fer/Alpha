package lk.ijse.alpha.dto;

public class PurchaseReportDto {
    private String reportId;
    private String orderId;
    private String description;

    public PurchaseReportDto() {
    }

    public PurchaseReportDto(String reportId, String orderId, String description) {
        this.reportId = reportId;
        this.orderId = orderId;
        this.description = description;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Purchase_Report{" + "reportId=" + reportId + ", orderId=" + orderId + ", description=" + description + '}';
    }
}
