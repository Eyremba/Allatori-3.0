/* DescendingVisitor - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */
package org.apache.bcel.classfile;
import java.util.Stack;

public class DescendingVisitor implements Visitor
{
    private JavaClass clazz;
    private Visitor visitor;
    private Stack stack = new Stack();
    
    public Object predecessor() {
	return predecessor(0);
    }
    
    public Object predecessor(int level) {
	int size = stack.size();
	if (size < 2 || level < 0)
	    return null;
	return stack.elementAt(size - (level + 2));
    }
    
    public Object current() {
	return stack.peek();
    }
    
    public DescendingVisitor(JavaClass clazz, Visitor visitor) {
	this.clazz = clazz;
	this.visitor = visitor;
    }
    
    public void visit() {
	clazz.accept(this);
    }
    
    public void visitJavaClass(JavaClass _clazz) {
	stack.push(_clazz);
	_clazz.accept(visitor);
	Field[] fields = _clazz.getFields();
	for (int i = 0; i < fields.length; i++)
	    fields[i].accept(this);
	Method[] methods = _clazz.getMethods();
	for (int i = 0; i < methods.length; i++)
	    methods[i].accept(this);
	Attribute[] attributes = _clazz.getAttributes();
	for (int i = 0; i < attributes.length; i++)
	    attributes[i].accept(this);
	_clazz.getConstantPool().accept(this);
	stack.pop();
    }
    
    public void visitAnnotation(Annotations annotation) {
	stack.push(annotation);
	annotation.accept(visitor);
	AnnotationEntry[] entries = annotation.getAnnotationEntries();
	for (int i = 0; i < entries.length; i++)
	    entries[i].accept(this);
	stack.pop();
    }
    
    public void visitAnnotationEntry(AnnotationEntry annotationEntry) {
	stack.push(annotationEntry);
	annotationEntry.accept(visitor);
	stack.pop();
    }
    
    public void visitField(Field field) {
	stack.push(field);
	field.accept(visitor);
	Attribute[] attributes = field.getAttributes();
	for (int i = 0; i < attributes.length; i++)
	    attributes[i].accept(this);
	stack.pop();
    }
    
    public void visitConstantValue(ConstantValue cv) {
	stack.push(cv);
	cv.accept(visitor);
	stack.pop();
    }
    
    public void visitMethod(Method method) {
	stack.push(method);
	method.accept(visitor);
	Attribute[] attributes = method.getAttributes();
	for (int i = 0; i < attributes.length; i++)
	    attributes[i].accept(this);
	stack.pop();
    }
    
    public void visitExceptionTable(ExceptionTable table) {
	stack.push(table);
	table.accept(visitor);
	stack.pop();
    }
    
    public void visitCode(Code code) {
	stack.push(code);
	code.accept(visitor);
	CodeException[] table = code.getExceptionTable();
	for (int i = 0; i < table.length; i++)
	    table[i].accept(this);
	Attribute[] attributes = code.getAttributes();
	for (int i = 0; i < attributes.length; i++)
	    attributes[i].accept(this);
	stack.pop();
    }
    
    public void visitCodeException(CodeException ce) {
	stack.push(ce);
	ce.accept(visitor);
	stack.pop();
    }
    
    public void visitLineNumberTable(LineNumberTable table) {
	stack.push(table);
	table.accept(visitor);
	LineNumber[] numbers = table.getLineNumberTable();
	for (int i = 0; i < numbers.length; i++)
	    numbers[i].accept(this);
	stack.pop();
    }
    
    public void visitLineNumber(LineNumber number) {
	stack.push(number);
	number.accept(visitor);
	stack.pop();
    }
    
    public void visitLocalVariableTable(LocalVariableTable table) {
	stack.push(table);
	table.accept(visitor);
	LocalVariable[] vars = table.getLocalVariableTable();
	for (int i = 0; i < vars.length; i++)
	    vars[i].accept(this);
	stack.pop();
    }
    
    public void visitStackMap(StackMap table) {
	stack.push(table);
	table.accept(visitor);
	StackMapEntry[] vars = table.getStackMap();
	for (int i = 0; i < vars.length; i++)
	    vars[i].accept(this);
	stack.pop();
    }
    
    public void visitStackMapEntry(StackMapEntry var) {
	stack.push(var);
	var.accept(visitor);
	stack.pop();
    }
    
    public void visitStackMapTable(StackMapTable table) {
	stack.push(table);
	table.accept(visitor);
	StackMapTableEntry[] vars = table.getStackMapTable();
	for (int i = 0; i < vars.length; i++)
	    vars[i].accept(this);
	stack.pop();
    }
    
    public void visitStackMapTableEntry(StackMapTableEntry var) {
	stack.push(var);
	var.accept(visitor);
	stack.pop();
    }
    
    public void visitLocalVariable(LocalVariable var) {
	stack.push(var);
	var.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantPool(ConstantPool cp) {
	stack.push(cp);
	cp.accept(visitor);
	Constant[] constants = cp.getConstantPool();
	for (int i = 1; i < constants.length; i++) {
	    if (constants[i] != null)
		constants[i].accept(this);
	}
	stack.pop();
    }
    
    public void visitConstantClass(ConstantClass constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantDouble(ConstantDouble constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantFieldref(ConstantFieldref constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantFloat(ConstantFloat constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantInteger(ConstantInteger constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantInterfaceMethodref
	(ConstantInterfaceMethodref constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantLong(ConstantLong constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantMethodref(ConstantMethodref constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantNameAndType(ConstantNameAndType constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantString(ConstantString constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitConstantUtf8(ConstantUtf8 constant) {
	stack.push(constant);
	constant.accept(visitor);
	stack.pop();
    }
    
    public void visitInnerClasses(InnerClasses ic) {
	stack.push(ic);
	ic.accept(visitor);
	InnerClass[] ics = ic.getInnerClasses();
	for (int i = 0; i < ics.length; i++)
	    ics[i].accept(this);
	stack.pop();
    }
    
    public void visitInnerClass(InnerClass inner) {
	stack.push(inner);
	inner.accept(visitor);
	stack.pop();
    }
    
    public void visitDeprecated(Deprecated attribute) {
	stack.push(attribute);
	attribute.accept(visitor);
	stack.pop();
    }
    
    public void visitSignature(Signature attribute) {
	stack.push(attribute);
	attribute.accept(visitor);
	stack.pop();
    }
    
    public void visitSourceFile(SourceFile attribute) {
	stack.push(attribute);
	attribute.accept(visitor);
	stack.pop();
    }
    
    public void visitSynthetic(Synthetic attribute) {
	stack.push(attribute);
	attribute.accept(visitor);
	stack.pop();
    }
    
    public void visitUnknown(Unknown attribute) {
	stack.push(attribute);
	attribute.accept(visitor);
	stack.pop();
    }
    
    public void visitAnnotationDefault(AnnotationDefault obj) {
	stack.push(obj);
	obj.accept(visitor);
	stack.pop();
    }
    
    public void visitEnclosingMethod(EnclosingMethod obj) {
	stack.push(obj);
	obj.accept(visitor);
	stack.pop();
    }
    
    public void visitLocalVariableTypeTable(LocalVariableTypeTable obj) {
	stack.push(obj);
	obj.accept(visitor);
	stack.pop();
    }
    
    public void visitParameterAnnotation(ParameterAnnotations obj) {
	stack.push(obj);
	obj.accept(visitor);
	stack.pop();
    }
}