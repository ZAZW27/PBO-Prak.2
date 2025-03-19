// Dengan menggunakan 3 jenis cara membuat inputan (Scanner, BufferedReader,
// JoptionPane). Buatlah program sederhana yang memiliki inputan untuk menghitung :
// a. Keliling lingkaran
// b. Luas trapesium
// c. Luas prisma segitiga

import java.io.IOException;
import javax.swing.JOptionPane; 

class kelilingLingkaran{
    
}

class Main{
    public static void main(String[] args) throws IOException{
        char option; 
        String hasil; 
        String outputDialog; 
        do{
            String opt = JOptionPane.showInputDialog("isr"); 
            option = (opt.isEmpty() ? "q" : opt).charAt(0);

            System.out.println("You chose: " + option);
            
            switch (Integer.parseInt(String.valueOf(option))) {
                case 1: 
                    hasil = "43.5123412"; 
                    break; 
                case 2: 
                    hasil = "654.12312"; 
                    break; 
                case 3: 
                    hasil = "59.4983"; 
                    break; 
                default: 
                    hasil = "error"; 
            }
            try {

                outputDialog = "Hasil dari perhitungan tersebut adalah: \n" + String.format("%.2f",(Float.parseFloat(hasil))); 
            } catch (Exception e) {
                outputDialog = "Error: Tolong masukkan angka sesuai yang diberikan"; 
            }
            JOptionPane.showMessageDialog(null, outputDialog);

        }while(!String.valueOf(option).equals("q"));
        System.out.println("finished looping");
    }
}