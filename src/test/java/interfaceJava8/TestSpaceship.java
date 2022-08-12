package interfaceJava8;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestSpaceship extends BaseSpaceship {
    List<Spaceship> spaceshipKamikadze = createSpaceship(() -> new Spaceship("Kamikadze", 880, 100, 1500), 20);
    List<Spaceship> spaceshipBorov = createSpaceship(() -> new Spaceship("Borov", 500, 180, 2000), 40);

    public List<Spaceship> getSpaceshipBorov() {
        return spaceshipBorov;
    }

    @Test
    @Description("Function")
    public void checkMaxFlyDistance() {
        int avaragemaxFlyDistance = getAverageValues(spaceshipKamikadze, spaceship -> spaceship.maxFlyDistance);

        Assert.assertEquals(avaragemaxFlyDistance, 0);
    }

    @Test
    @Description("Function")
    public void checkAvarageHeight() {
        int avarageHeight = getAverageValues(spaceshipKamikadze, spaceship -> spaceship.maxHeight);

        Assert.assertEquals(avarageHeight, 1500);
    }

    @Test
    @Description("Supplier")
    public void checkCreationSpaceship() {
        List<Spaceship> spaceshipsMeduza = createSpaceship(() -> new Spaceship("Meduza", 2500, 0, 3500), 10);
        for (Spaceship spaceship : spaceshipsMeduza) {

            Assert.assertEquals(spaceship.model, "Meduza");
            Assert.assertEquals(spaceship.speed, 2500);
            Assert.assertEquals(spaceship.maxHeight, 3500);
            Assert.assertEquals(spaceship.maxFlyDistance, 0);
        }
    }

    @Test
    @Description("Supplier")
    public void checkCreationSpaceshipSize() {
        List<Spaceship> spaceshipsMeduza = createSpaceship(() -> new Spaceship("Meduza", 2500, 85, 3500), 10);

        Assert.assertEquals(spaceshipsMeduza.size(), 10);
    }

    @Test
    @Description("Predicate")
    public void checkSpaceshipSpeed() {
        List<Spaceship> spaceshipsActual;
        Predicate<Spaceship> spaceshipPredicate = spaceship -> spaceship.maxHeight > 450;
        spaceshipsActual = getSpaceshipBorov().stream().filter(spaceshipPredicate).collect(Collectors.toList());
        spaceshipsActual.forEach(spaceship -> {

            Assert.assertTrue(spaceship.maxHeight > 450);
        });
    }

    @Test
    @Description("Predicate")
    public void checkSpaceshipModel() {
        List<Spaceship> spaceshipsActual;
        Predicate<Spaceship> spaceshipPredicate = spaceship -> Objects.equals(spaceship.model, "Borov");
        spaceshipsActual = getSpaceshipBorov().stream().filter(spaceshipPredicate).collect(Collectors.toList());
        spaceshipsActual.forEach(spaceship -> {

            Assert.assertEquals(spaceship.model, "Borov");
        });
    }

    @Test
    @Description("Consumer")
    public void checkDistance() {
        changeSpaceship(spaceshipKamikadze.get(1), spaceshipToChange -> {
            spaceshipToChange.maxFlyDistance = 5000;

            Assert.assertEquals(spaceshipKamikadze.get(1).maxFlyDistance, 5000);
        });
    }

    @Test
    @Description("Consumer")
    public void checkDistanceAndSpeed() {
        changeSpaceship(spaceshipKamikadze.get(1), spaceshipToChange -> {
            spaceshipToChange.maxFlyDistance = 5000;

            Assert.assertEquals(spaceshipKamikadze.get(1).maxFlyDistance, 5000);

            spaceshipToChange.speed = 800;

            Assert.assertEquals(spaceshipKamikadze.get(1).maxFlyDistance, 5000);
        });
    }
}
