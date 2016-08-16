/* Field - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.classfile;
import java.io.DataInputStream;
import java.io.IOException;

import org.apache.bcel.generic.Type;
import org.apache.bcel.util.BCELComparator;

public final class Field extends FieldOrMethod
{
    private static final long serialVersionUID = -4604082205545049134L;
    private static BCELComparator _cmp = new BCELComparator() {
	public boolean equals(Object o1, Object o2) {
	    Field THIS = (Field) o1;
	    Field THAT = (Field) o2;
	    return (THIS.getName().equals(THAT.getName())
		    && THIS.getSignature().equals(THAT.getSignature()));
	}
	
	public int hashCode(Object o) {
	    Field THIS = (Field) o;
	    return THIS.getSignature().hashCode() ^ THIS.getName().hashCode();
	}
    };
    
    public Field(Field c) {
	super((FieldOrMethod) c);
    }
    
    Field(DataInputStream file, ConstantPool constant_pool)
	throws IOException, ClassFormatException {
	super(file, constant_pool);
    }
    
    public Field(int access_flags, int name_index, int signature_index,
		 Attribute[] attributes, ConstantPool constant_pool) {
	super(access_flags, name_index, signature_index, attributes,
	      constant_pool);
    }
    
    public void accept(Visitor v) {
	v.visitField(this);
    }
    
    public final ConstantValue getConstantValue() {
	for (int i = 0; i < attributes_count; i++) {
	    if (attributes[i].getTag() == 1)
		return (ConstantValue) attributes[i];
	}
	return null;
    }
    
    public final String toString() {
	String access = Utility.accessToString(access_flags);
	access = (access.equals("") ? ""
		  : new StringBuilder().append(access).append(" ").toString());
	String signature = Utility.signatureToString(getSignature());
	String name = getName();
	StringBuilder buf = new StringBuilder(64);
	buf.append(access).append(signature).append(" ").append(name);
	ConstantValue cv = getConstantValue();
	if (cv != null)
	    buf.append(" = ").append(cv);
	for (int i = 0; i < attributes_count; i++) {
	    Attribute a = attributes[i];
	    if (!(a instanceof ConstantValue))
		buf.append(" [").append(a.toString()).append("]");
	}
	return buf.toString();
    }
    
    public final Field copy(ConstantPool _constant_pool) {
	return (Field) copy_(_constant_pool);
    }
    
    public Type getType() {
	return Type.getReturnType(getSignature());
    }
    
    public static BCELComparator getComparator() {
	return _cmp;
    }
    
    public static void setComparator(BCELComparator comparator) {
	_cmp = comparator;
    }
    
    public boolean equals(Object obj) {
	return _cmp.equals(this, obj);
    }
    
    public int hashCode() {
	return _cmp.hashCode(this);
    }
}
