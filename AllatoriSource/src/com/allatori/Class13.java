package com.allatori;

public abstract class Class13 implements Cloneable {

	public Double aDouble525;

	public double method355() {
		if (this.aDouble525 != null) {
			final double var1 = this.aDouble525;
			this.aDouble525 = null;
			return var1;
		} else {
			double var3;
			double var5;
			double var7;
			do {
				var3 = this.method361(-1.0D);
				var5 = this.method361(-1.0D);
			} while ((var7 = var3 * var3 + var5 * var5) >= 1.0D);

			final double var9 = Math.sqrt(-2.0D * Math.log(var7) / var7);
			this.aDouble525 = var3 * var9;
			return var5 * var9;
		}
	}

	public void method357(double[] var1, int var2) {
		int var3;
		for (int var10000 = var3 = 0; var10000 < var2; var10000 = var3) {
			var1[var3] = this.method359();
			++var3;
		}

	}

	public abstract double method359();

	public int method360(int var1, int var2) {
		int var3;
		if ((var3 = var1 + (int) ((var2 - var1) * this.method359())) > var2) {
			var3 = var2;
		}

		return var3;
	}

	public double method361(double var1) {
		return var1 + (1.0D - var1) * this.method359();
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
