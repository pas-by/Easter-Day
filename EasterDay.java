// EasterDay.java
// reference: Practical Astronomy With Your Calculator

import java.util.*;
import java.text.*;

public class EasterDay{

  protected int n, p, year;

  public EasterDay(int year){
    int a, b, c, d, e, f, g, h, i, k, l, m;

    this.year = year;

    a = year%19;
    b = year/100;
    c = year%100;

    d = b/4;
    e = b%4;

    f = (b+8)/25;

    g = (b-f+1)/3;

    h = (19*a+b-d-g+15)%30;

    i = c/4;
    k = c%4;

    l = (32+2*e+2*i-h-k)%7;

    m = (a+11*h+22*l)/451;

    int temp = (h+l-7*m+114);

    n = temp/31;

    p = temp%31;
  }

  public GregorianCalendar getDate(){
    return(new GregorianCalendar(year, n-1, p+1));
  }

  public static void main(String[] args){
    if(args.length<1){
        System.out.println("usage : java EasterDay year");
        System.out.println("eg    : java EasterDay 2109");
        System.exit(0);
    }

    EasterDay easterDay = new EasterDay(Integer.parseInt(args[0]));
    GregorianCalendar easterDate = easterDay.getDate();
    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    System.out.print(df.format(easterDate.getTime()));
  }
}
