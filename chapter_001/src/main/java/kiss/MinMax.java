package kiss;

import java.util.List;
import java.util.Comparator;

import java.util.function.BiPredicate;

public class MinMax {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return find(value, (o, t) -> comparator.compare(o, t) >= 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return find(value, (o, t) -> comparator.compare(o, t) <= 0);
    }

    public <T> T find(List<T> value, BiPredicate<T, T> predicate) {
        T rsl = value.get(0);
        for (int i = 0; i < value.size(); i++) {
            if (predicate.test(value.get(i), rsl)) {
                rsl = value.get(i);
            }
        }
        return rsl;
    }
}

/*
Interface BiPredicate<T,U>
Type Parameters:
T - the type of the first argument to the predicate
U - the type of the second argument the predicate

boolean test(T t,
             U u)
Evaluates this predicate on the given arguments.
Parameters:
t - the first input argument
u - the second input argument
Returns:
true if the input arguments match the predicate, otherwise false
 */