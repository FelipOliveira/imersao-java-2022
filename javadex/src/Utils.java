public class Utils {
    private static final double KG_CONVERSOR = 0.45359237;
    private static final double FT_CONVERSOR = 30.48;

    public static int lbToKg(double weight) {
        return (int) (weight * KG_CONVERSOR);
    }

    public static int ftToCm(double height) {
        return (int) (height * FT_CONVERSOR);
    }
}
