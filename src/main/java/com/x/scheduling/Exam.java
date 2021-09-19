
package com.x.scheduling;
import java.util.ArrayList;
/*
    H klassi Exam modelopoiei mia eksetasi.
*/

public class Exam {
    ArrayList<Student> students = new ArrayList<Student>();
    String name;
    
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
   public void displayStudents()
   {
       for(int i = 0; i < students.size(); i++)
       {
           System.out.println(students.get(i).getId());
       }
   }
   public Student getStudent(int i)
   {
       return students.get(i);
   }
}