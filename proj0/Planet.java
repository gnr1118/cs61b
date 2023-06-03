public class Planet {
    public static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xxPos, double yyPos, double xxVel,
                  double yyVel, double mass, String imgFileName) {
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet planet) {
        this.xxPos = planet.xxPos;
        this.yyPos = planet.yyPos;
        this.xxVel = planet.xxVel;
        this.yyVel = planet.yyVel;
        this.mass = planet.mass;
        this.imgFileName = planet.imgFileName;
    }

    public double calcDistance(Planet planet) {
        double dx = planet.xxPos - this.xxPos;
        double dy = planet.yyPos - this.yyPos;
        return Math.pow(dx * dx + dy * dy, 0.5);
    }

    public double calcForceExertedBy(Planet planet) {
        double r = calcDistance(planet);
        return (G * this.mass * planet.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet planet) {
        double dx = planet.xxPos - this.xxPos;
        double r = calcDistance(planet);
        return calcForceExertedBy(planet) * dx / r;
    }

    public double calcForceExertedByY(Planet planet) {
        double dy = planet.yyPos - this.yyPos;
        double r = calcDistance(planet);
        return calcForceExertedBy(planet) * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sum = 0.0;
        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            sum += calcForceExertedByX(planet);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double sum = 0.0;
        for (Planet planet : planets) {
            if (this.equals(planet)) {
                continue;
            }
            sum += calcForceExertedByY(planet);
        }
        return sum;
    }

    public void update(double dt, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;

        this.xxVel += dt * ax;
        this.yyVel += dt * ay;

        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }
}