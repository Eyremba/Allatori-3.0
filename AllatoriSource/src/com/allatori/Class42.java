package com.allatori;

import org.apache.bcel.classfile.Method;
import org.apache.bcel.util.BCELComparator;

public class Class42 implements BCELComparator {

    private static Class42 aClass42_1196 = new Class42();


    public static Class42 method652() {
        return aClass42_1196;
    }

    public int hashCode(Object var1) {
        Method var2;
        return (var2 = (Method) var1).getSignature().hashCode() ^ var2.getName().hashCode();
    }

    public boolean equals(Object var1, Object var2) {
        Method var3 = (Method) var1;
        Method var4 = (Method) var2;
        return var3.getName().equals(var4.getName()) && var3.getSignature().equals(var4.getSignature());
    }
}
