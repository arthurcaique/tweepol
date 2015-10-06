/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author W8
 */
public class LimitaNroCaracteres extends PlainDocument {

    private final int iMaxLength;

    public LimitaNroCaracteres(int maxlen) {
        super();
        this.iMaxLength = maxlen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {

        if (this.iMaxLength <= 0) {
            super.insertString(offset, str.toUpperCase(), attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= this.iMaxLength) {
            super.insertString(offset, str.toUpperCase(), attr);
        }
    }

}
