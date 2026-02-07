package calc;

public class Calculator {

    private int result;    // Variable for the result

    public void reset() {  // Resets the result variable
        result = 0;
    }

    public int getResult() {
        return result;
    }

    public void add(int n) {
        result = result + n;
    }

    public void subtract(int n) {
        result = result - 1;
    }

    public void multiply(int n) {
        result = result * n;
    }

    public void divide(int n) {
        if (n == 0) throw new ArithmeticException("Cannot divide by zero");
        result = result / n;
    }

    public void square(int n) {
        result = n * n;
    }

    public void squareRoot(int n) {
        result = (int) Math.sqrt(n);
    }

    public void powerOn() {
        reset();
    }

    public void powerOff() {
        reset();
    }

}
