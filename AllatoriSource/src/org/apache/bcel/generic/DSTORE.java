/* DSTORE - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.generic;

public class DSTORE extends StoreInstruction {
	private static final long serialVersionUID = 2593414593903082469L;

	DSTORE() {
		super((short) 57, (short) 71);
	}

	public DSTORE(int n) {
		super((short) 57, (short) 71, n);
	}

	@Override
	public void accept(Visitor v) {
		super.accept(v);
		v.visitDSTORE(this);
	}
}
