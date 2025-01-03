import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class DateServer extends Thread {

    final static int PORT = 1234;
    final static String MESSAGE = LocalDate.now().toString();

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            while (true) {
                Socket socket = serverSocket.accept();

                OutputStream os = socket.getOutputStream();
                os.write( MESSAGE.getBytes() );
                os.flush();
                os.close();

                InputStream is = socket.getInputStream();
                byte[] data = new byte[16];
                int n = is.read(data);
                final String message = new String(data,0,n);
                System.out.println(message);
                is.close();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}