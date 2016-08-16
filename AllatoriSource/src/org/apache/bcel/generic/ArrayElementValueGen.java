package org.apache.bcel.generic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.bcel.classfile.ArrayElementValue;
import org.apache.bcel.classfile.ElementValue;

public class ArrayElementValueGen extends ElementValueGen {
	private List evalues;

	public ArrayElementValueGen(ConstantPoolGen cp) {
		super(91, cp);
		evalues = new ArrayList();
	}

	public ArrayElementValueGen(int type, ElementValue[] datums, ConstantPoolGen cpool) {
		super(type, cpool);
		if (type != 91)
			throw new RuntimeException(new StringBuilder()
					.append("Only element values of type array can be built with this ctor - type specified: ")
					.append(type).toString());
		evalues = new ArrayList();
		for (int i = 0; i < datums.length; i++)
			evalues.add(ElementValueGen.copy(datums[i], cpool, true));
	}

	public ElementValue getElementValue() {
		ElementValue[] immutableData = new ElementValue[evalues.size()];
		int i = 0;
		Iterator i$ = evalues.iterator();
		while (i$.hasNext()) {
			ElementValueGen element = (ElementValueGen) i$.next();
			immutableData[i++] = element.getElementValue();
		}
		return new ArrayElementValue(type, immutableData, cpGen.getConstantPool());
	}

	public ArrayElementValueGen(ArrayElementValue value, ConstantPoolGen cpool, boolean copyPoolEntries) {
		super(91, cpool);
		evalues = new ArrayList();
		ElementValue[] in = value.getElementValuesArray();
		for (int i = 0; i < in.length; i++)
			evalues.add(ElementValueGen.copy(in[i], cpool, copyPoolEntries));
	}

	public void dump(DataOutputStream dos) throws IOException {
		dos.writeByte(type);
		dos.writeShort(evalues.size());
		Iterator i$ = evalues.iterator();
		while (i$.hasNext()) {
			ElementValueGen element = (ElementValueGen) i$.next();
			element.dump(dos);
		}
	}

	public String stringifyValue() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		String comma = "";
		Iterator i$ = evalues.iterator();
		while (i$.hasNext()) {
			ElementValueGen element = (ElementValueGen) i$.next();
			sb.append(comma);
			comma = ",";
			sb.append(element.stringifyValue());
		}
		sb.append("]");
		return sb.toString();
	}

	public List getElementValues() {
		return evalues;
	}

	public int getElementValuesSize() {
		return evalues.size();
	}

	public void addElement(ElementValueGen gen) {
		evalues.add(gen);
	}
}