
package com.x.scheduling;


import java.util.ArrayList;
import java.util.List;
/*
Klash pou antiproswpevei mia periodo
*/

public class Period {
    ArrayList<Exam> exams = new ArrayList<Exam>();
    int id;
    
    public void setId(int id)
    {
        this.id = id;
    }

}