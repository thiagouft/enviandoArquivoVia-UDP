
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class UDPArquivoServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        DatagramSocket ds = new DatagramSocket(5555);

        byte[] receivedPacket = new byte[65500];
        DatagramPacket packet = new DatagramPacket(receivedPacket, receivedPacket.length);
        ds.receive(packet);

        System.out.println("Arquivo recebido..");

       // InetAddress inetAddress = InetAddress.getLocalHost();
        //imagem que vai ser recebida
        FileOutputStream fos = new FileOutputStream("/home/thiago/Imagens/capturaNova.jpg");
        byte[] data = packet.getData();

        fos.write(data);

        fos.flush();
        fos.close();
    }
}
