/* LDC - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.generic;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.bcel.ExceptionConstants;
import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantFloat;
import org.apache.bcel.classfile.ConstantInteger;
import org.apache.bcel.classfile.ConstantString;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.util.ByteSequence;

public class LDC extends CPInstruction
    implements PushInstruction, ExceptionThrower
{
    private static final long serialVersionUID = -972820476154330719L;
    
    LDC() {
	/* empty */
    }
    
    public LDC(int index) {
	super((short) 19, index);
	setSize();
    }
    
    protected final void setSize() {
	if (index <= 255) {
	    opcode = (short) 18;
	    length = (short) 2;
	} else {
	    opcode = (short) 19;
	    length = (short) 3;
	}
    }
    
    public void dump(DataOutputStream out) throws IOException {
	out.writeByte(opcode);
	if (length == 2)
	    out.writeByte(index);
	else
	    out.writeShort(index);
    }
    
    public final void setIndex(int index) {
	super.setIndex(index);
	setSize();
    }
    
    protected void initFromFile(ByteSequence bytes, boolean wide)
	throws IOException {
	length = (short) 2;
	index = bytes.readUnsignedByte();
    }
    
    public Object getValue(ConstantPoolGen cpg) {
	Constant c = cpg.getConstantPool().getConstant(index);
	switch (c.getTag()) {
	case 8: {
	    int i = ((ConstantString) c).getStringIndex();
	    c = cpg.getConstantPool().getConstant(i);
	    return ((ConstantUtf8) c).getBytes();
	}
	case 4:
	    return new Float(((ConstantFloat) c).getBytes());
	case 3:
	    return Integer.valueOf(((ConstantInteger) c).getBytes());
	case 7: {
	    int nameIndex = ((ConstantClass) c).getNameIndex();
	    c = cpg.getConstantPool().getConstant(nameIndex);
	    return new ObjectType(((ConstantUtf8) c).getBytes());
	}
	default:
	    throw new RuntimeException
		      (new StringBuilder().append
			   ("Unknown or invalid constant type at ").append
			   (index).toString());
	}
    }
    
    public Type getType(ConstantPoolGen cpg) {
	switch (cpg.getConstantPool().getConstant(index).getTag()) {
	case 8:
	    return Type.STRING;
	case 4:
	    return Type.FLOAT;
	case 3:
	    return Type.INT;
	case 7:
	    return Type.CLASS;
	default:
	    throw new RuntimeException
		      (new StringBuilder().append
			   ("Unknown or invalid constant type at ").append
			   (index).toString());
	}
    }
    
    public Class[] getExceptions() {
	return ExceptionConstants.EXCS_STRING_RESOLUTION;
    }
    
    public void accept(Visitor v) {
	v.visitStackProducer(this);
	v.visitPushInstruction(this);
	v.visitExceptionThrower(this);
	v.visitTypedInstruction(this);
	v.visitCPInstruction(this);
	v.visitLDC(this);
    }
}
