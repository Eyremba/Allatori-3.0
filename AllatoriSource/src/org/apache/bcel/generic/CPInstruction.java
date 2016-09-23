package org.apache.bcel.generic;

import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.bcel.Constants;
import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantClass;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.util.ByteSequence;

public abstract class CPInstruction extends Instruction implements TypedInstruction, IndexedInstruction {
	private static final long serialVersionUID = 2968547649792233082L;
	protected int index;

	CPInstruction() {
		/* empty */
	}

	protected CPInstruction(short opcode, int index) {
		super(opcode, (short) 3);
		setIndex(index);
	}

	@Override
	public void dump(DataOutputStream out) throws IOException {
		out.writeByte(opcode);
		out.writeShort(index);
	}

	@Override
	public String toString(boolean verbose) {
		return new StringBuilder().append(super.toString(verbose)).append(" ").append(index).toString();
	}

	@Override
	public String toString(ConstantPool cp) {
		final Constant c = cp.getConstant(index);
		String str = cp.constantToString(c);
		if (c instanceof ConstantClass)
			str = str.replace('.', '/');
		return new StringBuilder().append(Constants.OPCODE_NAMES[opcode]).append(" ").append(str).toString();
	}

	@Override
	protected void initFromFile(ByteSequence bytes, boolean wide) throws IOException {
		setIndex(bytes.readUnsignedShort());
		length = (short) 3;
	}

	@Override
	public final int getIndex() {
		return index;
	}

	@Override
	public void setIndex(int index) {
		if (index < 0)
			throw new ClassGenException(new StringBuilder().append("Negative index value: ").append(index).toString());
		this.index = index;
	}

	@Override
	public Type getType(ConstantPoolGen cpg) {
		final ConstantPool cp = cpg.getConstantPool();
		String name = cp.getConstantString(index, (byte) 7);
		if (!name.startsWith("["))
			name = new StringBuilder().append("L").append(name).append(";").toString();
		return Type.getType(name);
	}
}
