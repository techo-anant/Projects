
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class ServerClient {

    public void Server(int port) {
        List<String> RecievedfileNames = new ArrayList<>();
        try (ServerSocket reciever = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);
            Socket socket = reciever.accept();
            System.out.println("Connected to client " + socket.getInetAddress());

            try (DataInputStream dis = new DataInputStream(socket.getInputStream())) {
                int fileCount = dis.readInt();
                System.out.println("Recieving :" + fileCount + " files.");
                int fileRecieved = 0;

                for (int i = 1; i <= fileCount; i++) {
                    String fileName = dis.readUTF();
                    long fileSize = dis.readLong();
                    System.out.println("Recieving file : " + fileName + "; Size : " + fileSize + "bytes.");

                    try (FileOutputStream fos = new FileOutputStream(fileName)) {
                        byte[] buffer = new byte[4096];
                        long totalRead = 0;
                        int byteRead;

                        while (totalRead < fileSize && (byteRead = dis.read(buffer)) != -1) {
                            fos.write(buffer, 0, byteRead);
                            totalRead += byteRead;
                        }

                        System.out.println("File " + fileName + " Recieved.");
                        RecievedfileNames.add(fileName);
                        fileRecieved++;

                    } catch (IOException e) {
                        System.err.println("Error recieving file :" + e.getMessage());
                    }
                }
                if (fileRecieved == fileCount) {
                    System.out.println("All Files Recieved.");
                } else {
                    System.out.println("Some files are missing.");
                }
            } catch (IOException e) {
                System.err.println("Error recieving file :" + e.getMessage());
            }

            socket.close();

        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public void client(int port, String IP, List<String> FilePaths) {
        try (Socket socket = new Socket(IP, port); DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {
            System.out.println("Connected to the server at port : " + port);
            dos.writeInt(FilePaths.size());

            for (String filePath : FilePaths) {
                File file = new File(filePath);
                String fileName = file.getName();
                long fileSize = file.length();

                dos.writeUTF(fileName);
                dos.writeLong(fileSize);

                System.out.println("Sending file : " + fileName + "; Size : " + fileSize + " bytes.");
                try (FileInputStream fileIn = new FileInputStream(filePath)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fileIn.read(buffer)) != -1) {
                        dos.write(buffer, 0, bytesRead);
                    }

                    System.out.println("File " + fileName + " sent successfully");
                } catch (IOException e) {
                    System.err.println("Error sending file: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }
}
