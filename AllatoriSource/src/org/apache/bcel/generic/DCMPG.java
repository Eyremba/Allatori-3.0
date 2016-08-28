package org.apache.bcel.generic;

public class DCMPG extends Instruction implements TypedInstruction, StackProducer, StackConsumer {
	private static final long serialVersionUID = 1929664840821745262L;

	public DCMPG() {
		super((short) 152, (short) 1);
	}

	@Override
	public Type getType(ConstantPoolGen cp) {
		return Type.DOUBLE;
	}

	@Override
	public void accept(Visitor v) {
		v.visitTypedInstruction(this);
		v.visitStackProducer(this);
		v.visitStackConsumer(this);
		v.visitDCMPG(this);
	}
}
