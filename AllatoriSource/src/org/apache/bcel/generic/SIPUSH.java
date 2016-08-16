/* SIPUSH - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.generic;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.bcel.util.ByteSequence;

public class SIPUSH extends Instruction implements ConstantPushInstruction
{
    private static final long serialVersionUID = -5670145672311191256L;
    private short b;
    
    SIPUSH() {
	/* empty */
    }
    
    public SIPUSH(short b) {
	super((short) 17, (short) 3);
	this.b = b;
    }
    
    public void dump(DataOutputStream out) throws IOException {
	super.dump(out);
	out.writeShort(b);
    }
    
    public String toString(boolean verbose) {
	return new StringBuilder().append(super.toString(verbose)).append
		   (" ").append
		   (b).toString();
    }
    
    protected void initFromFile(ByteSequence bytes, boolean wide)
	throws IOException {
	length = (short) 3;
	b = bytes.readShort();
    }
    
    public Number getValue() {
	return Integer.valueOf(b);
    }
    
    public Type getType(ConstantPoolGen cp) {
	return Type.SHORT;
    }
    
    public void accept(Visitor v) {
	v.visitPushInstruction(this);
	v.visitStackProducer(this);
	v.visitTypedInstruction(this);
	v.visitConstantPushInstruction(this);
	v.visitSIPUSH(this);
    }
}
