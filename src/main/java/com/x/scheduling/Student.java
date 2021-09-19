/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.scheduling;
import java.util.ArrayList;
import java.util.Arrays;
/* 
Klasi poy antiprosopevei enan foititi
*/

public class Student {
    
    int id;
    String[] courses;
    
  
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    // Pernei parametrika ena mathima kkai elexnei an to exei dilosei o foititis
    public boolean isInCourses(String course){
        for(int i = 0; i < courses.length; i++)
        {
            if(courses[i].equals(course))
            {
                return true;
            }
        }
        return false;
    }
    public String [] getCourses(){
        return this.courses;
    }
}
