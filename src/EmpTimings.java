import java.time.LocalTime;
import java.util.Date;

public class EmpTimings{
    private Integer empId;
    private Date doj;
    private LocalTime time;
    private String entryExit;

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getEntryExit() {
        return entryExit;
    }

    public void setEntryExit(String entryExit) {
        this.entryExit = entryExit;
    }        

}