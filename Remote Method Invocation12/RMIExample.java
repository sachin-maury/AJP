import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

// Main class that contains all RMI components
public class RMIExample {

    // Remote interface
    public interface Hello extends Remote {
        String sayHello() throws RemoteException;
    }

    // Implementation of the remote interface
    public static class HelloImpl extends UnicastRemoteObject implements Hello {
        protected HelloImpl() throws RemoteException {
            super();
        }

        public String sayHello() throws RemoteException {
            return "Hello from RMI Server!";
        }
    }

    // Server class
    public static class Server {
        public static void main(String[] args) {
            try {
                HelloImpl obj = new HelloImpl();
                Registry registry = LocateRegistry.createRegistry(1099);
                registry.rebind("HelloService", obj);
                System.out.println("RMI Server is running...");
            } catch (Exception e) {
                System.err.println("Server exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }

    // Client class
    public static class Client {
        public static void main(String[] args) {
            try {
                Registry registry = LocateRegistry.getRegistry("localhost", 1099);
                Hello stub = (Hello) registry.lookup("HelloService");
                String response = stub.sayHello();
                System.out.println("Response from server: " + response);
            } catch (Exception e) {
                System.err.println("Client exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }
}
