import java.util.*;

public class Vect {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.addElement(1);
        v.addElement(3);
        System.out.println(v.elementAt(0));
        System.out.println(v.elementAt(1));
//        v.clear();
//        System.out.println(v.elementAt(0));
//        System.out.println(v.elementAt(1));
        Stack<Integer> v1 = new Stack<Integer>();
        int a=0;
        v1.push(a);

        System.out.println(v1.get(0));
        v1.pop();
        System.out.println(v1.empty());

        Hashtable balance = new Hashtable();
        balance.put("Zara", new Double(3434.34));
        balance.put("Mahnaz", new Double(123.22));
        balance.put("Ayan", new Double(1378.00));
        balance.put("Daisy", new Double(99.22));
        balance.put("Qadir", new Double(-19.08));
        Enumeration<String> keys;
        keys = balance.keys();
        String str;
        while(keys.hasMoreElements()) {
            str = keys.nextElement();
            System.out.println(str + ": " +
                    balance.get(str));
        }

        Properties p = new Properties();
        p.setProperty("a", "b");
        p.setProperty("c", "d");
        System.out.println(p.getProperty("a"));

        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> ite = list.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        System.out.println(map.keySet());
        List a3;


        TreeSet<Integer> set = new TreeSet<>();

        set.add(1111);
        set.add(2222);
        set.add(3333);
        set.add(4444);
        set.add(5555);

        System.out.println(set.first()); // 输出第一个元素
        System.out.println(set.lower(3333)); //小于3333的最大元素
        System.out.println(set.higher(2222)); //大于2222的最大元素
        System.out.println(set.floor(3333)); //不大于3333的最大元素
        System.out.println(set.ceiling(3333)); //不小于3333的最大元素

        Queue<String> queue = new LinkedList<>();

        queue.offer("aaaa");
        queue.offer("bbbb");
        queue.offer("cccc");
        queue.offer("dddd");

        while (queue.size() > 0) {
            System.out.println(queue.remove() + "");
        }



    }

}
