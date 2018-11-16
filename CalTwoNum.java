import java.util.Scanner;
import java.lang.Math;
import java.util.InputMismatchException;

public class CalTwoNum {

  public CalTwoNum(){}

  //checks that impending user input is a valid int
  private int checkInt(Scanner scan){
    boolean badInt = true;
    int checkedInt = 0;
    while(badInt){
      try{
        checkedInt = scan.nextInt();
        badInt = false;
      }
      catch (InputMismatchException e) {
        System.out.println("Value must be a whole number!");
        scan.nextLine();
        System.out.print("Please enter a whole number: ");
        badInt = true;
      }
    }
    return checkedInt;
  }

  //checks that impending user input is a valid double
  private double checkDouble(Scanner scan){
    boolean badDouble = true;
    double checkedDouble = 0;
    while(badDouble){
      try{
        checkedDouble = scan.nextDouble();
        badDouble = false;
      }
      catch (InputMismatchException e) {
        System.out.println("Value must be a number!");
        scan.nextLine();
        System.out.print("Please enter a number: ");
        badDouble = true;
      }
    }
    return checkedDouble;
  }

  public static void main(String[] args) {

      double num1, num2, res;
      boolean repeat = false;
      String ope, cont;
      Scanner sc = new Scanner(System.in);
      CalTwoNum culator = new CalTwoNum();

      System.out.println("Enter First Number: ");
      num1 = culator.checkDouble(sc);

      do{
        System.out.println("Enter Second Number: ");
        num2 = culator.checkDouble(sc);

        System.out.println("Enter operation: ");
        ope = sc.next();

        ope = ope.substring(0,1);
        res = 0;
        if(ope.contains("a") || ope.contains("A") || ope.contains("+") ){
          res = num1 + num2;
        }else if (ope.contains("s") || ope.contains("S") || ope.contains("-")) {
          res = num1 - num2;
        }else if (ope.contains("m") || ope.contains("M") || ope.contains("*")) {
          res = num1 * num2;
        }else if (ope.contains("d") || ope.contains("D") || ope.contains("/")) {
          if (num2 != 0) {
            res = Math.round((num1 / num2)*100)/100;
          }else {
            System.out.println("Du kan INTE dividera med 0!!!");
          }
        }else {
          System.out.println("Valj mellan Addition, Subtraktion, Multiplikation eller Division");
        }

        System.out.println("Result of these numbers: "+res);
        System.out.println("Would you like to perform another operation on the result?");
        cont = sc.next().substring(0,1);

        if (cont.contains("y") || cont.contains("Y")) {
          repeat = true;
          num1 = res;
        }else {
          repeat = false;
        }
    }while(repeat);
    sc.close();
  }
}
