import java.util.Scanner;
public class Excercise_8_7 {

  public static void main(String[] args) {
    double[][] points = inputArray();
    closestPoints(points);
  }
  
  static double[][] inputArray() { 
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of points: ");
    int numOfPoints = sc.nextInt();
  
    double[][] points = new double[numOfPoints][2];
    System.out.print("Enter " + numOfPoints + " points: ");
    for(int i = 0; i < points.length; i++) {
      points[i][0] = sc.nextDouble();
      points[i][1] = sc.nextDouble();
      System.out.println("point " + i + "( " + points[i][0] + ", " + points[i][1] + ")");
    }
    return points;
    
  }
  
  static int[] closestPoints(double[][] p) {
    int p1 = 0, p2 = 0, p3 = 0;
    double shortestDistance = distance(p[0][0], p[0][1], p[1][0], p[1][1], p[2][0], p[2][1] );
    //compute distance for every two points
    for(int i = 0; i < p.length; i++) { 
      for(int j = i + 1; j < p.length; j++) { 
        for(int k = j + 1; k < p.length; k++) {
        double distance = distance(p[i][0], p[i][1], p[j][0], p[j][1], p[k][0], p[k][1]);  //find distance
        if(shortestDistance > distance) { 
          p1 = i; //update p1
          p2 = j; //update p2
          p3 = k;
          shortestDistance = distance;  //update shortestDistance
          }
        }
      }
    }
    System.out.println("The closest two points are (" + p[p1][0] + ", " + p[p1][1] 
        + ") and (" + p[p2][0] + ", " + p[p2][1] + ")");
    
    int[] closestPointsLoc = {p1, p2};
    return closestPointsLoc;
  }
  
  static void displayClosest(int[] closePoints) { 
    double[][] points = inputArray();
    int a = closePoints[0];
    int b = closePoints[1];
    System.out.println("The closest two points are (" + points[a][0] + ", " + points[a][1] 
      + ") and (" + points[b][0] + ", " + points[b][1] + ")");
  }

  private static double distance(double x1, double x2, double y1, double y2, double z1, double z2) { 
    return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2) + Math.pow(z2-z1, 2));
  }
}
