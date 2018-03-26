import java.math.BigDecimal;

public class Decimal {
    private static final int DEF_DIV_SCALE = 10;
    public static double add(double v1, double v2){
//      Double.toString(v1);
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal("12.5");
        return b1.add(b2).doubleValue();
    }

    public static BigDecimal add1(String v1, String v2){
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);

    }

    public static void main(String[] args) {
        Decimal a = new Decimal();
        System.out.println(a.add(1.33,2.33));
        System.out.println(a.add1("5.20", "8.80"));
        BigDecimal b = a.add1("5.20", "8.80");
        Double c = a.add(1.33,2.33);
        System.out.println(b.getClass());
        System.out.println(c.getClass());
    }
}
