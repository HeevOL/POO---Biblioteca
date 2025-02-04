import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.DataInputStream;


public class Servidor {

    public static void main(String[] args) throws IOException {
        // Abre conexão
        ServerSocket serverSocket = new ServerSocket(12345);

        // Mensagem de confirmação da disponibilidade da porta
        System.out.println("A porta 12345 foi aberta!");
        System.out.println("Servidor esperando receber mensagem do cliente...");

        // Aceita a conexão do cliente
        Socket socket = serverSocket.accept();

        // Mensagem de confirmação da conexão do cliente
        System.out.println("Cliente: " + socket.getInetAddress().getHostAddress() + " conectado");

        // Recebe os dados que o usuario enviou via socket
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        //Salva a mensagem na variavel
        String mensagem = entrada.readUTF();
        String novaMensagem = mensagem.toUpperCase();

        // Retorna o resultado o cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF(novaMensagem);

        entrada.close();
        saida.close();

        socket.close();
        serverSocket.close();
    }
}