package frame;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class addname extends JFrame {
	public static  String name="无名";
	public static  String [] players_name;
	public static int players_score[];
	
public static mainPanel panel=null;
   public addname() {
	   players_name=new String[10];
	   players_score= new int [10];
	    for(int i=0;i<10;i++) {
	    	players_name[i]="无记录";
	    	players_score[i]=0;
	    }
		setLayout(new FlowLayout());
	   setTitle("记录");
	   setBounds(600, 100, 400, 100);
	   TextField tf = new TextField(20);
	   JButton bu = new JButton("提交");
	   Label l=new Label("请输入玩家名称:");

	   tf.setSize(150, 100);
	   bu.setSize(50, 100);
	   add(l);
	   add(tf);
	   add(bu);
	   bu.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {

               
        	   tf.requestFocus();
               tf.setText("");
               String tf_str = tf.getText();
               name=tf_str.trim();
              panel.setEnabled(true);
               dispose();
              
           }
       });
	   setVisible(true);

   }
   public static void getName_score() {
	     try {
	    	 int r=0;
             BufferedReader reader = new BufferedReader(new FileReader("player_score.csv"));
             String line = null; 
             while((line=reader.readLine())!=null){ 
                 String item[] = line.split(",");
              
                 String name = item[0];
                 players_name[r]=name.trim();
                 String score_1=item[1];
                // System.out.println(name);
                 int value = Integer.parseInt(score_1.trim());
                players_score[r]=value;
                 r++;
             } 
         } catch (Exception e) { 
             e.printStackTrace(); 
         }
   }
   public static void addName_score() {
	   getName_score();
	   int i=0;
	   for (;i<10;i++) {
		  if(players_score[i]<panel.score) {
			  break;
		  }
		  
	   }
	   for (int j=9;j>i;j--) {
		   players_score[j]=players_score[j-1];
		   players_name[j]=players_name[j-1];
	   }
	   if(i<10) {
		   players_score[i]=panel.score;
		   players_name[i]=name;  
	   }
	   try { 
	          File csv = new File("player_score.csv"); 
	    
	          BufferedWriter bw = new BufferedWriter(new FileWriter(csv)); // 附加
	       
	          for (int j=0;j<10;j++) {
	        	  bw.write(players_name[j]+","+players_score[j]); 
		         bw.newLine();  
	          }
	         
	          bw.close(); 
	    
	        } catch (FileNotFoundException e) { 
	          e.printStackTrace(); 
	        } catch (IOException e) { 
	          e.printStackTrace(); 
	        } 
	      }
	   
	 
	 
   }

