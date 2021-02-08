/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3_cesar;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ICOM
 */
public class Tp3_cesar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                String directory = System.getProperty("user.home");
String fileName = "tp03.txt";
String absolutePath = directory + File.separator + fileName;
       
        System.out.print("1.chiffrement\n2. Dechiffrement\nChoose(1 ou 2): ");
        Scanner in = new Scanner(System.in);
        int choix = in.nextInt();
        switch (choix) {
            case 1:
                System.out.println("chiffrement");
                in.nextLine(); 
                
                System.out.println("Entre text: ");
                String msg = in.nextLine();
                System.out.print("Entre the key: "); 
                int key = in.nextInt();
                String Msg = "";
                for (int i = 0; i < msg.length(); i++) {
                    
                    if ((int)msg.charAt(i) == 32){
                        Msg += (char)32; 
                        
                    } else if ((int)msg.charAt(i) + key > 122){
                        int temp = ((int)msg.charAt(i) + key) - 122;
                        Msg += (char)(96 + temp);
                        
                    } else if ((int)msg.charAt(i) + key > 90 && (int)msg.charAt(i) < 96){
                        int temp = ((int)msg.charAt(i) + key) - 90;
                        Msg += (char)(64+temp);
                        
                    } else {
                        Msg += (char)((int)msg.charAt(i) + key);
                        
                    }
                } 
                System.out.println(Msg);
              
                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
                String fileContent =Msg ;
                bufferedWriter.write(fileContent);
                } catch (IOException e) {
                
                }
                break;
                case 2:
                System.out.println("Dechiffrement");
                in.nextLine();
                System.out.println("give the crypted text: ");
                String encypText = in.nextLine();
                System.out.println("Entre the key: ");
                int dcCle = in.nextInt();
                String decMsg = "";
                for (int i = 0; i < encypText.length(); i++) {
                   
                    if((int)encypText.charAt(i) == 32){
                        decMsg += (char)32;
                    } else if (((int)encypText.charAt(i) - dcCle) < 97 && ((int)encypText.charAt(i) - dcCle) > 90) {
                        //lower case
                        int temp = ((int)encypText.charAt(i) - dcCle) + 26;
                        decMsg += (char)temp;
                    } else if ((encypText.charAt(i) - dcCle) < 65) {
                        
                        int temp = ((int)encypText.charAt(i) - dcCle) + 26;
                        decMsg += (char)temp;
                    } else {
                        decMsg += (char)((int)encypText.charAt(i) - dcCle);
                    }
                    
                } 
                System.out.println(decMsg);
                                try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(absolutePath))) {
    String fileContent =decMsg ;
    bufferedWriter.write(fileContent);
} catch (IOException e) {
    
}
                break;
            default:
                System.out.println("Erreur");
                break;
        }
    }
    
}
