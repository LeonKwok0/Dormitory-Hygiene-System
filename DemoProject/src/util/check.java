package util;
import java.lang.String; 
import javax.swing.*; 
import java.util.regex.*;

public class check {
  public check(String Name,String Password){
	  if((Name).equals("")||(Password).equals("")){
		  JOptionPane.showMessageDialog(null, "the name or password can not be empty");
	  }else {
		  boolean rs=Name.matches("[0-9]{5}");
		  if(rs==false){
		  JOptionPane.showMessageDialog(null,"the format is not right");
		  }else{
			  System.out.println("right");
		  }
	 }
  }
  
  
  
}

