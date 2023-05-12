import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImp extends UnicastRemoteObject implements Calculator  {

    protected CalculatorImp() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a*b;
    }

    @Override
    public int divide(int a, int b) throws RemoteException {
        return a/b;
    }
}
