package Operations.Filters;

import Utils.Image;
import Operations.Arithmetic.Sum;
import Operations.Arithmetic.Subtraction;
import Operations.Arithmetic.Blending;

public class UnsharpMask {
	public static Image unsharpMask(Image a, float v, int r, float sigma, float amp) {
		return Sum.sum(a, Blending.blending( new Image(a.getW(), a.getH()), Subtraction.sub(a, GaussianBlur.gaussianBlur(a, r, sigma, amp)), v));
	}
}
