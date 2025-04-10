package lk.ijse.alpha.dto;


public class CustomerDto {
    private String custId;
    private String custName;
    private String custContact;
    private String custAddresss;

    public CustomerDto() {
    }

    public CustomerDto(String custId, String custName, String custContact, String custAddresss) {
        this.custId = custId;
        this.custName = custName;
        this.custContact = custContact;
        this.custAddresss = custAddresss;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }

    public String getCustAddresss() {
        return custAddresss;
    }

    public void setCustAddresss(String custAddresss) {
        this.custAddresss = custAddresss;
    }

    @Override
    public String toString() {
        return "CustomerDto{" + "custId=" + custId + ", custName=" + custName + ", custContact=" + custContact + ", custAddresss=" + custAddresss + '}';
    }
}
