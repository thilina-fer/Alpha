package lk.ijse.alpha.dto;

public class SupplierDto {
    private String supId;
    private String supName;
    private String supContact;

    public SupplierDto(String supId, String supName, String supContact) {
        this.supId = supId;
        this.supName = supName;
        this.supContact = supContact;
    }

    public SupplierDto() {
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getSupContact() {
        return supContact;
    }

    public void setSupContact(String supContact) {
        this.supContact = supContact;
    }

    @Override
    public String toString() {
        return "SupplierDto{" + "supId=" + supId + ", supName=" + supName + ", supContact=" + supContact + '}';
    }
}
