import java.util.*;
import java.util.function.Predicate;

public class Iteration {

    public static class Project implements Iterable<Object[]> {
        private final Iterable<Object[]> input;
        private final Integer[] c;

        public Project (Iterable<Object[]> input, Integer... c) {
            this.input = input;
            this.c = c;
        }

        @Override
        public Iterator<Object[]> iterator() {
            return new Iterator<Object[]>() {

                private Iterator<Object[]> i = input.iterator();

                @Override
                public boolean hasNext() {
                    return  i.hasNext();
                }

                @Override
                public Object[] next() {
                    Object[] k = i.next();
                    Object[] l = new Object[c.length];
                    for(int j=0; j<c.length; j++)
                        l[j] = k[c[j]];
                    return l;
                }
            };
        }

        public String toString() {
            return "Project ("+Arrays.toString(c)+"\n"+input;
        }
    }



    // ----------------------------------------------------------------------------------------




    public static class Select implements Iterable<Object[]> {
        private final Iterable<Object[]> input;
        private final Predicate<Object[]> cond;

        public Select (Iterable<Object[]> input, Predicate<Object[]> cond) {
            this.input = input;
            this.cond = cond;
        }

        @Override
        public Iterator<Object[]> iterator() {
            return new Iterator<Object[]>() {

                private Iterator<Object[]> i = input.iterator();
                private Object[] l = null;

                @Override
                public boolean hasNext() {
                    if (l!=null)
                        return true;
                    while(i.hasNext()) {
                        l = i.next();
                        if (cond.test(l))
                            return true;
                    }
                    l = null;
                    return false;
                }

                @Override
                public Object[] next() {
                    if (!hasNext())
                        throw new NoSuchElementException();
                    Object[] r =  l;
                    l = null;
                    return r;
                }
            };
        }

        public String toString() {
            return "Select (...)\n"+input;
        }
    }

    public static void main(String[] args) throws Exception {
        List<Object[]> tab = Arrays.asList(
            new Object[]{"aaa", 1, 123},
            new Object[]{"bbb", 2, 213},
            new Object[]{"bbb", 3, 345},
            new Object[]{"ccc", 3, 342},
            new Object[]{"ddd", 4, 23}
        );

        // prepare
        Iterable<Object[]> plan = new Select(tab,(l)->((Integer)l[2])>200);
        plan = new Project(plan, 0, 2);

        // explain
        System.out.println(plan.toString());

        // execute
        for(Object[] i: plan)
            System.out.println(Arrays.toString(i));
    }
}
