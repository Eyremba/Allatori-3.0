package com.allatori;

import java.io.File;
import java.net.URL;
import java.util.Vector;

public class Configurable {

	protected static void createWatermark(ClassStorage classStorage) throws Exception_Sub1 {
		new Watermarking(classStorage, Class167.method1660()).createWatermark(Class167.method1656());
	}

	public static void parseConfigFile(String fileName) {
		try {
			ParseConfig.parseConfigFile(fileName);
		} catch (final TemplateException e) {
			if (e.getCause() == null) {
				Logger.printError("Configuration error. " + e.getMessage());
			} else {
				Logger.printError("Error reading configuration. " + e.getCause().getMessage());
			}
			System.exit(-1);
		}
	}

	private static void method1268(ClassStorage classStorage) throws Exception {
		final Vector<?> vector = Class45.method660();
		for (int i = 0; i < vector.size(); i++) {
			Class149 unknown = (Class149) vector.get(i);
			JarUtils.method450(unknown.aString799, unknown.aString800, classStorage);
		}
		if (Class45.method655() != null) {
			final String[] var5 = new String[vector.size()];
			for (int var10000 = 0; var10000 < vector.size(); var10000++) {
				var5[var10000] = ((Class149) vector.get(var10000)).aString800;
				++var10000;
			}
			JarUtils.method446(var5, Class45.method655());
		}
	}

	static ClassStorage method1269() throws Exception {
		final ClassStorage var0 = new ClassStorage(method1272());
		final Vector<?> var1 = Class45.method660();

		int var2;
		int var10000;
		for (var10000 = var2 = 0; var10000 < var1.size(); var10000 = var2) {
			Class27.parseClass(((Class149) var1.get(var2)).aString799, var0);
			++var2;
		}

		final Vector<?> var3 = Class45.method657();

		int var4;
		for (var10000 = var4 = 0; var10000 < var3.size(); var10000 = var4) {
			ClassLoadingUtils.loadClassesFromDir(((Class157) var3.get(var4)).aString811, var0);
			++var4;
		}

		return var0;
	}

	static String printSplash() {
		final String var0 = " ## #   #    ## ### ### ##  ###";
		final String var1 = "# # #   #   # #  #  # # # #  # ";
		final String var2 = "### #   #   ###  #  # # ##   # ";
		final String var3 = "# # ### ### # #  #  ### # # ###";
		final String var4 = "Obfuscation by " + Info.name() + " " + Info.version();
		final String var5 = Info.website();
		int var6 = Math.max(var0.length(), Math.max(var4.length(), var5.length()));
		var6 += 4;
		StringBuffer var7;
		method1271(var7 = new StringBuffer("\n"), '#', var6).append("\n#");
		method1271(var7, ' ', var6 - 2).append("#\n#");
		int var8 = (var6 - var0.length() - 2) / 2;
		int var9 = var6 - var8 - var0.length() - 2;
		method1271(var7, ' ', var8).append(var0);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var1);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var2);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var3);
		method1271(var7, ' ', var9).append("#\n#");
		final String var10 = "                               ";
		final String var11 = "         DEMO VERSION!         ";
		final String var12 = "    NOT FOR COMMERCIAL USE!    ";
		final String var13 = "                               ";
		final String var14 = "Registered version doesn\'t add ";
		final String var15 = "System.out\'s to the obfuscated ";
		final String var16 = "application.                   ";
		method1271(var7, ' ', var8).append(var10);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var11);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var12);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var13);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var14);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var15);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var8).append(var16);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var6 - 2).append("#\n#");
		method1271(var7, ' ', var6 - 2).append("#\n#");
		var8 = (var6 - var4.length() - 2) / 2;
		var9 = var6 - var8 - var4.length() - 2;
		method1271(var7, ' ', var8).append(var4);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var6 - 2).append("#\n#");
		var8 = (var6 - var5.length() - 2) / 2;
		var9 = var6 - var8 - var5.length() - 2;
		method1271(var7, ' ', var8).append(var5);
		method1271(var7, ' ', var9).append("#\n#");
		method1271(var7, ' ', var6 - 2).append("#\n");
		method1271(var7, '#', var6).append("\n");
		return var7.toString();
	}

	private static StringBuffer method1271(StringBuffer var0, char var1, int var2) {
		int var3;
		for (int var10000 = var3 = 0; var10000 < var2; var10000 = var3) {
			var0.append(var1);
			++var3;
		}

		return var0;
	}

	@SuppressWarnings("deprecation")
	private static URLClassLoaderImpl method1272() {
		final Vector<Object> var0 = Class72.method832();

		int var1;
		for (int var10000 = var1 = 0; var10000 < var0.size(); var10000 = var1) {
			try {
				var0.set(var1, (new File((String) var0.get(var1))).toURL());
			} catch (final Exception var3) {
				var3.printStackTrace();
			}

			++var1;
		}

		final URL[] var2 = (URL[]) var0.toArray(new URL[var0.size()]);
		return new URLClassLoaderImpl(var2);
	}

	private static void method1273(ClassStorage var0) throws Exception {
		final Vector<?> var1 = Class45.method657();

		int var2;
		for (int var10000 = var2 = 0; var10000 < var1.size(); var10000 = var2) {
			Class157 var3;
			DumpUtils.dumpClass((var3 = (Class157) var1.get(var2)).aString811, var3.aString812, var0);
			++var2;
		}

	}

	static String method1274(ClassStorage var0) throws Exception_Sub1 {
		return (new Watermarking(var0, Class167.method1660())).extractWatermark();
	}

	static void method1275(ClassStorage var0) throws Exception {
		method1268(var0);
		method1273(var0);
	}
}
