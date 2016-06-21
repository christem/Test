package java8;

import java.util.Arrays;

public class LambdaTest {

    public static void main(String[] args) {
	// Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

	// Arrays.asList("a", "b", "d").forEach((String e) ->
	// System.out.println(e));

	// Arrays.asList("a", "b", "d").forEach(e -> {
	// System.out.print(e);
	// System.out.print(e);
	// });

	// final String separator = ",";
	// Arrays.asList("a", "b", "d").forEach((String e) -> System.out.print(e
	// + separator));

	// List<String> list = Arrays.asList("b", "c", "a");
	// list.sort((e1, e2) -> e1.compareTo(e2));
	// list.forEach(e -> System.out.println(e));

	Arrays.asList("a", "b", "d").sort((e1, e2) -> {
	    int result = e1.compareTo(e2);
	    return result;
	});
    }
}
