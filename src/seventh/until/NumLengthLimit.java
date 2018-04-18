package seventh.until;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/** 限制文本框输入长度
 * @author Jachin
 *	使用方法：文本框对象.setDocument(new NumLengthLimit())
 *			默认输入长度为10，也可以传入自己想要的长度。
 */
public class NumLengthLimit extends PlainDocument{
	private int maxLength;  
    public NumLengthLimit(int newMaxLength)  
    {  
        super();  
        maxLength=newMaxLength;  
    }  
    public NumLengthLimit()  
    {  
        this(10);  
    }  
    public void insertString(int offset,String str,javax.swing.text.AttributeSet a) throws BadLocationException  
    {  
        if(getLength()+str.length()>maxLength)  
        {  
            return;  
        }  
        else  
        {  
            super.insertString(offset, str,a);  
        }  
    }  
}
