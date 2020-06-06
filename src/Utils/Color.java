package Utils;

public class Color {
	
	public static int red(int cor) {
		return cor >> 16 & 0xff;
	}
	
	public static int green(int cor) {
		return cor >> 8 & 0xff;
	}
	
	public static int blue(int cor) {
		return cor & 0xff;
	}
	
}
