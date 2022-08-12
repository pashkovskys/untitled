package interfaceJava8;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BaseSpaceship {
    public int getAverageValues(List<Spaceship> spaceships, Function<Spaceship, Integer> function) {
        int result = 0;
        for (Spaceship spaceship : spaceships) {
            result += function.apply(spaceship);
        }
        return result / spaceships.size();
    }

    public List<Spaceship> createSpaceship(Supplier<Spaceship> supplier, int s) {
        List<Spaceship> spaceship = new LinkedList<>();
        for (int i = 0; i < s; i++) {
            spaceship.add(supplier.get());
        }
        return spaceship;
    }

    public void changeSpaceship(Spaceship spaceship, Consumer<Spaceship> consumer) {
        consumer.accept(spaceship);
    }
}
