package org.apache.bcel.generic;

public class POP extends StackInstruction implements PopInstruction {
	private static final long serialVersionUID = -7366757965427670388L;

	public POP() {
		super((short) 87);
	}

	public void accept(Visitor v) {
		v.visitStackConsumer(this);
		v.visitPopInstruction(this);
		v.visitStackInstruction(this);
		v.visitPOP(this);
	}
}
