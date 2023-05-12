import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            Calculator calculator=new CalculatorImp();
            Registry registry= LocateRegistry.createRegistry(5059);
            registry.rebind("calculatorService",calculator);
            System.out.println("calculator service is running");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
