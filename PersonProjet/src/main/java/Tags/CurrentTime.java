package Tags;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Sklaerenn
 */
public class CurrentTime extends TagSupport {
    
    public int doStartTag() throws JspException {
       
        Date curentDate = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("HH:mm:ss");
        String curentDatef= DateFor.format(curentDate);    
        JspWriter out = pageContext.getOut();//returns the instance of JspWriter
   
        try{
            out.print(curentDatef);//printing date and time using JspWriter
       } catch(Exception e){
           System.out.println(e);
       }
        
       return SKIP_BODY;//will not evaluate the body content of the tag
}  

}
