public class NBody {
    public static void main(String[] args) {
        try {
            double T = Double.parseDouble(args[0]);
            double dt = Double.parseDouble(args[1]);
            String filename = args[2];
            double radius = readRadius(filename);
            Planet[] planets = readPlanets(filename);

            StdDraw.setScale(-radius, radius);
            StdDraw.enableDoubleBuffering();

            double t = 0;
            int num = planets.length;
            while (t <= T) {
                double[] xForces = new double[num];
                double[] yForces = new double[num];
                for (int i = 0; i < num ;i++) {
                    xForces[i] = planets[i].calcNetForceExertedByX(planets);
                    yForces[i] = planets[i].calcNetForceExertedByY(planets);
                }

                for (int i = 0; i < num ;i++) {
                    planets[i].update(dt, xForces[i], yForces[i]);
                }

                StdDraw.picture(0, 0, "images/starfield.jpg");
                for (Planet planet : planets) {
                    planet.draw();
                }
                StdDraw.show();
                StdDraw.pause(10);

                t += dt;
            }

            StdOut.printf("%d\n", planets.length);
            StdOut.printf("%.2e\n", radius);
            for (int i = 0; i < planets.length; i++) {
                StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("At least three arguments");
        }
    }

    public static double readRadius(String filename) {
        In in = new In(filename);
        int numberOfPlanets = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[numberOfPlanets];
        for (int i = 0; i < numberOfPlanets ;i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }

        return planets;
    }
}