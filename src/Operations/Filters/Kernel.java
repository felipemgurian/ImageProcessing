package Operations.Filters;

public class Kernel {
	float[][] k;
	int cx, cy; // Central Position
	
	public Kernel(int w, int h, int cx, int cy) {
		k = new float[h][w];
		this.cx = cx;
		this.cy = cy;
	}
	
	public Kernel(int r) {
		k = new float[2*r+1][2*r+1];
		cx = r;
		cy = r;
		
	}
}