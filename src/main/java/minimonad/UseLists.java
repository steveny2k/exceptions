package minimonad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UseLists {
/*    interface Function<A, B> {
        B apply(A a);
    }*/

    public static List<String> map(List<String> in, Function<String, String> op) {
        List<String> output = new ArrayList<>();

        for (String s : in) {
            output.add(op.apply(s));
        }

        return output;
    }
    public static void main(String[] args) {
//        List<String> names = Arrays.asList("Fred", "Jim", "Sheila");
        List<String> names = Arrays.asList();

        List<String> shout = map(names, (String s) -> {return s.toUpperCase();} );

        for(String s : shout) {
            System.out.println("> " + s);
        }

        shout.forEach(s -> System.out.println(">>> " + s));
    }
}
