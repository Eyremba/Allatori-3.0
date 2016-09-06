/* IADD - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.generic;

public class IADD extends ArithmeticInstruction
{
    private static final long serialVersionUID = 8749750216946526117L;
    
    public IADD() {
	super((short) 96);
    }
    
    public void accept(Visitor v) {
	v.visitTypedInstruction(this);
	v.visitStackProducer(this);
	v.visitStackConsumer(this);
	v.visitArithmeticInstruction(this);
	v.visitIADD(this);
    }
}
