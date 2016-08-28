package org.apache.bcel.generic;

public class IF_ICMPNE extends IfInstruction {
	private static final long serialVersionUID = -3908465635973274661L;

	IF_ICMPNE() {
	}

	public IF_ICMPNE(InstructionHandle target) {
		super((short) 160, target);
	}

	@Override
	public IfInstruction negate() {
		return new IF_ICMPEQ(target);
	}

	@Override
	public void accept(Visitor v) {
		v.visitStackConsumer(this);
		v.visitBranchInstruction(this);
		v.visitIfInstruction(this);
		v.visitIF_ICMPNE(this);
	}
}
