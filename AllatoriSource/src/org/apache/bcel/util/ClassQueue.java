package org.apache.bcel.util;

import java.io.Serializable;
import java.util.LinkedList;

import org.apache.bcel.classfile.JavaClass;

public class ClassQueue implements Serializable {
	private static final long serialVersionUID = 685144104322420292L;
	protected LinkedList<JavaClass> vec = new LinkedList<JavaClass>();

	public void enqueue(JavaClass clazz) {
		vec.addLast(clazz);
	}

	public JavaClass dequeue() {
		return vec.removeFirst();
	}

	public boolean empty() {
		return vec.isEmpty();
	}

	@Override
	public String toString() {
		return vec.toString();
	}
}
