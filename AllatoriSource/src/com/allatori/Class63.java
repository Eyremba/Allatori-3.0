package com.allatori;

import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.InstructionTargeter;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.Type;

public class Class63 implements ObfuscationType {

	private final ClassStorage aClassStorage_1143;

	public Class63(ClassStorage var1) {
		this.aClassStorage_1143 = var1;
	}

	@Override
	public void terminate() {
	}

	@Override
	public void execute(ClassGen var1) {
		final String className = Class180.method1778();
		final String methodName = Class180.method1780();
		if (className != null && methodName != null) {
			if (Class180.method1777().apply(this.aClassStorage_1143, var1)) {
				try {
					final Method[] var4 = var1.getMethods();

					int var5;
					for (int var10000 = var5 = 0; var10000 < var4.length; var10000 = var5) {
						Method var6;
						if ((var6 = var4[var5]).getCode() != null && Class180.method1777().apply(var6)) {
							final MethodGen var7 = InitUtils.createMethodGen(var6, var1.getClassName(),
									var1.getConstantPool(), var1.getConstantPool().getConstantPool());
							final InstructionFactory iFac = new InstructionFactory(var1);
							InstructionList var9;
							final InstructionHandle endHandle = (var9 = var7.getInstructionList()).getEnd();
							InstructionHandle _tmp;
							if (Class180.method1776()) {
								_tmp = var9.insert(endHandle, iFac.createInvoke(className, methodName, Type.VOID,
										new Type[] { Type.OBJECT }, (short) 184));
								_tmp = var9.insert(_tmp, InstructionFactory.createThis());
							} else {
								_tmp = var9.insert(endHandle,
										iFac.createInvoke(className, methodName, Type.VOID, Type.NO_ARGS, (short) 184));
							}

							InstructionTargeter[] var12;
							int var13;
							for (var10000 = var13 = (var12 = endHandle.getTargeters()).length
									- 1; var10000 >= 0; var10000 = var13) {
								var12[var13].updateTarget(endHandle, _tmp);
								--var13;
							}

							var7.setMaxStack();
							var1.replaceMethod(var6, var7.getMethod());
						}

						++var5;
					}
				} catch (final Exception var14) {
					var14.printStackTrace();
				}

			}
		}
	}
}
