/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package f13dlaproject;

import java.awt.Graphics;
import java.util.Random;
import static f13dlaproject.Point3.*;

/**
 *
 * @author stu738510
 */
public class Particle3D implements Particle {
    
    /**
     * A unique instance of a particle
     */
    private static Particle2D uniqueInstance;
    /**
     * holds position of a particle.
     */
    private Point3 p;
    /**
     * holds a unit vector of the direction
     */
    private Point3 dir;
    /**
     * holds magnitude of the velocity
     */
    private double vel;
    /**
     * stores the range of the turn
     */
    private double a;
    /**
     * holds the distance value before reset
     */
    private double bounds;
    /**
     * holds the number of particles launched
     */
    private int numLaunched;
    /**
     * a new Random
     */
    private static Random r = new Random();
    
    @Override
    public void setVelocity(double v) {
        this.vel=v;
    }

    @Override
    public void setA(double a) {
        this.a=a;
    }

    @Override
    public void setAngle() {
        double angleMax = a;//Math.cos(a);
        double x=r.nextDouble(),y=r.nextDouble(),z=r.nextDouble();
        Point3 p2 = new Point3(x,y,z);//Makes vector
        Point3 newDir = new Point3(x/p2.length(),y/p2.length(),z/p2.length());//makes it a unit vector
        if(angleDiff(dir,newDir)>angleMax){ setAngle();}//checks to see if the angle is within the cone
        else{dir=newDir;}
    }

    @Override
    public void setPosition() {
        double angleMax = a;//Math.cos(a);
        double x=r.nextDouble(),y=r.nextDouble(),z=r.nextDouble();
        Point3 p2 = new Point3(x,y,z);//Makes vector
        Point3 newDir = new Point3(x/p2.length(),y/p2.length(),z/p2.length());//makes it a unit vector
        p=newDir;
    }

    @Override
    public int getLaunched() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getVelocity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Point getPosition() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getAngle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void draw(Graphics g) {
       
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
