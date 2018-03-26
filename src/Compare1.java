public class Compare1 {

    public static void main(String[] args) {
        Integer a = new Integer(2);
        Integer b = new Integer(2);
        int c = 2;
        int d = 2;
        boolean x = a.equals(b);
        boolean y = a == b;
        boolean z = c == d;
        System.out.println("integer 1 compare with equals, return: " + x );
        System.out.println("integer 1 compare with ==, return: " + y);
        System.out.println("int 1 compare with ==, return:" + z);
    }
}
