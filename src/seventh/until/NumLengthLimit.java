package seventh.until;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/** �����ı������볤��
 * @author Jachin
 *	ʹ�÷������ı������.setDocument(new NumLengthLimit())
 *			Ĭ�����볤��Ϊ10��Ҳ���Դ����Լ���Ҫ�ĳ��ȡ�
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
