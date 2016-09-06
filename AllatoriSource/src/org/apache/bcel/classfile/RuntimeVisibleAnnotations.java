/* RuntimeVisibleAnnotations - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.classfile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class RuntimeVisibleAnnotations extends Annotations
{
    private static final long serialVersionUID = 8992333017010665281L;
    
    public RuntimeVisibleAnnotations
	(int name_index, int length, DataInputStream file,
	 ConstantPool constant_pool)
	throws IOException {
	super((byte) 12, name_index, length, file, constant_pool, true);
    }
    
    public Attribute copy(ConstantPool constant_pool) {
	Annotations c = (Annotations) clone();
	return c;
    }
    
    public final void dump(DataOutputStream dos) throws IOException {
	super.dump(dos);
	writeAnnotations(dos);
    }
}
