/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servermultithread;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guagliumi.gianluca
 */
public class ServerThread implements Runnable {

    private Socket clientSocket;

    public ServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Serverino  partito: "
                + clientSocket.getInetAddress());
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String richiesta = "";
            while (!richiesta.equals("exit")) {
                System.out.println("serverino in ascolto...");
                richiesta = in.readLine();
                System.out.println(richiesta);
                int n;
                n = Integer.parseInt(richiesta);
                ArrayList<String> NumbList = new ArrayList<String>();
                
                for(int i = 0; i<n; i++){
                    Processo p = new Processo(i);
                    String s = Integer.toString(p.getN());
                    NumbList.add(s);

                }

                int s1 = Integer.parseInt(NumbList.get(0));
                int s2 = Integer.parseInt(NumbList.get(1));
                int s3 = Integer.parseInt(NumbList.get(2));
                int somma = s1 + s2 + s3;
                System.out.println(somma);
            }
            
            

            clientSocket.close();

            System.out.println("chiusura connessione effettuata");

        } catch (IOException ex) {
            Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
