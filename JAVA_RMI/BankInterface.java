import java.rmi.RemoteException;

public interface BankInterface extends java.rmi.Remote {
    // boolean checkClientCredintials(Interface ci,String name, String pass) throws RemoteException;
    

    void bankingSystemDeposit(BankInterface bankinterface, int sendMachineNumber ,int deposit) throws RemoteException;
    void bankingSystemWithdraw(BankInterface bankinterface, int sendMachineNumber ,int amount) throws RemoteException;
    void bankingSystemCheckBalance(int sendMachineNumber) throws RemoteException;

    void sendMessageToClientAboutDeposit(int sendMachineNumber, int deposit) throws RemoteException;
    void sendMessageToClientAboutWithdraw(int sendMachineNumber, int withdraw) throws RemoteException;
    void sendMessageToClientAboutCheckBalance(int sendMachineNumber, int Amount) throws RemoteException;

    void sendMessageToItself(int Amount, int numberOfMachines, String s) throws RemoteException;

    int returnMachineNumber (BankInterface bankinterface) throws RemoteException;
    void print(String message) throws RemoteException;
    void removeMachine (BankInterface bankinterface) throws RemoteException;
    void rejoinMachine (BankInterface bankinterface) throws RemoteException;
    
    int getMachineNumber() throws RemoteException;
    void exit() throws RemoteException;
}