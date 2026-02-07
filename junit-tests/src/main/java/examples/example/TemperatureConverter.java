package examples.example;

public class TemperatureConverter {

    double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit-32) * 5/9;
    }
    double celsiusToFahrenheit(double celsius){
        return ((celsius * 9/5) + 32);
    }
    boolean isExtremeTemp(double celsius){
        return celsius < -40 || celsius > 50;
    }

//    static void main(String[] args) {
//        TemperatureConverter tc = new TemperatureConverter();
//        System.out.printf( "Celsius to fahrenheit: %.1f%n" , tc.celsiusToFahrenheit(20));
//        System.out.printf( "Fahrenheit to celsius: %.1f%n" , tc.fahrenheitToCelsius(100));
//        System.out.println("Is 25 degree celsius extreme temp: " + tc.isExtremeTemp(25));
//        System.out.println("Is -55 degree celsius extreme temp: " + tc.isExtremeTemp(-55));
//
//    }
}
