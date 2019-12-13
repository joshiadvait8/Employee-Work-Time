import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
public class Test {

	  public static void main(String[] args) throws ParseException, FileNotFoundException {

	        ArrayList<EmpTimings> al = new ArrayList<>();

//	        Scanner s = new Scanner(new File("D:\\Desktop\\input.txt"));
	        Scanner s = new Scanner(new File("/home/aj/eclipse-workspace/AJ TASK/src/data.txt"));
	        while (s.hasNextLine()) {
	            String line = s.nextLine();
	            String[] empData = line.split("\\*{3}");
	            Date temp_sdf = new SimpleDateFormat("ddMMyyy").parse(String.valueOf(empData[1]));
	            LocalTime temp_lt = LocalTime.parse(empData[2], DateTimeFormatter.ofPattern("HHmmss"));
	            EmpTimings et = new EmpTimings();
	            et.setEmpId(Integer.parseInt(empData[0]));
	            et.setDoj(temp_sdf);
	            et.setTime(temp_lt);
	            et.setEntryExit(empData[3]);
	            al.add(et);
	        }
	        
	        al.sort(Comparator.comparing(EmpTimings::getDoj).thenComparing(EmpTimings::getEmpId).thenComparing(EmpTimings::getTime).thenComparing(EmpTimings::getEntryExit));
	        
//	        System.out.println("After sorting > ");
//	        
//	        al.forEach((EmpTimings e) -> {
//	            System.out.printf("%s\t%s\t%s\t%s\t\n", e.getEmpId(),e.getDoj(), e.getTime(), e.getEntryExit());
//	        });
//	        
//	        System.out.println("");
	        
//	        System.out.println(al.size());
	            
	        boolean jReachedEndFlag = false;
	        LocalTime entry_time = null;
	        LocalTime exit_time = null;
	        
	        for (int i = 0; i < al.size(); i++) {
	            if(!jReachedEndFlag){
//	                System.out.println("{i > "+i);
//	                System.out.println(" | i - empId > "+al.get(i).getEmpId());
	                if("10001".equals(al.get(i).getEntryExit()))
	                    entry_time = al.get(i).getTime();
	                else
	                    entry_time = null;
	                
	                if(entry_time != null)
	                    System.out.println("Date > "+al.get(i).getDoj()+"\nEmployee ID > "+al.get(i).getEmpId() + "\nEntry time > " + entry_time);
	                else
	                    System.out.println("Date > "+al.get(i).getDoj()+"\nEmployee ID > "+al.get(i).getEmpId());
	                
	                for (int j = i; j < al.size(); j++) {
	                    if(Objects.equals(al.get(j).getEmpId(), al.get(i).getEmpId())){
//	                        System.out.print("\tj > "+j);
//	                        System.out.println(" | j - empId > "+al.get(j).getEmpId());
	                        if("10101".equals(al.get(j).getEntryExit()))
	                            exit_time = al.get(j).getTime();
	                        else
	                            exit_time = null;
	                    } else {
	                        i = j-1;
	                        break;
	                    }
	                    if(j == al.size()-1){
	                        // here we will get last employee's entry / exit time
	                        jReachedEndFlag = true;
	                        break;
	                    }
	                }
	                if(entry_time == null)
	                    System.out.println("No attendance in");
	                else if(exit_time == null)
	                    System.out.println("No swipe out");
	                else{
	                    System.out.println("Exit time > "+exit_time);
	                    System.out.println("Difference > "+LocalTime.ofSecondOfDay(Duration.between(entry_time, exit_time).getSeconds()));
	                }
	                System.out.println("");
	                entry_time = null;
	                exit_time = null;
//	                System.out.println("}\n");
	            }
	        }
	            

	    }
}

