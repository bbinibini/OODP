import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.net.MalformedURLException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements BankInterface , Runnable {
    private static final long serialVersionUID = 1L;
    private BankInterface server;
    int MachineNumber = 0;
    boolean Exit = true;
    boolean ExitProgram = true;

    protected Client (BankInterface bankinterface) throws RemoteException {
        this.server = bankinterface;
        this.MachineNumber = server.returnMachineNumber(this);
    }

    public int getMachineNumber(){
        return this.MachineNumber;
    }

    public int returnMachineNumber(BankInterface bankinterface) throws RemoteException {
        return 0;
    }

    public void exit() throws RemoteException{
        
    }

    public void removeMachine (BankInterface bankinterface) throws RemoteException{}
    public void rejoinMachine (BankInterface bankinterface) throws RemoteException{}

    public void bankingSystemDeposit(BankInterface bankinterface, int MachineNumber, int deposit) throws RemoteException {}
    public void bankingSystemWithdraw(BankInterface bankinterface, int MachineNumber, int withdraw) throws RemoteException {}
    public void bankingSystemCheckBalance(int MachineNumber) throws RemoteException {}

    public void sendMessageToClientAboutDeposit(int sendMachineNumber, int Amount) throws RemoteException{
        System.out.println("\nMachine " + (MachineNumber+1) + " : Receiving the balance from Machine " + sendMachineNumber);
        System.out.println("The received amount is " + Amount + " dollars.");
        System.out.println("The current balance is " + Amount + " dollars.\n");
        this.menu();
    }

    public void sendMessageToClientAboutWithdraw(int sendMachineNumber, int Amount) throws RemoteException{
        System.out.println("\nMachine " + (MachineNumber+1) + " : Receiving the balance from Machine " + sendMachineNumber);
        System.out.println("The received amount is " + Amount + " dollars.");
        System.out.println("The current balance is " + Amount + " dollars.\n");
        this.menu();
    }

    public void sendMessageToClientAboutCheckBalance(int sendMachineNumber, int Amount) throws RemoteException{
        System.out.println("\nCheck Balance : " + Amount);
        System.out.println("The current balance is " + Amount + " dollars.\n");
        if (sendMachineNumber != this.MachineNumber) this.menu();
    }

    public synchronized void sendMessageToItself(int Amount, int numberOfMachines, String s) throws RemoteException{
        System.out.println("The current balance is " + Amount + " dollars.");
        System.out.println("Sending to other " + numberOfMachines + " machine" + s+ " the balance ..\n");
    }

    public void print(String message){
        System.out.println(message);
    }

    public void menu(){
        System.out.println("[ Machine : " + (MachineNumber+1) + " ]");
        System.out.println("Choose your request : ");
        System.out.println("(D)eposit, (W)ithdraw, (C)heckBalance or (Q)uit");
    }

    public final static void clearConsole(){
        try
        {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) Runtime.getRuntime().exec("cls");
            else Runtime.getRuntime().exec("clear");
        }
        catch (final Exception e) {}
    }

    public void run() {
        clearConsole();
        System.out.println("Successfully Connected To RMI Server");
        Scanner scanner = new Scanner(System.in);
        int deposit = 0;
        int withdraw = 0;
        String input = "";
        
        while(ExitProgram){
            while(Exit) {
                menu();
                input = scanner.next().toUpperCase();
                if(input.equals("Q")) {
                    Exit = false;
                }
                else {
                    try {
                        if(input.equals("D")){
                            System.out.print("Deposit_Amount : ");
                            deposit = Integer.parseInt(scanner.next());
                            server.bankingSystemDeposit(this, MachineNumber, deposit);
                        } else if (input.equals("W")){
                            System.out.print("Withdraw_Amount : ");
                            withdraw = Integer.parseInt(scanner.next());
                            server.bankingSystemWithdraw(this, MachineNumber, withdraw);
                        } else if (input.equals("C")){
                            server.bankingSystemCheckBalance(MachineNumber);
                        } else {
                            System.out.print("wrong input.");
                        }
                    }
                    catch(RemoteException e) {
                        e.printStackTrace();
                    }
                }  
            } 
            try{
                server.removeMachine(this);
            } catch(RemoteException e){
                e.printStackTrace();
            }
            System.out.println("Quit : Machine " + (MachineNumber + 1) + " is stopped.");

            while(true){
                System.out.println("\nDo you want to rejoin? (Y/N) : ");
                input = scanner.next().toLowerCase();
                if(input.equals("y")) {
                    try{
                        server.rejoinMachine(this);
                    } catch (RemoteException e){
                        e.printStackTrace();
                    }
                    Exit = true;
                    System.out.println("");
                    break;
                } else if(input.equals("n")){
                    System.out.println("bye");
                    ExitProgram = false;
                    break;
                }
                System.out.println("wrong input. select again");
            }
        }
    }
    
    public static void main(String[] args) throws MalformedURLException,RemoteException,NotBoundException {
        System.out.println("\nConnecting To RMI Server...\n");
        String host = (args.length < 1) ? "127.0.0.1" : args[0];
        String url = "rmi://" +host+ "/hyobin";
        try {
            BankInterface bankinterface = (BankInterface)Naming.lookup(url);
            // new Thread(new Client(bankinterface)).start();
            Thread t = new Thread(new Client(bankinterface));
            // t.setDaemon(true);
            t.start();
            System.out.println("thread is done.");

        } catch (Exception e){
            System.err.println("Client exception : " + e.toString());                                
            e.printStackTrace();
        }
    }
}