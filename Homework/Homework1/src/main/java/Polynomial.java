
// import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Scanner;
import java.util.ArrayList;
// import org.junit.jupiter.api.Test;

public class Polynomial {
    public static void main(String[] args) {
        ArrayList<Term> polynomial = new ArrayList<Term>();
        String flag = "";

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter each term of the desired polynomial. \n");

        do {
            Term term = new Term();

            System.out.println("Please enter the coefficient of the term");
            term.setCoefficient(input.nextDouble());
            input.nextLine();

            System.out.println("Please enter the exponent of the term");
            term.setExponent(input.nextDouble());
            input.nextLine();

            if (polynomial.size() == 0) {
                polynomial.add(term);
            } else if (polynomial.get(0).getExponent() < term.getExponent()) {
                polynomial.add(0, term);
            } else if (polynomial.get(polynomial.size() - 1).getExponent() > term.getExponent()) {
                polynomial.add(term);
            } else {
                for (int i = 0; i < polynomial.size() - 1; i++) {
                    if (polynomial.get(i).getExponent() > term.getExponent()
                            && polynomial.get(i + 1).getExponent() <= term.getExponent()) {
                        polynomial.add(i + 1, term);

                    }
                }
            }

            System.out.println("Do you want to add another term?");
            System.out.println("Type 'no' to terminate");
            System.out.println("Select any key to continue \n");
            flag = input.next();
            flag.toLowerCase();

        } while (!flag.equals("no"));

        System.out.println("You polynomial is: \n\n");
        System.out.println(polynomial.size());

        for (int i = 0; i < polynomial.size() - 1; i++) {
            System.out.print(polynomial.get(i));

            if (polynomial.get(i + 1).getCoefficient() >= 0) {
                System.out.print(" + ");
            } else {
                System.out.print(" - ");
            }
        }
        System.out.println(polynomial.get(polynomial.size() - 1));

    }

}