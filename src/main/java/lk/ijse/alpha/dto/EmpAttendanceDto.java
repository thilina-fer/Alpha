package lk.ijse.alpha.dto;

public class EmpAttendanceDto {
    private String attId;
    private String empId;
    private String dateTime;
    private String duration;

    public EmpAttendanceDto() {
    }

    public EmpAttendanceDto(String attId, String empId, String dateTime, String duration) {
        this.attId = attId;
        this.empId = empId;
        this.dateTime = dateTime;
        this.duration = duration;
    }

    public String getAttId() {
        return attId;
    }

    public void setAttId(String attId) {
        this.attId = attId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String toString() {
        return "EmpAttendanceDto{" + "attId=" + attId + ", empId=" + empId + ", dateTime=" + dateTime + ", duration=" + duration + '}';
    }
}
