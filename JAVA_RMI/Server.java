import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.io.IOException;

public class Server extends UnicastRemoteObject implements BankInterface {
    private static final long serialVersionUID = 1L;
    private static final String servername = "hyobin";
    private ArrayList<BankInterface> clientList;
    private int MachineNumber = 0;
    private int Amount = 0;

    protected Server() throws RemoteException {
        clientList = new ArrayList<BankInterface>();
    }

    
    public void exit() throws RemoteException{
        try{
            Naming.unbind(servername);
            System.out.println("CalculatorServer exiting.");
        }
        catch(Exception e){}

        System.exit(1);
    }

    public synchronized int returnMachineNumber (BankInterface bankinterface) throws RemoteException{
        this.clientList.add(bankinterface);
        return MachineNumber++;
    }

    public synchronized void removeMachine (BankInterface bankinterface) throws RemoteException{
        this.clientList.remove(bankinterface);
    }

    public synchronized void rejoinMachine (BankInterface bankinterface) throws RemoteException{
        this.clientList.add(bankinterface);
    }

    public synchronized int getMachineNumber() throws RemoteException{
        return -1;
    }
 
    public synchronized void bankingSystemDeposit(BankInterface bankinterface, int sendMachineNumber, int deposit) throws RemoteException{
        Amount = Amount + deposit;
        int numberOfMachines = clientList.size();
        String s = "";

        if(numberOfMachines == 1) {
            s = "";
        } else {
            s = "s";
        }
        for(int i =0; i<numberOfMachines; i++){
            if(clientList.get(i).getMachineNumber() == sendMachineNumber) {
                bankinterface.sendMessageToItself(Amount,  numberOfMachines-1,  s);
                continue;
            }
            clientList.get(i).sendMessageToClientAboutDeposit(sendMachineNumber+1, Amount);
        }
    }

    public synchronized void bankingSystemWithdraw(BankInterface bankinterface, int sendMachineNumber, int withdraw) throws RemoteException{
        if(Amount >= withdraw) {
            Amount = Amount - withdraw;
        } else {
            bankinterface.print("Insufficient funds.\n");
            return;
        }
        
        int numberOfMachines = clientList.size();
        String s = "";
        if(numberOfMachines == 1) {
            s = "";
        } else {
            s = "s";
        }
        for(int i =0; i<numberOfMachines; i++){
            if(clientList.get(i).getMachineNumber() == sendMachineNumber) {
                bankinterface.sendMessageToItself(Amount,  numberOfMachines-1,  s);
                continue;
            } 
            clientList.get(i).sendMessageToClientAboutWithdraw(sendMachineNumber+1, Amount);
        }
    }

    public synchronized void bankingSystemCheckBalance(int sendMachineNumber) throws RemoteException{
        int numberOfMachines = clientList.size();
        for(int i =0; i<numberOfMachines; i++){
            clientList.get(i).sendMessageToClientAboutCheckBalance(sendMachineNumber, Amount);
        }
    }

    public synchronized void sendMessageToClientAboutDeposit(int sendMachineNumber, int Amount) throws RemoteException{}
    public synchronized void sendMessageToClientAboutWithdraw(int sendMachineNumber, int Amount) throws RemoteException{}
    public synchronized void sendMessageToClientAboutCheckBalance(int sendMachineNumber, int Amount) throws RemoteException{}

    public synchronized void sendMessageToItself(int Amount, int numberOfMachines, String s) throws RemoteException{}
    public void print(String message) throws RemoteException {}

    public final static void clearConsole(){
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) Runtime.getRuntime().exec("cls");
            else Runtime.getRuntime().exec("clear");
        }
        catch (final Exception e) {}
    }

    public static void main(String[] arg) throws RemoteException, MalformedURLException {
        System.out.println("[RMI-Server] START");
        try {
            Naming.rebind(servername, new Server());
            while (true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { Naming.unbind(servername); } catch (Exception e) {}
        }
        System.out.println("[RMI-Server] EXIT");
    }
}