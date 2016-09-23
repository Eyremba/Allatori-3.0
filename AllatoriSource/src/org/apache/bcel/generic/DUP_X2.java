package org.apache.bcel.generic;

public class DUP_X2 extends StackInstruction {
	private static final long serialVersionUID = -8851562833314313571L;

	public DUP_X2() {
		super((short) 91);
	}

	@Override
	public void accept(Visitor v) {
		v.visitStackInstruction(this);
		v.visitDUP_X2(this);
	}
}
