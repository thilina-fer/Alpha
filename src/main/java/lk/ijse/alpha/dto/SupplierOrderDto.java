package lk.ijse.alpha.dto;

public class SupplierOrderDto {
    private String soId;
    private String supId;
    private String userId;
    private String date;
    private String itemId;

    public SupplierOrderDto() {
    }

    public SupplierOrderDto(String soId, String supId, String userId, String date, String itemId) {
        this.soId = soId;
        this.supId = supId;
        this.userId = userId;
        this.date = date;
        this.itemId = itemId;
    }

    public String getSoId() {
        return soId;
    }

    public void setSoId(String soId) {
        this.soId = soId;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "SupplierOrderDto{" + "soId=" + soId + ", supId=" + supId + ", userId=" + userId + ", date=" + date + ", itemId=" + itemId + '}';
    }
}
