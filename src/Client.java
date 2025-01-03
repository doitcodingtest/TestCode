import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    final static String SERVER_IP = "localhost";
    final static int SERVER_PORT = 1234;
    final static String MESSAGE_TO_SERVER = "Hello! Server!";

    public String receiveDateFromServer() {
        Socket socket;
        String message = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);

            OutputStream os = socket.getOutputStream();
            os.write(MESSAGE_TO_SERVER.getBytes());
            os.flush();

            InputStream is = socket.getInputStream();
            byte[] data = new byte[16];
            int n = is.read(data);
            message = new String(data, 0, n);
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return message;
    }
}