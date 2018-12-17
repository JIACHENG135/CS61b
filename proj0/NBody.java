public class NBody {
    /** Reads a file and returns the radius. */
    public static double readRadius(String filename) {
        In in = new In(filename);
        int num_of_planets = in.readInt();
        double radius = in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int num_of_planets = in.readInt();
        double radius_of_univers = in.readDouble();
        Planet[] allPlanets = new Planet[num_of_planets];
        for (int i =0;i <num_of_planets ;i+=1 ) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            allPlanets[i] = new Planet(xP, yP, xV, yV, mass, img);
        }
        
        return allPlanets;
    }
    public static void main(String[] args) {
        // double T = Double.valueOf(args[0].toString());
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        System.out.print(T);
        System.out.print(dt);
        String filename = args[2];
        Planet[] allPlanets = readPlanets(filename);
        String bg_img = ".\\images\\starfield.jpg";
        String bg_audio = ".\\audio\\2001.mid";
        double radius = readRadius(filename);
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdAudio.play("audio/2001.mid");
        // StdDraw.picture(0, 0, bg_img);
        // StdDraw.clear();
        // for(Planet P: allPlanets) {
        //     P.draw();
        // }
        
        for(double t=0.0;t<T;t+=dt){
            // StdDraw.clear();
            StdDraw.picture(0, 0, bg_img);
            for(Planet P: allPlanets) {
                double forcex = P.calcNetForceExertedByX(allPlanets);
                double forcey = P.calcNetForceExertedByY(allPlanets);
                P.update(dt,forcex,forcey);
                P.draw();
        }
        StdDraw.show();
        StdDraw.pause(10);
        // StdDraw.picture(0, 0, bg_img);
}
    }
}