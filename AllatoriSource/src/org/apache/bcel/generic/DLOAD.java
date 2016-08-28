package org.apache.bcel.generic;

public class DLOAD extends LoadInstruction {
	private static final long serialVersionUID = -197027701448834250L;

	DLOAD() {
		super((short) 24, (short) 38);
	}

	public DLOAD(int n) {
		super((short) 24, (short) 38, n);
	}

	@Override
	public void accept(Visitor v) {
		super.accept(v);
		v.visitDLOAD(this);
	}
}
