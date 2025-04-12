package lk.ijse.alpha.dto;

public class PreOrderDto {
    private String preOrderId;
    private String userId;
    private String itemId;
    private double advance;

    public PreOrderDto(String preOrderId, String userId, String itemId, double advanePayment) {
    }

    public PreOrderDto(String preOrderId, String userId, String itemId) {
        this.preOrderId = preOrderId;
        this.userId = userId;
        this.itemId = itemId;
        this.advance = getAdvance();
    }

    public String getPreOrderId() {
        return preOrderId;
    }

    public void setPreOrderId(String preOrderId) {
        this.preOrderId = preOrderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
   public double getAdvance(){
        return advance;
   }
   public void setAdvance(double advance){
        this.advance = advance;
   }

   @Override
    public String toString() {
        return "PreOrderDto{" + "preOrderId=" + preOrderId + ", userId=" + userId + ", itemId=" + itemId + ", advance=" + advance +'}';
    }


}
