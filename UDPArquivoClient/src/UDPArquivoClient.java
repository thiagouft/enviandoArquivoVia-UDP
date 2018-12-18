
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thiago
 */
public class UDPArquivoClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        //aqui coloca o caminho do arquivo a ser enviado
        FileInputStream fis = new FileInputStream("/home/thiago/Imagens/captura_Easy-Resize.com.jpg");
        byte[] clientBuffer = new byte[65500];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
         
        fis.read(clientBuffer);
        baos.write(clientBuffer);
         
        System.out.println(clientBuffer.length);
         
        DatagramSocket ds = new DatagramSocket(5554);
        InetAddress addr = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(clientBuffer, clientBuffer.length, addr, 5555);
        fis.close();
        ds.send(packet);
        System.out.println("Arquivo enviado");
        
        

    }

}
