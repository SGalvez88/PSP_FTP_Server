import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try (

            ServerSocket server = new ServerSocket(2000);
            Socket service = server.accept();
            DataInputStream sockectIn = new DataInputStream(service.getInputStream());
            DataOutputStream socketOut = new DataOutputStream(service.getOutputStream());
        ){
            //Leer el mensaje desde el cliente
            String message = sockectIn.readUTF();
            System.out.println("recibido: "+ message);
            socketOut.writeUTF("GoodBye");


        }catch (IOException exception){
            System.err.println(exception);
        }



    }
}