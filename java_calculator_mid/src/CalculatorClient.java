import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Registry registry= LocateRegistry.getRegistry("localhost",5059);
            Calculator calculator=(Calculator) registry.lookup("calculatorService");
            Scanner scanner=new Scanner(System.in);

            System.out.println("Java RMI Calcultor");
            System.out.println("Available Operations:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("Enter operation number:");

            int op=scanner.nextInt();

            System.out.println("Enter the first number:");
            int a = scanner.nextInt();

            System.out.println("Enter the second number:");
            int b = scanner.nextInt();

            int result=0;

            switch (op){
                case 1:
                    result=calculator.add(a,b);
                    break;
                case 2:
                    result=calculator.sub(a,b);
                    break;
                case 3:
                    result=calculator.multiply(a,b);
                    break;
                case 4:
                    result=calculator.divide(a,b);
                    break;
                default:
                    System.out.println("Invalid operation");
                    System.exit(1);
            }
            System.out.println("Result is: "+result);
            scanner.close();
        } catch (NotBoundException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
