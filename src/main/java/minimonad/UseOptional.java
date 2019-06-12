package minimonad;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UseOptional {
    public static void main(String[] args) {
        Map<String, String> theMap = new HashMap<>();
        theMap.put("Fred", "Jones");
        String firstName = "Freddy";
//        String lastName = theMap.get(firstName);
//        String shout = lastName.toUpperCase();
//        String message = "Dear " + shout;
//        System.out.println(message);

        Optional<String> msg = Optional.of(theMap)
                .map(m -> m.get(firstName))
                .map(ln -> ln.toUpperCase())
                .map(sh -> "Dear " + sh);
        msg.ifPresent(m -> System.out.println(m));

        System.out.println(msg.orElse("No name found"));
        // Java 9 gives ifPresentOrElse(Consumer, Runnable)

        // Kinda bad... May be helpful with legacy "incomplete improvement"
        String n = msg.get();
        System.out.println("again!> " + n);
    }
}
