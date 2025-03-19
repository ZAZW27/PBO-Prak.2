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
    // K=2πr
    // r = Jari-jari lingkaran
    // dd = Diameter lingkaran (d=2rd=2r)  
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
    // L=21​×(a+b)×t
    // a = Panjang sisi atas (sisi sejajar yang lebih pendek)
    // b = Panjang sisi bawah (sisi sejajar yang lebih panjang)
    // t = Tinggi trapesium (jarak tegak lurus antara sisi sejajar)
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

        double result = 0.5 * ((sisiBawah + sisiAtas) * tinggi); 
        return result;
    }
}

class PrismaSegitiga{ // obj hitung luas pemrukaan prisma segitiga
    // panjangAlas = Panjang alas segitiga
    // tinggiSegitiga = Tinggi segitiga alas
    // kelilingAlas = Keliling segitiga alas
    // tinggiPrisma = Tinggi prisma (jarak antara kedua alas segitiga)
    float panjangAlas, tinggiSegitiga, kelilingAlas, tinggiPrisma;  // Inisiasi variable yang akan digunakan
    Scanner input = new Scanner(System.in); // inisiasi obj scanner dalam sebuah variable
    public double hasil(){ // Membuat method untuk kembalikan hasil perhitungan dan inputan
        System.out.print("Masukkan panjang alas segitiga (a): ");
        panjangAlas = input.nextFloat(); // mengisi panjang alas

        System.out.print("Masukkan tinggi segitiga alas (t): ");
        tinggiSegitiga = input.nextFloat(); // mengisi tinggi alas

        System.out.print("Masukkan keliling segitiga alas (K'alas): ");
        kelilingAlas = input.nextFloat(); // mengisi keliling segitiga

        System.out.print("Masukkan tinggi prisma (T): ");
        tinggiPrisma = input.nextFloat(); // mengisi tinggi prisma
        // melakukan kalkulasi seperti berikut: L=2×(21​×a×t)+(Kalas​×T)
        double hasil = (2 * (0.5 * panjangAlas * tinggiSegitiga)) + (kelilingAlas * tinggiPrisma); 
        return hasil; 
    }
}

class Main{
    public static void main(String[] args){ 
        char option; // membuat variabel option dengan tipe data char (hanya 1 nilai)
        String hasil, outputDialog;  // membuat 2 variable hasil dan output dialog
        do{ // menggunakan do while agar program di dalamnya akan jalan sebelum cek kondisi loop
            // menambahkan dialog pilihan
            String opt = JOptionPane.showInputDialog("Pilih perhitungan sesuai nomor dibawah: \n1. Keliling lingkaran\n2. Luas trapesium\n3. Luas primsa segitiga\n0. Tutup program"); 
            option = (opt.isEmpty() ? "0" : opt).charAt(0); // memilih pilihan 0-3
            
            hasil = switch (String.valueOf(option)) { // menggunakan switch case untuk cek jika nilai yang diberikan sesuai dengan ketentuan case dibawah
                case "1" -> String.valueOf(new kelilingLingkaran().hasil()); // input: 1
                case "2" -> String.valueOf(new LuasTrapesium().hasil()); // input: 2
                case "3" -> String.valueOf(new PrismaSegitiga().hasil()); // input: 4
                default -> "Unassigned";
            };
            try { // mencoba konversi string menjadi float
                outputDialog = "Hasil dari perhitungan tersebut adalah: \n" + String.format("%.2f",(Float.valueOf(hasil))); 
            } catch (NumberFormatException e) { // jika gagal maka akan menghasilkan error dibawah
                outputDialog = "Error: Tolong masukkan angka sesuai yang diberikan"; 
            }
            JOptionPane.showMessageDialog(null, outputDialog); // hasil perhitungan ditampilkan pada output dialog

        }while(!String.valueOf(option).equals("0")); // memberi kondisi untuk loop m
        System.out.println("finished looping"); // menandakan jika video sudah dikerjakan 
    }
}