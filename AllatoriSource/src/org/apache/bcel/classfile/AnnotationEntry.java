/* AnnotationEntry - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.classfile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.bcel.Constants;

public class AnnotationEntry implements Node, Constants, Serializable
{
    private static final long serialVersionUID = 1L;
    private final int type_index;
    private final ConstantPool constant_pool;
    private final boolean isRuntimeVisible;
    private List element_value_pairs;
    
    public static AnnotationEntry read
	(DataInputStream file, ConstantPool constant_pool,
	 boolean isRuntimeVisible)
	throws IOException {
	AnnotationEntry annotationEntry
	    = new AnnotationEntry(file.readUnsignedShort(), constant_pool,
				  isRuntimeVisible);
	int num_element_value_pairs = file.readUnsignedShort();
	annotationEntry.element_value_pairs = new ArrayList();
	for (int i = 0; i < num_element_value_pairs; i++)
	    annotationEntry.element_value_pairs.add
		(new ElementValuePair
		 (file.readUnsignedShort(),
		  ElementValue.readElementValue(file, constant_pool),
		  constant_pool));
	return annotationEntry;
    }
    
    public AnnotationEntry(int type_index, ConstantPool constant_pool,
			   boolean isRuntimeVisible) {
	this.type_index = type_index;
	this.constant_pool = constant_pool;
	this.isRuntimeVisible = isRuntimeVisible;
    }
    
    public int getTypeIndex() {
	return type_index;
    }
    
    public ConstantPool getConstantPool() {
	return constant_pool;
    }
    
    public boolean isRuntimeVisible() {
	return isRuntimeVisible;
    }
    
    public void accept(Visitor v) {
	/* empty */
    }
    
    public String getAnnotationType() {
	ConstantUtf8 c
	    = (ConstantUtf8) constant_pool.getConstant(type_index, (byte) 1);
	return c.getBytes();
    }
    
    public int getAnnotationTypeIndex() {
	return type_index;
    }
    
    public final int getNumElementValuePairs() {
	return element_value_pairs.size();
    }
    
    public ElementValuePair[] getElementValuePairs() {
	return ((ElementValuePair[])
		element_value_pairs.toArray(new ElementValuePair
					    [element_value_pairs.size()]));
    }
    
    public void dump(DataOutputStream dos) throws IOException {
	dos.writeShort(type_index);
	dos.writeShort(element_value_pairs.size());
	for (int i = 0; i < element_value_pairs.size(); i++) {
	    ElementValuePair envp
		= (ElementValuePair) element_value_pairs.get(i);
	    envp.dump(dos);
	}
    }
    
    public void addElementNameValuePair
	(ElementValuePair elementNameValuePair) {
	element_value_pairs.add(elementNameValuePair);
    }
    
    public String toShortString() {
	StringBuilder result = new StringBuilder();
	result.append("@");
	result.append(getAnnotationType());
	if (getElementValuePairs().length > 0) {
	    result.append("(");
	    for (int i = 0; i < getElementValuePairs().length; i++) {
		ElementValuePair element = getElementValuePairs()[i];
		result.append(element.toShortString());
	    }
	    result.append(")");
	}
	return result.toString();
    }
}
