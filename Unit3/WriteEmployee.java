package FileHandling;

import java.util.Scanner;
import java.io.*;
class Employee{
    private int empNo;
    private String empName;
    private int empBasic;
    Employee(int empNo, String empName, int empBasic){
        this.empNo = empNo;
        this.empName = empName;
        this.empBasic = empBasic;
    }
    public int getEmpNo(){
        return this.empNo;
    }
    public void setEmpNo(int empNo){
        this.empNo = empNo; 
    }
    public String getEmpName(){
        return this.empName;
    }
    public void setEmpName(String empName){
        this.empName = empName;
    }
    public int getEmpBasic(){
        return this.empBasic;
    }
    public void setEmpBasic(int empBasic){
        this.empBasic = empBasic;
    }
    public String toString(){
        return "Employee [ EmpNO = "+empNo+" EmpName = "+empName+" EmpBasic = "+empBasic+" ]";
    }
}

class DataOperation{
    void read(){
        int ch;
        File f = new File("emp.txt");
        FileReader fr = null;
        try{
            fr = new FileReader(f);
            while((ch=fr.read())!= -1){
                System.out.print((char)ch);
            }
        }catch(FileNotFoundException fofe){
            fofe.printStackTrace();
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            try{
                fr.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }
}
}

public class WriteEmployee {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter Employee Details (empNO, empName, empBasic): ");
        int empNo = S.nextInt();
        S.nextLine();
        String empName = S.nextLine();
        int empBasic = S.nextInt();
        Employee e = new Employee(empNo, empName, empBasic);
        FileWriter fw = null;
        try{
            sb.append("Employee [ EmpNo = "+e.getEmpNo()+" EmpName = "+e.getEmpName()+" EmpBasic = "+e.getEmpBasic()+" ]");
            fw = new FileWriter("emp.txt");
            fw.write(sb.toString());
        }catch(IOException io){
            io.printStackTrace();
        }finally{
            try{
                fw.close();
            }catch(IOException io){
                io.printStackTrace();
            }
        }
        DataOperation d = new DataOperation();
        d.read();
        S.close();
    }
}