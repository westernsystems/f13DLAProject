/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package f13dlaproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import static f13dlaproject.Point2.*;
import static f13dlaproject.Particle.*;
/**
 *
 * @author Graham and Ryan
 */
public class Crystal {
    
    private static Crystal instance;
    private int count;
    private double radius;
    private double zoom = 5;
    private ArrayList<CParticle> parts = new ArrayList();
    
    /*
     * Declaration of inner CParticle class
     * Be each node in crystal
     */
    private class CParticle{
        private Point2 p; //position of node
        private int num; //number in which it was added to crystal
        private double dist; //distance from center of cystal
        
        public CParticle(Point2 p, int num){ //constructor
            this.p = p.clone(p);
            this.num = num;
            this.dist = Math.sqrt(Math.pow(p.getX(), 2)+Math.pow(p.getY(), 2));
        }
        
        public void draw(Graphics g){ //draw
            g.setColor(Color.BLACK);
            g.fillOval((int)(p.getX()*zoom)+200, (int)(p.getY()*zoom)+200, 10, 10);
        } 
        
        public boolean collides(){
            Particle t = particle();
            Point2 pos = t.getPosition();
            double dist = Math.sqrt(Math.pow(p.getX()- pos.getX(),2)+Math.pow(p.getY()-pos.getY(), 2));
            if (dist < 1){
                return true;
            }
            return false;
        }
        
    }
    
    private Crystal(){ //constructor
        this.count = 1;
        this.radius = 0;
        parts.add(new CParticle(point2(0,0), count));
    }
    
    public double getRadius(){
        return radius;
    }
    
    public double getZoom(){
        return zoom;
    }
    
    public void add(Particle p){//adds node to crystal
        count ++;
        CParticle part = new CParticle(p.getPosition(), count);
        parts.add(part);
        double dist = Math.sqrt(Math.pow(part.p.getX(), 2)+Math.pow(part.p.getY(), 2));
        if(dist > radius){
            radius = dist;
        }
    }
    
    public int getSize(){ //returns the number of nodes
        return count;
    }
    
    public void clear(){ //resets the cystal to nothing
        parts = new ArrayList();
        count = 0;
    }
    
    public boolean collides(){
        for(CParticle p: parts){
            if(p.collides()){
                this.add(particle());
                return true;
            }
        }
        return false;
    }
    
    public void draw(Graphics g){//iterates the nodes and draws each one
        for(CParticle p: parts){
            p.draw(g);
        }
    }
    
    /*
     * Singleton static factory
     */
    public static Crystal crystal(){
        if(instance == null){
            instance = new Crystal();
        }
        return instance;
    }
    
    @Override
    public String toString(){ // toString()
        return "Size: " + count;
    }
    
}