// Dengan menggunakan 3 jenis cara membuat inputan (Scanner, BufferedReader,
// JoptionPane). Buatlah program sederhana yang memiliki inputan untuk menghitung :
// a. Keliling lingkaran
// b. Luas trapesium
// c. Luas prisma segitiga

// Import essential packages
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JOptionPane; 

class kelilingLingkaran{ // obj hitung keliling lingkaran
    Scanner input = new Scanner(System.in); // Assign scanner obj
    float r; // variable jari jari
    double pi = Math.PI; // pi

    public double hasil(){ // method to return result
        System.out.println("Masukkan nilai jari jari: "); // instruction to waht'll be input
        r = input.nextInt();  // input assigned to jari jari / r
        return (2 * pi) * r; // return value K = 2πr
    }    
}

class LuasTrapesium{ // obj hitung luas tarpesium
    float sisiBawah, sisiAtas, tinggi; 
    public double hasil() throws IOException{ // method mengembalikan hasil 
        InputStreamReader isr = new InputStreamReader(System.in); // assign inputstreamreader to isr
        BufferedReader br = new BufferedReader(isr); // create a bufferreader var

        System.out.print("Masukkan nilai sisi bawah: ");
        sisiBawah = Float.parseFloat(br.readLine()); 

        System.out.print("Masukkan nilai sisi atas: ");
        sisiAtas = Float.parseFloat(br.readLine()); 

        System.out.print("Masukkan nilai tinggi: ");
        tinggi = Float.parseFloat(br.readLine()); 

        double result = ((sisiBawah + sisiAtas) * tinggi) / 2; 
        return result;
    }
}

class Main{
    public static void main(String[] args) throws IOException{
        char option; 
        String hasil, outputDialog; 
        do{
            String opt = JOptionPane.showInputDialog("Pilih perhitungan sesuai nomor dibawah: \n1. Keliling lingkaran\n2. Luas trapesium\n3. Luas primsa segitiga\n0. Tutup program"); 
            option = (opt.isEmpty() ? "0" : opt).charAt(0);

            System.out.println("You chose: " + option);
            
            hasil = switch (String.valueOf(option)) {
                case "1" -> String.valueOf(new kelilingLingkaran().hasil());
                case "2" -> String.valueOf(new LuasTrapesium().hasil());
                case "3" -> "59.4983";
                default -> "Unassigned";
            };
            try {
                outputDialog = "Hasil dari perhitungan tersebut adalah: \n" + String.format("%.2f",(Float.valueOf(hasil))); 
            } catch (NumberFormatException e) {
                outputDialog = "Error: Tolong masukkan angka sesuai yang diberikan"; 
            }
            JOptionPane.showMessageDialog(null, outputDialog);

        }while(!String.valueOf(option).equals("0"));
        System.out.println("finished looping");
    }
}