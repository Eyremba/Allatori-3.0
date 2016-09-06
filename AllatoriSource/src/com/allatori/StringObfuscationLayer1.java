package com.allatori;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import org.apache.bcel.classfile.Constant;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.ConstantString;
import org.apache.bcel.classfile.ConstantUtf8;
import org.apache.bcel.classfile.ConstantValue;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.StackMap;
import org.apache.bcel.classfile.StackMapEntry;
import org.apache.bcel.classfile.StackMapType;
import org.apache.bcel.generic.ArrayType;
import org.apache.bcel.generic.BranchHandle;
import org.apache.bcel.generic.BranchInstruction;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.DUP;
import org.apache.bcel.generic.FieldGen;
import org.apache.bcel.generic.IINC;
import org.apache.bcel.generic.InstructionConstants;
import org.apache.bcel.generic.InstructionFactory;
import org.apache.bcel.generic.InstructionHandle;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.LDC_W;
import org.apache.bcel.generic.MethodGen;
import org.apache.bcel.generic.ObjectType;
import org.apache.bcel.generic.POP2;
import org.apache.bcel.generic.PUSH;
import org.apache.bcel.generic.PUTFIELD;
import org.apache.bcel.generic.PUTSTATIC;
import org.apache.bcel.generic.Type;

public class StringObfuscationLayer1 implements ObfuscationType {

	private static String decryptStringMethodName = "DecryptString";
	private boolean addClass = false;
	public static String allatoriString = "allatori-12321-32123:";
	private static String stringDecryptorClassName = "com_allatori_string_decryptor";
	private final Collection<String> collection = new TreeSet<String>();
	private final ClassStorage classStorage;
	private static String decryptString2MethodName = "DecryptString2";

	private void createStrongDecryptMethod(ClassGen classGen) {
		final InstructionFactory instructionFactory = new InstructionFactory(classGen);
		final ConstantPoolGen constantPoolGen = classGen.getConstantPool();
		final InstructionList instructionList = new InstructionList();
		final MethodGen methodGen = new MethodGen(9, Type.STRING, new Type[] { Type.STRING }, new String[] { "s" },
				decryptStringMethodName, classGen.getClassName(), instructionList, constantPoolGen);
		instructionList.append(instructionFactory.createNew("java.lang.String"));
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		instructionList.append(
				instructionFactory.createInvoke("java.lang.String", "length", Type.INT, Type.NO_ARGS, (short) 182));
		instructionList.append(instructionFactory.createNewArray(Type.CHAR, (short) 1));
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(new DUP());
		instructionList.append(new POP2());
		instructionList.append(new PUSH(constantPoolGen, 85));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(InstructionConstants.ARRAYLENGTH);
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(InstructionConstants.ISUB);
		instructionList.append(InstructionConstants.DUP_X2);
		instructionList.append(InstructionFactory.createStore(Type.INT, 3));
		instructionList.append(InstructionFactory.createStore(Type.OBJECT, 1));
		instructionList.append(InstructionFactory.createStore(Type.INT, 2));
		final BranchInstruction branchInstruction = InstructionFactory.createBranchInstruction((short) 155, null);
		final BranchHandle branchHandle = instructionList.append(branchInstruction);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 1));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "charAt", Type.CHAR,
				new Type[] { Type.INT }, (short) 182));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 2));
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(InstructionFactory.createLoad(Type.INT, 2));
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(new PUSH(constantPoolGen, 63));
		instructionList.append(InstructionConstants.IAND);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionFactory.createStore(Type.INT, 2));
		instructionList.append(InstructionConstants.CASTORE);
		instructionList.append(new IINC(3, -1));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		final BranchInstruction branchInstruction0 = InstructionFactory.createBranchInstruction((short) 155, null);
		instructionList.append(branchInstruction0);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 1));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "charAt", Type.CHAR,
				new Type[] { Type.INT }, (short) 182));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 2));
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(InstructionFactory.createLoad(Type.INT, 2));
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(new PUSH(constantPoolGen, 63));
		instructionList.append(InstructionConstants.IAND);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionFactory.createStore(Type.INT, 2));
		instructionList.append(InstructionConstants.CASTORE);
		instructionList.append(new IINC(3, -1));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(InstructionFactory.createBranchInstruction((short) 167, branchHandle));
		final InstructionHandle instructionHandle = instructionList
				.append(InstructionFactory.createLoad(Type.OBJECT, 1));
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "<init>", Type.VOID,
				new Type[] { new ArrayType(Type.CHAR, 1) }, (short) 183));
		instructionList.append(InstructionFactory.createReturn(Type.OBJECT));
		branchInstruction.setTarget(instructionHandle);
		branchInstruction0.setTarget(instructionHandle);
		methodGen.setMaxStack();
		methodGen.setMaxLocals();
		classGen.addMethod(methodGen.getMethod());
		instructionList.dispose();
	}

	private void createWeakDecryptMethod(ClassGen classGen) {
		final InstructionFactory instructionFactory = new InstructionFactory(classGen);
		final ConstantPoolGen constantPoolGen = classGen.getConstantPool();
		final InstructionList instructionList = new InstructionList();
		final MethodGen methodGen = new MethodGen(9, Type.STRING, new Type[] { Type.STRING }, new String[] { "s" },
				decryptStringMethodName, classGen.getClassName(), instructionList, constantPoolGen);
		final int iString = constantPoolGen.addClass("java.lang.String");
		final int iC = constantPoolGen.addClass("[C");
		final int iStack = constantPoolGen.addUtf8("StackMap");
		final ConstantPool constantPool = constantPoolGen.getConstantPool();
		final StackMapEntry stackMapEntry = new StackMapEntry(27, 4,
				new StackMapType[] { new StackMapType((byte) 7, iString, constantPool),
						new StackMapType((byte) 7, iC, constantPool), new StackMapType((byte) 1, 0, constantPool),
						new StackMapType((byte) 1, 0, constantPool) },
				0, new StackMapType[0], constantPool);
		final StackMapEntry stackMapEntry0 = new StackMapEntry(58, 4,
				new StackMapType[] { new StackMapType((byte) 7, iString, constantPool),
						new StackMapType((byte) 7, iC, constantPool), new StackMapType((byte) 1, 0, constantPool),
						new StackMapType((byte) 1, 0, constantPool) },
				0, new StackMapType[0], constantPool);
		final StackMap stackMap = new StackMap(iStack, 30, new StackMapEntry[] { stackMapEntry, stackMapEntry0 },
				constantPool);
		methodGen.addCodeAttribute(stackMap);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		instructionList.append(
				instructionFactory.createInvoke("java.lang.String", "length", Type.INT, Type.NO_ARGS, (short) 182));
		instructionList.append(instructionFactory.createNewArray(Type.CHAR, (short) 1));
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(new DUP());
		instructionList.append(new POP2());
		instructionList.append(InstructionFactory.createStore(Type.OBJECT, 1));
		instructionList.append(new PUSH(constantPoolGen, 85));
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(new DUP());
		instructionList.append(new POP2());
		instructionList.append(InstructionFactory.createStore(Type.INT, 2));
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 1));
		instructionList.append(InstructionConstants.ARRAYLENGTH);
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(new DUP());
		instructionList.append(new POP2());
		instructionList.append(InstructionConstants.ISUB);
		instructionList.append(InstructionFactory.createStore(Type.INT, 3));
		final BranchInstruction branchInstruction = InstructionFactory.createBranchInstruction((short) 167, null);
		instructionList.append(branchInstruction);
		final InstructionHandle instructionHandle = instructionList
				.append(InstructionFactory.createLoad(Type.OBJECT, 1));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "charAt", Type.CHAR,
				new Type[] { Type.INT }, (short) 182));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 2));
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(new DUP());
		instructionList.append(new POP2());
		instructionList.append(InstructionConstants.CASTORE);
		instructionList.append(InstructionFactory.createLoad(Type.INT, 2));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionFactory.createStore(Type.INT, 2));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 2));
		instructionList.append(new PUSH(constantPoolGen, 63));
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(new DUP());
		instructionList.append(new POP2());
		instructionList.append(InstructionConstants.IAND);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionFactory.createStore(Type.INT, 2));
		instructionList.append(new IINC(3, -1));
		final InstructionHandle instructionHandle0 = instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		final BranchInstruction branchInstruction0 = InstructionFactory.createBranchInstruction((short) 156,
				instructionHandle);
		instructionList.append(branchInstruction0);
		instructionList.append(instructionFactory.createNew("java.lang.String"));
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 1));
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "<init>", Type.VOID,
				new Type[] { new ArrayType(Type.CHAR, 1) }, (short) 183));
		instructionList.append(InstructionFactory.createReturn(Type.OBJECT));
		branchInstruction0.setTarget(instructionHandle0);
		methodGen.setMaxStack();
		methodGen.setMaxLocals();
		classGen.addMethod(methodGen.getMethod());
		instructionList.dispose();
	}

	public static String encryptHard(String string, String variableXor) {
		final int lengthString = variableXor.length() - 1;
		int actualChar = variableXor.length() - 1;
		final char[] charArray = new char[string.length()];
		char opcode = 85;
		for (int i = charArray.length - 1; i >= 0; i--) {
			charArray[i] = (char) (string.charAt(i) ^ opcode ^ variableXor.charAt(actualChar));
			opcode = (char) ((char) (opcode ^ i ^ variableXor.charAt(actualChar)) & 63);
			--actualChar;
			if (actualChar < 0) {
				actualChar = lengthString;
			}
		}
		return new String(charArray);
	}

	@Override
	public void terminate() {
		if (this.addClass) {
			this.classStorage.addClass(this.createDecryptionClass());
		}
	}

	@Override
	public void execute(ClassGen classGen) {
		if (Tuning.method1726(this.classStorage, classGen, null) != Tuning.STRING_ENCRYPTION_DISABLE) {
			final InstructionFactory instructionFactory = new InstructionFactory(classGen);
			final Method[] methods = classGen.getMethods();
			for (int i = 0; i < methods.length; i++) {
				Method actualMethod = methods[i];
				if (actualMethod.getCode() != null) {
					MethodGen methodGen = InitUtils.createMethodGen(actualMethod, classGen.getClassName(),
							classGen.getConstantPool(), classGen.getConstantPool().getConstantPool());
					InstructionList instructionList = methodGen.getInstructionList();
					for (InstructionHandle instructionHandle = instructionList
							.getStart(); instructionHandle != null; instructionHandle.getNext()) {
						if (instructionHandle.getInstruction() instanceof LDC_W) {
							final LDC_W ldc_w = (LDC_W) instructionHandle.getInstruction();
							Constant constant = classGen.getConstantPool().getConstant(ldc_w.getIndex());
							if (constant instanceof ConstantString) {
								final String string = ((ConstantUtf8) classGen.getConstantPool()
										.getConstant(((ConstantString) constant).getStringIndex())).getBytes();
								if (this.classStorage.getClassGen(string) != null || this.collection.contains(string)) {
									instructionHandle = instructionHandle.getNext();
									continue;
								}
								int j = Tuning.method1716(this.classStorage, classGen, methodGen);
								String className = classGen.getClassName();
								if (className.startsWith("com.allatori")) {
									if (className.startsWith("com.allatori.obfuscate.opt")) {
										j = Tuning.STRING_ENCRYPTION_DEFAULT_TYPE;
									}
									if (className.startsWith("com.allatori.obfuscate.ren")) {
										j = Tuning.STRING_ENCRYPTION_DEFAULT_TYPE;
									}
									if (className.startsWith("com.allatori.io.re")) {
										j = Tuning.STRING_ENCRYPTION_DEFAULT_TYPE;
									}
								} else if (className.startsWith("org.apache.bcel")) {
									j = Tuning.STRING_ENCRYPTION_DEFAULT_TYPE;
								}
								if (j == Tuning.STRING_ENCRYPTION_STRONG_TYPE) {
									ldc_w.setIndex(classGen.getConstantPool().addString(allatoriString + string));
									instructionList.append(instructionHandle,
											instructionFactory.createInvoke(stringDecryptorClassName,
													decryptString2MethodName, Type.STRING, new Type[] { Type.STRING },
													(short) 184));
								} else {
									ldc_w.setIndex(classGen.getConstantPool().addString(this.encryptWeak(string)));
									instructionList.append(instructionHandle,
											instructionFactory.createInvoke(stringDecryptorClassName,
													decryptStringMethodName, Type.STRING, new Type[] { Type.STRING },
													(short) 184));
								}
								this.addClass = true;
							}
						}
						instructionHandle = instructionHandle.getNext();
					}
					methodGen.setMaxStack();
					classGen.replaceMethod(actualMethod, methodGen.getMethod());
				}
			}
		}
	}

	private String encryptWeak(String string) {
		final char[] obfuscatedString = new char[string.length()];
		char opcode = 85;
		for (int i = obfuscatedString.length - 1; i >= 0; i--) {
			obfuscatedString[i] = (char) (string.charAt(i) ^ opcode);
			opcode = (char) ((char) (opcode ^ i) & 63);
		}
		return new String(obfuscatedString);
	}
	
	/* TODO */

	private void method1366(ClassGen var1) {
		Field[] var2;
		int var3;
		int var10000;
		for (var10000 = var3 = (var2 = var1.getFields()).length - 1; var10000 >= 0; var10000 = var3) {
			ConstantValue var5;
			Constant var6;
			if ((var5 = var2[var3].getConstantValue()) != null && (var6 = var1.getConstantPool()
					.getConstant(var5.getConstantValueIndex())) instanceof ConstantString) {
				final String var7 = ((ConstantUtf8) var1.getConstantPool()
						.getConstant(((ConstantString) var6).getStringIndex())).getBytes();
				this.collection.add(var7);
			}

			--var3;
		}

		Method[] var4;
		int var15;
		for (var10000 = var15 = (var4 = var1.getMethods()).length - 1; var10000 >= 0; var10000 = var15) {
			Method var16;
			if ((var16 = var4[var15]).getCode() != null) {
				InstructionHandle var9 = InitUtils.createMethodGen(var16, var1.getClassName(), var1.getConstantPool(),
						var1.getConstantPool().getConstantPool()).getInstructionList().getStart();

				for (InstructionHandle var14 = var9; var14 != null; var14 = var9) {
					if ((var9.getInstruction() instanceof PUTSTATIC || var9.getInstruction() instanceof PUTFIELD)
							&& var9.getPrev() != null) {
						final InstructionHandle var10 = var9.getPrev();
						if (var10.getInstruction() instanceof LDC_W) {
							final LDC_W var11 = (LDC_W) var10.getInstruction();
							final Constant var12 = var1.getConstantPool().getConstant(var11.getIndex());
							if (var12 instanceof ConstantString) {
								final String var13 = ((ConstantUtf8) var1.getConstantPool()
										.getConstant(((ConstantString) var12).getStringIndex())).getBytes();
								this.collection.add(var13);
							}
						}
					}

					var9 = var9.getNext();
				}
			}

			--var15;
		}

	}

	private void method1367(ClassGen var1) {
		Field[] var2;
		int var3;
		for (int var10000 = var3 = (var2 = var1.getFields()).length - 1; var10000 >= 0; var10000 = var3) {
			Field var4;
			ConstantValue var5;
			Constant var6;
			if ((var5 = (var4 = var2[var3]).getConstantValue()) != null && (var6 = var1.getConstantPool()
					.getConstant(var5.getConstantValueIndex())) instanceof ConstantString && var4.isFinal()) {
				if (!var4.isStatic()) {
					FieldGen var15;
					(var15 = new FieldGen(var4, var1.getConstantPool())).cancelInitValue();
					var1.replaceField(var4, var15.getField());
				} else {
					Method clinit = null;

					Method[] var8;
					int var9;
					for (var10000 = var9 = (var8 = var1.getMethods()).length - 1; var10000 >= 0; var10000 = var9) {
						final Method var10 = var8[var9];
						if ("<clinit>".equals(var10.getName())) {
							clinit = var10;
							break;
						}

						--var9;
					}

					InstructionList var11;
					(var11 = new InstructionList()).insert(InstructionFactory.createReturn(Type.VOID));
					MethodGen var16;
					if (clinit != null) {
						var11 = (var16 = InitUtils.createMethodGen(clinit, var1.getClassName(), var1.getConstantPool(),
								var1.getConstantPool().getConstantPool())).getInstructionList();
					} else {
						var16 = new MethodGen(8, Type.VOID, Type.NO_ARGS, new String[0], "<clinit>",
								var1.getClassName(), var11, var1.getConstantPool());
					}

					final String var12 = ((ConstantUtf8) var1.getConstantPool()
							.getConstant(((ConstantString) var6).getStringIndex())).getBytes();
					final InstructionFactory var13 = new InstructionFactory(var1);
					var11.insert(
							var13.createFieldAccess(var1.getClassName(), var4.getName(), Type.STRING, (short) 179));
					var11.insert(new PUSH(var1.getConstantPool(), var12));
					var16.setMaxStack();
					var16.setMaxLocals();
					if (clinit != null) {
						var1.replaceMethod(clinit, var16.getMethod());
					} else {
						var1.addMethod(var16.getMethod());
					}

					var11.dispose();
					FieldGen var14;
					(var14 = new FieldGen(var4, var1.getConstantPool())).cancelInitValue();
					var1.replaceField(var4, var14.getField());
				}
			}

			--var3;
		}

	}

	private ClassGen createDecryptionClass() {
		final ClassGen classGen = new ClassGen(stringDecryptorClassName, "java.lang.Object", "", 33, new String[0]);
		if (Tuning.isWeakStringEncryption()) {
			this.createWeakDecryptMethod(classGen);
		} else {
			this.createStrongDecryptMethod(classGen);
			this.createStrongDecrypt2Method(classGen);
		}
		return classGen;
	}

	public StringObfuscationLayer1(ClassStorage classStorage) {
		this.classStorage = classStorage;
		for (Iterator<?> iterator = classStorage.iterator(); iterator.hasNext(); iterator.next()) {
			final ClassGen classGen = (ClassGen) iterator.next();
			int stringEncryption = Tuning.method1726(classStorage, classGen, null);
			if (stringEncryption == Tuning.STRING_ENCRYPTION_DEFAULT) {
				this.method1366(classGen);
			} else if (stringEncryption == Tuning.STRING_ENCRYPTION_MAXIMUM) {
				this.method1367(classGen);
			}
		}
	}

	private void createStrongDecrypt2Method(ClassGen classGen) {
		final InstructionFactory instructionFactory = new InstructionFactory(classGen);
		final ConstantPoolGen constantPoolGen = classGen.getConstantPool();
		final InstructionList instructionList = new InstructionList();
		final MethodGen methodGen = new MethodGen(9, Type.STRING, new Type[] { Type.STRING }, new String[] { "arg0" },
				decryptString2MethodName, classGen.getClassName(), instructionList, constantPoolGen);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		instructionList.append(new PUSH(constantPoolGen, 1));
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(InstructionConstants.DUP_X2);
		instructionList.append(instructionFactory.createNew("java.lang.Exception"));
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(instructionFactory.createInvoke("java.lang.Exception", "<init>", Type.VOID, Type.NO_ARGS, (short) 183));
		instructionList.append(instructionFactory.createInvoke("java.lang.Exception", "getStackTrace",
				new ArrayType(new ObjectType("java.lang.StackTraceElement"), 1), Type.NO_ARGS, (short) 182));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.AALOAD);
		instructionList.append(instructionFactory.createNew("java.lang.StringBuffer"));
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(instructionFactory.createInvoke("java.lang.StringBuffer", "<init>", Type.VOID, Type.NO_ARGS, (short) 183));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(instructionFactory.createInvoke("java.lang.StackTraceElement", "getClassName", Type.STRING, Type.NO_ARGS,
				(short) 182));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(instructionFactory.createInvoke("java.lang.StackTraceElement", "getMethodName", Type.STRING, Type.NO_ARGS,
				(short) 182));
		instructionList.append(InstructionConstants.DUP_X2);
		instructionList.append(InstructionConstants.POP);
		instructionList.append(instructionFactory.createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, new Type[] { Type.STRING },
				(short) 182));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(instructionFactory.createInvoke("java.lang.StringBuffer", "append", Type.STRINGBUFFER, new Type[] { Type.STRING },
				(short) 182));
		instructionList.append(instructionFactory.createInvoke("java.lang.StringBuffer", "toString", Type.STRING, Type.NO_ARGS, (short) 182));
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "length", Type.INT, Type.NO_ARGS, (short) 182));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.ISUB);
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(InstructionFactory.createStore(Type.INT, 3));
		instructionList.append(InstructionFactory.createStore(Type.OBJECT, 2));
		instructionList.append(InstructionFactory.createStore(Type.INT, 4));
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "length", Type.INT, Type.NO_ARGS, (short) 182));
		instructionList.append(InstructionConstants.DUP);
		instructionList.append(instructionFactory.createNewArray(Type.CHAR, (short) 1));
		instructionList.append(InstructionFactory.createStore(Type.OBJECT, 5));
		instructionList.append(new PUSH(constantPoolGen, 85));
		instructionList.append(InstructionFactory.createStore(Type.INT, 6));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.ISUB);
		instructionList.append(InstructionFactory.createStore(Type.INT, 7));
		final BranchInstruction branchInstruction = InstructionFactory.createBranchInstruction((short) 167, null);
		instructionList.append(branchInstruction);
		final InstructionHandle instructionHandle = instructionList.append(new PUSH(constantPoolGen, 63));
		instructionList.append(InstructionConstants.DUP_X2);
		instructionList.append(InstructionConstants.POP);
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(InstructionConstants.POP);
		instructionList.append(InstructionFactory.createLoad(Type.INT, 6));
		instructionList.append(InstructionConstants.DUP_X2);
		instructionList.append(InstructionConstants.POP);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 2));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 4));
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "charAt", Type.CHAR, new Type[] { Type.INT }, (short) 182));
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(InstructionFactory.createLoad(Type.INT, 7));
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 0));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "charAt", Type.CHAR, new Type[] { Type.INT }, (short) 182));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 6));
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionConstants.CASTORE);
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.IXOR);
		instructionList.append(InstructionConstants.IAND);
		instructionList.append(InstructionConstants.I2C);
		instructionList.append(InstructionFactory.createStore(Type.INT, 6));
		instructionList.append(new IINC(4, -1));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 4));
		final BranchInstruction branchInstruction0 = InstructionFactory.createBranchInstruction((short) 156, null);
		instructionList.append(branchInstruction0);
		instructionList.append(InstructionFactory.createLoad(Type.INT, 3));
		instructionList.append(InstructionFactory.createStore(Type.INT, 4));
		final InstructionHandle instructionHandle0 = instructionList.append(new IINC(7, -1));
		final InstructionHandle instructionHandle1 = instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 5));
		instructionList.append(InstructionFactory.createLoad(Type.INT, 7));
		instructionList.append(InstructionConstants.DUP);
		final BranchInstruction branchInstruction1 = InstructionFactory.createBranchInstruction((short) 156, instructionHandle);
		instructionList.append(branchInstruction1);
		instructionList.append(InstructionConstants.POP2);
		instructionList.append(instructionFactory.createNew("java.lang.String"));
		instructionList.append(InstructionFactory.createLoad(Type.OBJECT, 5));
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(InstructionConstants.DUP_X1);
		instructionList.append(InstructionConstants.SWAP);
		instructionList.append(instructionFactory.createInvoke("java.lang.String", "<init>", Type.VOID, new Type[] { new ArrayType(Type.CHAR, 1) },
				(short) 183));
		instructionList.append(InstructionFactory.createReturn(Type.OBJECT));
		branchInstruction.setTarget(instructionHandle1);
		branchInstruction0.setTarget(instructionHandle0);
		methodGen.setMaxStack();
		methodGen.setMaxLocals();
		classGen.addMethod(methodGen.getMethod());
		instructionList.dispose();
	}

}
