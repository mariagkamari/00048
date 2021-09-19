/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.scheduling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToolMethods {
    
    //Klasi statikwn methodwn pou xirizonte tis leitourgies tou programmatos
    

        // H fillId sarwnei to arxeio keimenoy kai briskei to plithos twn foititwn
     public static void extractStudents(String path) throws FileNotFoundException
    {
        f = new File(path);
        ids = new ArrayList<Integer>();
        int i = 0;
        sc = new Scanner(f);
        while(sc.hasNextLine())
        {
           ids.add(i);
           i++;
           sc.nextLine();
        }
        sc.close();
    }
    /* H findStudentSubsciptions apothikevei tis eggrafes twn foititwn me tin morfi enos eniaiou String gia na
     mporesoume na epeksergastoume ta stoixeia stin sinexeia*/
    public static void findStudentSubsciptions() throws FileNotFoundException
    {
        subs = new ArrayList<String>();
        int i = 0;
        sc = new Scanner(f);
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            subs.add(line);

        }
        sc.close();
    }
    // H calculateUniqueSubs vriskei to plithos twn eggrafwn.
    private static int calculateUniqueSubs()
    {
        int wordCount = 0;
        for(int i = 0 ; i < subs.size(); i++)
        {
           StringTokenizer st = new StringTokenizer(subs.get(i));
           wordCount = wordCount + st.countTokens();
        }
        return wordCount;
    }
    // H calculateTotalExams vriskei to plithos twn eksetasewn.
     public static void calculateTotalExams()
    {
      ArrayList<String> Courses = new ArrayList<String>();


        for(int i = 0 ; i < subs.size(); i++)
        {
          int j = 0;
          String[] splits = subs.get(i).split("\\s");
          while(j < splits.length)
          {
          Courses.add(splits[j]);
          j++;
          }
        }

        examSet = new HashSet<String>(Courses);
        examsNum = String.valueOf(examSet.size());
        subsNum = String.valueOf(calculateUniqueSubs());
        
        uniqueExams = Courses.stream().distinct().collect(Collectors.toList());

    }
    /* H calculateStudentCourses apothikevei gia kathe foititi enan pinaka tipoy String (String[])
       poy periexei tis eggrafes tou gia kathe mathima.*/
    public static void calculateStudentCourses()
    {
        students = new ArrayList<Student>();
        for(int i = 0 ; i < ids.size(); i++)
        {
            students.add(new Student());
            students.get(i).setId(i);
            String[] splitStr = subs.get(i).trim().split("\\s+");
            students.get(i).courses = splitStr;

        }


    }
    // Η storeExams apothikevei se enan pinaka tis eksetaseis,kathe eksetash exei sigkekrimenous foitites.
    public static void storeExams()
    {
        exams = new ArrayList<Exam>();
        for(int i = 0; i < uniqueExams.size(); i++)
        {    exams.add(new Exam());
            for(int j = 0; j < students.size(); j++)
            {
                if(students.get(j).isInCourses(uniqueExams.get(i)))
                 {
                    exams.get(i).students.add(students.get(j));
                    exams.get(i).setName(uniqueExams.get(i));
                 }
            }
        }       
    }
    /* H calculateConflictDensity sygkrinei eksetaseis pou vriskonte stin idia periodo, kai an kapoios foititis eksetazete se 2 mathimata toulaxiston
     ta opoia vriskonte stin idia periodo , tote uparxei sigkroush*/
    public static void calculateConflictDensity()
    {  
        // Η parakatw methodologia diaxorizei tis eksetaseis se 32 periodous.
        int from = 0;
        int to = (exams.size()/32);
        int i = 0;   
        periods = new ArrayList<Period>();
        
           while(i <= 31){
               if(i >= 0 && i <= 30) {
                periods.add(new Period());
                List<Exam> ex = new ArrayList<Exam>();
                ex = exams.subList(from, to);
                
                for(int k = 0; k < ex.size(); k++){
                periods.get(i).exams.add(ex.get(k));
                }
                periods.get(i).setId(i);
                from = to + 1;
                to = to + 16;
                i++;
               }
               else{
                List<Exam> ex = new ArrayList<Exam>();
                ex = exams.subList(from, to);
                for(int k = 0; k < ex.size(); k++){
                periods.get(i).exams.add(ex.get(k));
                }
                periods.get(i).setId(i);
                  i++;
                }           
           }
           
          /* Ftiaxnoume ton pinaka sigkrousewn(Conflict Matrix).
           */
         for(int j = 0; j < periods.size(); j++)
          {
               int y = 0;
             for(int x = 0; x < periods.get(j).exams.size(); x++)
            {
               while(y < periods.get(j).exams.get(x).students.size() && j+1 <= exams.size())
               {
                  if(testInConflict(periods.get(j).exams.get(x).getStudent(y),periods.get(j).exams.get(j+1)))
                 {
                   conflictMatrix[j][j+1] = 1;
                 }
                  else
                 {
                   conflictMatrix[j][j+1] = 0;
                 }
                  y++;
               }
            }
          }
         

    }
   
      public static boolean testInConflict(Student s1 , Exam e2)
    {   
        for(int i = 0; i < e2.students.size(); i++)
        {
            if(e2.students.get(i).getId() == (s1.getId()));
            return true;
        }
       return false;
        
    }
    
    // H loadSolutions fortonei tis liseis apo to arxeio keimenoy sto programma.
    public static void loadSolutions(String path) throws FileNotFoundException
    {
        int counter = 0;
        f1 = new File(path);
        int i = 0;
        sc = new Scanner(f1);
        while(sc.hasNextLine())
        {
           counter = counter + 1;
           i++;
           sc.nextLine();
        }
        sc.close();
        solutions = counter;
    }
    //Parakatw einai oi getters gia tin enalagi dedomenwn metaksi twn klasewn
    public static String getSolsNum()
    {
        return String.valueOf(solutions);
    }

    public static String getSubs()
    {
        subsNum = String.valueOf(calculateUniqueSubs());
        return subsNum;
    }
    public static String getStudents()
    {
        studentsNum = String.valueOf(ids.size());
        return studentsNum;
    }
    public static String getExams()
    {
        examsNum = String.valueOf(examSet.size());
        return examsNum;
    }
    static File f ;
    static File f1;
    static Scanner sc;
    static ArrayList<Integer> ids ; // apothikevonte ta id`s twn foititwn,afou katametrithikan
    static ArrayList<String> subs; // apothikevonte san ena ENIAIO String ana seira , oi eggrafes
    static ArrayList<Student> students;     // apothikevonte gia kathe foititi oi eggrafes tou , san ena String []
    static ArrayList<Exam> exams;
    static List<String> uniqueExams; // apothikevonte ta mathimata memonomena.
    static ArrayList<Period> periods;
    private static int [][]conflictMatrix = new int[271][272];
    private static String subsNum;
    private static String periodsNum;
    private static String studentsNum;
    private static String examsNum;
    private static Set<String> examSet;
    private static int solutions;
}