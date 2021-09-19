/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.scheduling;


import java.io.FileNotFoundException;





 interface Analyzer {
    public void createAnalyzer(Extractor af);
}
/* 
 H klassi Problem antiprosopevei to provlima kai ylopoiei to interface Analyzer
 H diepafi analyzer periexei tin methodo h opoia ftiaxnei ksexorista kainourio jFrame
 gia to kathe provlima.

*/
public class Handler implements Analyzer
{   String path;
    String probnum;
    String periods;
    String density;
    String solpath;
    Extractor extractor;
    Results results;
    
    Handler(String path , String probnum , String periods , String density , String solpath)
    {
        this.path = path;
        this.probnum = probnum;
        this.periods = periods;
        this.density = density;
        this.solpath = solpath;
    }
   
    public void createAnalyzer(Extractor extr)
    {
        this.extractor = extr;
        if(probnum.equals("1"))
        {
        extr.LProblemName.setText("CAR-F-92");
        }
        else if(probnum.equals("2"))
        {
         extr.LProblemName.setText("CAR-S-91");
        }
        else if(probnum.equals("3"))
        {
         extr.LProblemName.setText("EAR-F-83");
        }
        else if(probnum.equals("4"))
        {
         extr.LProblemName.setText("HEC-S-92");
        }
        else if(probnum.equals("5"))
        {
         extr.LProblemName.setText("KFU-S-93");
        }
        else if(probnum.equals("6"))
        {
         extr.LProblemName.setText("LSE-F-91");
        }
        else if(probnum.equals("7"))
        {
         extr.LProblemName.setText("PUR-S-93");
        }
        else if(probnum.equals("8"))
        {
         extr.LProblemName.setText("RYE-S-93");
        }
        else if(probnum.equals("9"))
        {
         extr.LProblemName.setText("STA-F-83");
        }
        else if(probnum.equals("10"))
        {
         extr.LProblemName.setText("TRE-S-92");
        }
        else if(probnum.equals("11"))
        {
         extr.LProblemName.setText("UTA-S-92");
        }
        else if(probnum.equals("12"))
        {
         extr.LProblemName.setText("UTE-S-92");
        }
         else if(probnum.equals("13"))
        {
         extr.LProblemName.setText("YOR-F-83");
        }
        extr.setLocationRelativeTo(null);
        extr.setVisible(true);
        extr.AnalyzeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AnalyzeButtonMouseClicked(evt);
            }
        });
        extr.Backbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackbuttMouseClicked(evt);
            }
        });
        extr.Solbutt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SolbuttMouseClicked(evt);
            }
        });
        
    }
     private void AnalyzeButtonMouseClicked(java.awt.event.MouseEvent evt) 
     {                                           
           try 
           {
           ToolMethods.extractStudents(path);
           ToolMethods.findStudentSubsciptions();
           ToolMethods.calculateTotalExams();
           } 
           catch (FileNotFoundException ex) 
           {
            
           }
           extractor.StudsValue.setText(ToolMethods.getStudents());
           extractor.StudsValue.setVisible(true);
           extractor.SubsValue.setText(ToolMethods.getSubs());
           extractor.SubsValue.setVisible(true);
           extractor.PeriodsValue.setText(periods);
           extractor.PeriodsValue.setVisible(true);
           extractor.ExamsValue.setText(ToolMethods.getExams());
           extractor.ExamsValue.setVisible(true);
           extractor.ConflictValue.setText(density);
           extractor.ConflictValue.setVisible(true);
           extractor.AnalyzeButton.setVisible(false);
           extractor.Backbutt.setVisible(true);
           extractor.Solbutt.setVisible(true);
           
    }
     private void BackbuttMouseClicked(java.awt.event.MouseEvent evt)
     {                                      
        extractor.dispose();
        Menu frame = new Menu();
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
     } 
      private void SolbuttMouseClicked(java.awt.event.MouseEvent evt) 
      {                                     
          try
          {
            ToolMethods.loadSolutions(solpath);
          }
          catch(FileNotFoundException ex)
          {
              
          }
          extractor.dispose();
          results = new Results();
           if(probnum.equals("1"))
           {
             results.solutionsHead.setText("CAR-F-92 SOLUTIONS");
             results.cost.setText("3.71");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
           }
           else if(probnum.equals("2"))
           {
             results.solutionsHead.setText("CAR-S-91 SOLUTIONS");
             results.cost.setText("4.39");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             
           }
           else if(probnum.equals("3"))
           {
             results.solutionsHead.setText("EAR-F-83 SOLUTIONS");
             extractor.LProblemName.setText("EAR-F-83");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("32.63");
           }
            else if(probnum.equals("4"))
           {
             results.solutionsHead.setText("HEC-S-92 SOLUTIONS");
             extractor.LProblemName.setText("HEC-S-92");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("10.04");
           }
            else if(probnum.equals("5"))
           {
             results.solutionsHead.setText("KFU-S-93 SOLUTIONS");
             extractor.LProblemName.setText("KFU-S-93");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("12.90");
           }
            else if(probnum.equals("6"))
           {
             results.solutionsHead.setText("LSE-F-91 SOLUTIONS");
             extractor.LProblemName.setText("LSE-F-91");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("9.82");
           }
            else if(probnum.equals("7"))
           {
             results.solutionsHead.setText("PUR-S-93 SOLUTIONS");
             extractor.LProblemName.setText("PUR-S-93");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("4.49");
           }
            else if(probnum.equals("8"))
           {
             results.solutionsHead.setText("RYE-S-93 SOLUTIONS");
             extractor.LProblemName.setText("RYE-S-93");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("7.93");
           }
            else if(probnum.equals("9"))
           {
             results.solutionsHead.setText("STA-F-83 SOLUTIONS");
             extractor.LProblemName.setText("STA-F-83");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("157.03");
           }
            else if(probnum.equals("10"))
           {
             results.solutionsHead.setText("TRE-S-92 SOLUTIONS");
             extractor.LProblemName.setText("TRE-S-92");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("7.72");
           } 
            else if(probnum.equals("11"))
           {
             results.solutionsHead.setText("UTA-S-92 SOLUTIONS");
             extractor.LProblemName.setText("UTA-S-92");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("3.04");
           }
            else if(probnum.equals("12"))
           {
             results.solutionsHead.setText("UTE-S-92 SOLUTIONS");
             extractor.LProblemName.setText("UTE-S-92");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("24.77");
           }
            else if(probnum.equals("13"))
           {
             results.solutionsHead.setText("YOR-F-83 SOLUTIONS");
             extractor.LProblemName.setText("YOR-F-83");
             results.solutionsNum.setText(ToolMethods.getSolsNum());
             results.cost.setText("34.71");
           }
           
          
          results.setVisible(true);
          results.setSize(400,400);
          results.setLocationRelativeTo(null);
          results.backtomenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtomenuMouseClicked(evt);
            }
        });
      } 
      private void backtomenuMouseClicked(java.awt.event.MouseEvent evt) { 
        results.dispose();  
        Menu frame = new Menu();
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        
    }   
     
    
}