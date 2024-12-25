
import java.io.*;
import java.net.Socket;

public class FileClient {

    public static void main(String[] args) {
        String serverAddress = "2607:fea8:21b:9600:7c9e:1288:876b:4df4"; // Replace with server's public IP or domain
        int port = 1920; // Server's port number
        String filePath = "input.txt"; // Path to the file you want to send

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to the server");

            // Send the file
            try (FileInputStream fileIn = new FileInputStream(filePath); OutputStream out = socket.getOutputStream()) {

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileIn.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                System.out.println("File sent successfully");
            } catch (IOException e) {
                System.err.println("Error sending file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
