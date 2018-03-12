package Model;

public class TrackingPoint {

    private long id;
    private int unit;
    private String dt;
    private float x;
    private float y;
    private int speed;
    private int event;
    private String location;

    public TrackingPoint(long id, int unit, String dt, float x, float y, int speed, int event, String location) {
        this.id = id;
        this.unit = unit;
        this.dt = dt;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.event = event;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "TrackingPoint{" +
                "id=" + id +
                ", unit=" + unit +
                ", dt='" + dt + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", speed=" + speed +
                ", event=" + event +
                ", location='" + location + '\'' +
                '}';
    }
}
