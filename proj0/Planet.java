import java.lang.Math;
public class Planet{
    public static final double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV,
        double yV, double m, String img){
     xxPos = xP;
     yyPos = yP;
     xxVel = xV;
     yyVel = yV;
     mass = m;
     imgFileName = img;
 }
 public Planet(Planet P){
    xxPos = P.xxPos;
    yyPos = P.yyPos;
    xxVel = P.xxVel;
    yyVel = P.yyVel;
    mass = P.mass;
    imgFileName = P.imgFileName;
}
public double calcDistance(Planet P){
    // int dist = 0;
    double dx = xxPos - P.xxPos;
    double dy = yyPos - P.yyPos;
    double r = Math.sqrt(dx*dx + dy*dy);
    return r;
}
public double calcForceExertedBy(Planet P){
    double G = 6.67*1e-11;
    double r = this.calcDistance(P);
    double force = G*this.mass*P.mass/(r*r);
    return force;
}
public double calcForceExertedByX(Planet P){
    double dx = this.xxPos - P.xxPos;
    double r = this.calcDistance(P);
    double force = -this.calcForceExertedBy(P)*dx/r;
    return force;
}
public double calcForceExertedByY(Planet P){
    double dy = this.yyPos - P.yyPos;
    double r = this.calcDistance(P);
    double force = -this.calcForceExertedBy(P)*dy/r;
    return force;
}
public double calcNetForceExertedByX(Planet[] all){
    double force =0.0;
    for (Planet P: all) {
        if(this.equals(P)){
            continue;
        }
        force+=this.calcForceExertedByX(P);
    } 
    return force;

}
public boolean checkCollision(Planet P){
    // for (Planet P: all) {
        // if(this.equals(P)){
        //     continue;
        // }
        if (Math.abs(P.xxPos - this.xxPos)<1e-5){
            return true;
        }
        else{
            return false;
        }
    // }  
}
public double calcNetForceExertedByY(Planet[] all){
    double force =0.0;
    for (Planet P: all) {
        if(this.equals(P)){
            continue;
        }
        force+=this.calcForceExertedByY(P);
    } 
    return force;
}
public void update(double dt,double fX,double fY){
    double ax = fX/this.mass;
    double ay = fY/this.mass;
    this.xxVel += ax*dt;
    this.yyVel += ay*dt;
    this.xxPos += this.xxVel*dt;
    this.yyPos += this.yyVel*dt;
}
public void draw(){
    StdDraw.picture(this.xxPos, this.yyPos, ".\\images\\" + this.imgFileName);
}
}