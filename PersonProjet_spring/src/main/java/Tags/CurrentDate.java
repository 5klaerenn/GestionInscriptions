package Tags;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sklaerenn
 */
public class CurrentDate extends TagSupport {
    
    public int doStartTag() throws JspException {
       
        Date curentDate =new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String curentDatef= DateFor.format(curentDate);    
        JspWriter out=pageContext.getOut();//returns the instance of JspWriter
   
        try{
            out.print(curentDatef);//printing date and time using JspWriter
       } catch(Exception e){
           System.out.println(e);
       }
        
       return SKIP_BODY;//will not evaluate the body content of the tag
}  
  }
