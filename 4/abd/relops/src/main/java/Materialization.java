import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Materialization {

    public static List<Object[]> project(List<Object[]> input, Integer... c) {
        List<Object[]> res = new ArrayList<Object[]>();

        for(Object[] i: input) {
            Object[] l = new Object[c.length];
            for(int j=0; j<c.length; j++)
                l[j] = i[c[j]];
            res.add(l);
        }

        return res;
    }

    public static List<Object[]> select(List<Object[]> input, Predicate<Object[]> cond) {
        List<Object[]> res = new ArrayList<Object[]>();

        for(Object[] i: input) {
            if (cond.test(i))
                res.add(i);
        }

        return res;

    }

    public static void main(String[] args) throws Exception {
        List<Object[]> tab = Arrays.asList(
            new Object[]{"aaa", 1, 123},
            new Object[]{"bbb", 2, 213},
            new Object[]{"bbb", 3, 345},
            new Object[]{"ccc", 3, 342},
            new Object[]{"ddd", 4, 23}
        );

        tab = project(select(tab, (l)->((Integer)l[2])>200), 0, 2);

        for(Object[] i: tab)
            System.out.println(Arrays.toString(i));
    }
}
