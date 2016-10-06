package org.apache.bcel.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.bcel.classfile.AccessFlags;
import org.apache.bcel.classfile.AnnotationEntry;
import org.apache.bcel.classfile.Annotations;
import org.apache.bcel.classfile.Attribute;
import org.apache.bcel.classfile.ConstantPool;
import org.apache.bcel.classfile.Field;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.classfile.RuntimeInvisibleAnnotations;
import org.apache.bcel.classfile.RuntimeVisibleAnnotations;
import org.apache.bcel.classfile.SourceFile;
import org.apache.bcel.classfile.Utility;
import org.apache.bcel.util.BCELComparator;

public class ClassGen extends AccessFlags implements Cloneable {
	private static final long serialVersionUID = 6880879387392827211L;
	private String class_name;
	private String super_class_name;
	private final String file_name;
	private int class_name_index = -1;
	private int superclass_name_index = -1;
	private int major = 45;
	private int minor = 3;
	private ConstantPoolGen cp;
	private final List<Field> field_vec;
	private final List<Method> method_vec;
	private final List<Attribute> attribute_vec;
	private final List<String> interface_vec;
	private final List<AnnotationEntryGen> annotation_vec;
	private static BCELComparator _cmp = new BCELComparator() {
		@Override
		public boolean equals(Object o1, Object o2) {
			final ClassGen THIS = (ClassGen) o1;
			final ClassGen THAT = (ClassGen) o2;
			return THIS.getClassName().equals(THAT.getClassName());
		}

		@Override
		public int hashCode(Object o) {
			final ClassGen THIS = (ClassGen) o;
			return THIS.getClassName().hashCode();
		}
	};
	private List<ClassObserver> observers;

	public ClassGen(String class_name, String super_class_name, String file_name, int access_flags, String[] interfaces,
			ConstantPoolGen cp) {
		field_vec = new ArrayList<Field>();
		method_vec = new ArrayList<Method>();
		attribute_vec = new ArrayList<Attribute>();
		interface_vec = new ArrayList<String>();
		annotation_vec = new ArrayList<AnnotationEntryGen>();
		this.class_name = class_name;
		this.super_class_name = super_class_name;
		this.file_name = file_name;
		this.access_flags = access_flags;
		this.cp = cp;
		if (file_name != null)
			addAttribute(new SourceFile(cp.addUtf8("SourceFile"), 2, cp.addUtf8(file_name), cp.getConstantPool()));
		class_name_index = cp.addClass(class_name);
		superclass_name_index = cp.addClass(super_class_name);
		if (interfaces != null) {
			for (int i = 0; i < interfaces.length; i++)
				addInterface(interfaces[i]);
		}
	}

	public ClassGen(String class_name, String super_class_name, String file_name, int access_flags,
			String[] interfaces) {
		this(class_name, super_class_name, file_name, access_flags, interfaces, new ConstantPoolGen());
	}

	public ClassGen(JavaClass clazz) {
		field_vec = new ArrayList<Field>();
		method_vec = new ArrayList<Method>();
		attribute_vec = new ArrayList<Attribute>();
		interface_vec = new ArrayList<String>();
		annotation_vec = new ArrayList<AnnotationEntryGen>();
		class_name_index = clazz.getClassNameIndex();
		superclass_name_index = clazz.getSuperclassNameIndex();
		class_name = clazz.getClassName();
		super_class_name = clazz.getSuperclassName();
		file_name = clazz.getSourceFileName();
		access_flags = clazz.getAccessFlags();
		cp = new ConstantPoolGen(clazz.getConstantPool());
		major = clazz.getMajor();
		minor = clazz.getMinor();
		final Attribute[] attributes = clazz.getAttributes();
		final AnnotationEntryGen[] annotations = unpackAnnotations(attributes);
		final Method[] methods = clazz.getMethods();
		final Field[] fields = clazz.getFields();
		final String[] interfaces = clazz.getInterfaceNames();
		for (int i = 0; i < interfaces.length; i++)
			addInterface(interfaces[i]);
		for (int i = 0; i < attributes.length; i++) {
			if (!(attributes[i] instanceof Annotations))
				addAttribute(attributes[i]);
		}
		for (int i = 0; i < annotations.length; i++)
			addAnnotationEntry(annotations[i]);
		for (int i = 0; i < methods.length; i++)
			addMethod(methods[i]);
		for (int i = 0; i < fields.length; i++)
			addField(fields[i]);
	}

	private AnnotationEntryGen[] unpackAnnotations(Attribute[] attrs) {
		final List<AnnotationEntryGen> annotationGenObjs = new ArrayList<AnnotationEntryGen>();
		for (int i = 0; i < attrs.length; i++) {
			final Attribute attr = attrs[i];
			if (attr instanceof RuntimeVisibleAnnotations) {
				final RuntimeVisibleAnnotations rva = (RuntimeVisibleAnnotations) attr;
				final AnnotationEntry[] annos = rva.getAnnotationEntries();
				for (int j = 0; j < annos.length; j++) {
					final AnnotationEntry a = annos[j];
					annotationGenObjs.add(new AnnotationEntryGen(a, getConstantPool(), false));
				}
			} else if (attr instanceof RuntimeInvisibleAnnotations) {
				final RuntimeInvisibleAnnotations ria = (RuntimeInvisibleAnnotations) attr;
				final AnnotationEntry[] annos = ria.getAnnotationEntries();
				for (int j = 0; j < annos.length; j++) {
					final AnnotationEntry a = annos[j];
					annotationGenObjs.add(new AnnotationEntryGen(a, getConstantPool(), false));
				}
			}
		}
		return (annotationGenObjs.toArray(new AnnotationEntryGen[annotationGenObjs.size()]));
	}

	public JavaClass getJavaClass() {
		final int[] interfaces = getInterfaces();
		final Field[] fields = getFields();
		final Method[] methods = getMethods();
		Attribute[] attributes = null;
		if (annotation_vec.isEmpty())
			attributes = getAttributes();
		else {
			final Attribute[] annAttributes = Utility.getAnnotationAttributes(cp, annotation_vec);
			attributes = new Attribute[attribute_vec.size() + annAttributes.length];
			attribute_vec.toArray(attributes);
			System.arraycopy(annAttributes, 0, attributes, attribute_vec.size(), annAttributes.length);
		}
		final ConstantPool _cp = cp.getFinalConstantPool();
		return new JavaClass(class_name_index, superclass_name_index, file_name, major, minor, access_flags, _cp,
				interfaces, fields, methods, attributes);
	}

	public void addInterface(String name) {
		interface_vec.add(name);
	}

	public void removeInterface(String name) {
		interface_vec.remove(name);
	}

	public int getMajor() {
		return major;
	}

	public void setMajor(int major) {
		this.major = major;
	}

	public void setMinor(int minor) {
		this.minor = minor;
	}

	public int getMinor() {
		return minor;
	}

	public void addAttribute(Attribute a) {
		attribute_vec.add(a);
	}

	public void addAnnotationEntry(AnnotationEntryGen a) {
		annotation_vec.add(a);
	}

	public void addMethod(Method m) {
		method_vec.add(m);
	}

	public void addEmptyConstructor(int access_flags) {
		final InstructionList il = new InstructionList();
		il.append(InstructionConstants.THIS);
		il.append(new INVOKESPECIAL(cp.addMethodref(super_class_name, "<init>", "()V")));
		il.append(InstructionConstants.RETURN);
		final MethodGen mg = new MethodGen(access_flags, Type.VOID, Type.NO_ARGS, null, "<init>", class_name, il, cp);
		mg.setMaxStack(1);
		addMethod(mg.getMethod());
	}

	public void addField(Field f) {
		field_vec.add(f);
	}

	public boolean containsField(Field f) {
		return field_vec.contains(f);
	}

	public Field containsField(String name) {
		final Iterator<Field> i$ = field_vec.iterator();
		while (i$.hasNext()) {
			final Field f = i$.next();
			if (f.getName().equals(name))
				return f;
		}
		return null;
	}

	public Method containsMethod(String name, String signature) {
		final Iterator<Method> i$ = method_vec.iterator();
		while (i$.hasNext()) {
			final Method m = i$.next();
			if (m.getName().equals(name) && m.getSignature().equals(signature))
				return m;
		}
		return null;
	}

	public void removeAttribute(Attribute a) {
		attribute_vec.remove(a);
	}

	public void removeMethod(Method m) {
		method_vec.remove(m);
	}

	public void replaceMethod(Method old, Method new_) {
		if (new_ == null)
			throw new ClassGenException("Replacement method must not be null");
		final int i = method_vec.indexOf(old);
		if (i < 0)
			method_vec.add(new_);
		else
			method_vec.set(i, new_);
	}

	public void replaceField(Field old, Field new_) {
		if (new_ == null)
			throw new ClassGenException("Replacement method must not be null");
		final int i = field_vec.indexOf(old);
		if (i < 0)
			field_vec.add(new_);
		else
			field_vec.set(i, new_);
	}

	public void removeField(Field f) {
		field_vec.remove(f);
	}

	public String getClassName() {
		return class_name;
	}

	public String getSuperclassName() {
		return super_class_name;
	}

	public String getFileName() {
		return file_name;
	}

	public void setClassName(String name) {
		class_name = name.replace('/', '.');
		class_name_index = cp.addClass(name);
	}

	public void setSuperclassName(String name) {
		super_class_name = name.replace('/', '.');
		superclass_name_index = cp.addClass(name);
	}

	public Method[] getMethods() {
		return method_vec.toArray(new Method[method_vec.size()]);
	}

	public void setMethods(Method[] methods) {
		method_vec.clear();
		for (int m = 0; m < methods.length; m++)
			addMethod(methods[m]);
	}

	public void setMethodAt(Method method, int pos) {
		method_vec.set(pos, method);
	}

	public Method getMethodAt(int pos) {
		return method_vec.get(pos);
	}

	public String[] getInterfaceNames() {
		final int size = interface_vec.size();
		final String[] interfaces = new String[size];
		interface_vec.toArray(interfaces);
		return interfaces;
	}

	public int[] getInterfaces() {
		final int size = interface_vec.size();
		final int[] interfaces = new int[size];
		for (int i = 0; i < size; i++)
			interfaces[i] = cp.addClass(interface_vec.get(i));
		return interfaces;
	}

	public Field[] getFields() {
		return field_vec.toArray(new Field[field_vec.size()]);
	}

	public Attribute[] getAttributes() {
		return (attribute_vec.toArray(new Attribute[attribute_vec.size()]));
	}

	public AnnotationEntryGen[] getAnnotationEntries() {
		return (annotation_vec.toArray(new AnnotationEntryGen[annotation_vec.size()]));
	}

	public ConstantPoolGen getConstantPool() {
		return cp;
	}

	public void setConstantPool(ConstantPoolGen constant_pool) {
		cp = constant_pool;
	}

	public void setClassNameIndex(int class_name_index) {
		this.class_name_index = class_name_index;
		class_name = cp.getConstantPool().getConstantString(class_name_index, (byte) 7).replace('/', '.');
	}

	public void setSuperclassNameIndex(int superclass_name_index) {
		this.superclass_name_index = superclass_name_index;
		super_class_name = cp.getConstantPool().getConstantString(superclass_name_index, (byte) 7).replace('/', '.');
	}

	public int getSuperclassNameIndex() {
		return superclass_name_index;
	}

	public int getClassNameIndex() {
		return class_name_index;
	}

	public void addObserver(ClassObserver o) {
		if (observers == null)
			observers = new ArrayList<ClassObserver>();
		observers.add(o);
	}

	public void removeObserver(ClassObserver o) {
		if (observers != null)
			observers.remove(o);
	}

	public void update() {
		if (observers != null) {
			final Iterator<ClassObserver> i$ = observers.iterator();
			while (i$.hasNext()) {
				final ClassObserver observer = i$.next();
				observer.notify(this);
			}
		}
	}

	@Override
	public Object clone() {
		Object object;
		try {
			object = super.clone();
		} catch (final CloneNotSupportedException e) {
			System.err.println(e);
			return null;
		}
		return object;
	}

	public static BCELComparator getComparator() {
		return _cmp;
	}

	public static void setComparator(BCELComparator comparator) {
		_cmp = comparator;
	}

	@Override
	public boolean equals(Object obj) {
		return _cmp.equals(this, obj);
	}

	@Override
	public int hashCode() {
		return _cmp.hashCode(this);
	}
}
