/* I2S - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.generic;

public class I2S extends ConversionInstruction {
	private static final long serialVersionUID = -2414292630144687091L;

	public I2S() {
		super((short) 147);
	}

	@Override
	public void accept(Visitor v) {
		v.visitTypedInstruction(this);
		v.visitStackProducer(this);
		v.visitStackConsumer(this);
		v.visitConversionInstruction(this);
		v.visitI2S(this);
	}
}
