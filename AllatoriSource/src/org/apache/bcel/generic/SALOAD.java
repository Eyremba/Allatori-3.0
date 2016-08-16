/* SALOAD - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.generic;

public class SALOAD extends ArrayInstruction implements StackProducer
{
    private static final long serialVersionUID = 7178769326864697416L;
    
    public SALOAD() {
	super((short) 53);
    }
    
    public void accept(Visitor v) {
	v.visitStackProducer(this);
	v.visitExceptionThrower(this);
	v.visitTypedInstruction(this);
	v.visitArrayInstruction(this);
	v.visitSALOAD(this);
    }
}
