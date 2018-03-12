package Model;

public class Vehicle {

    private int id;
    private int unit;
    private String dt;
    private float x;
    private float y;
    private int speed;

    public Vehicle(int id, int unit, String dt, float x, float y, int speed) {
        this.id = id;
        this.unit = unit;
        this.dt = dt;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", unit=" + unit +
                ", dt='" + dt + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                '}';
    }
}
