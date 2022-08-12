package interfaceJava8;

public class Spaceship {
    public int maxFlyDistance;
    public String model;
    public int speed;
    public int MaxFlyDistance;
    public int maxHeight;

    public Spaceship(String model, int speed, int maxFlyDistance, int maxHeight) {
        this.model = model;
        this.speed = speed;
        this.MaxFlyDistance = maxFlyDistance;
        this.maxHeight = maxHeight;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMaxFlyDistance(int maxFlyDistance) {
        this.MaxFlyDistance = maxFlyDistance;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxFlyDistance() {
        return MaxFlyDistance;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", speed=" + speed +
                ", MaxFlyDistance=" + MaxFlyDistance +
                ", maxHeight=" + maxHeight +
                '}';
    }
}
