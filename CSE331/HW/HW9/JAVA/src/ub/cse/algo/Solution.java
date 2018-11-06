package ub.cse.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    
    private Integer _n_points;          // Number of points in the plane
    private ArrayList<Point> _points;  // This ArrayList contains all points in the plane
    
    public Solution (Integer n_points, ArrayList<Point> points){
        _n_points = n_points;
        _points = points;
    }
    
    public double outputClosestDistance(){
        Collections.sort(_points, new Comparator<Point>(){
            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1._x, o2._x);
            } 
        });
        return closest_pair(_n_points, _points);
    }
    public double euclidean(Point a, Point b){
        return Math.sqrt(Math.pow((a._x-b._x), 2)+Math.pow((a._y-b._y), 2));
    }
    public double brute_force(Integer n, ArrayList<Point> points){
        double dist = Double.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double d = euclidean(points.get(i), points.get(j));
                if(dist > d){
                    dist = d;
                }
            }
        }
        return dist;
    }
    public double closest_pair(Integer n, ArrayList<Point> points){
        if(n < 4){
            return brute_force(n, points);
        }
        int mid = n/2;
        ArrayList<Point> left = new ArrayList<Point>();
        ArrayList<Point> right = new ArrayList<Point>();
        left.addAll(points.subList(0, mid));
        right.addAll(points.subList(mid, n));
        double leftmin = closest_pair(mid, left);
        double rightmin = closest_pair(n-mid, right);
        double min = Math.min(leftmin, rightmin);
        ArrayList<Point> s = new ArrayList<Point>();
        for(Point p:points){
            if(Math.abs(p._x - points.get(mid)._x) < min){
                s.add(p);
            }
        }
        Collections.sort(s, new Comparator<Point>(){
            @Override 
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1._y, o2._y);
            } 
        });
        for(int i=0; i<s.size(); i++){
            for(int j=i+1; j<s.size(); j++){
                if(s.get(j)._y - s.get(i)._y > min){
                    break;
                }
                double d = euclidean(s.get(j), s.get(i));
                if(d < min){
                    min = d;
                }
            }
        }
        return min;
    }
}