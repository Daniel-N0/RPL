package kantinMain;

import kantinModel.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // 1. PRE-LOAD MASTER DATA
        mejaKantin m01 = new mejaKantin(1, "M-01", 4);
        masterMenu mNasiGoreng = new masterMenu(201, "Nasi Goreng", 15000, 50);
        masterMenu mAyamGeprek = new masterMenu(202, "Ayam Geprek", 18000, 20);
        masterMenu mEsTeh = new masterMenu(203, "Es Teh Manis", 5000, 100);

        System.out.println("SISTEM RESERVASI & GROUP ORDER KANTIN");

        // 2. INPUT INISIATOR
        System.out.print("Masukkan Nama Anda (Inisiator) : ");
        String namaInisiator = input.nextLine();
        Mahasiswa inisiator = new Mahasiswa(101, namaInisiator, "0811");
        sesiGroupOrder sesi = new sesiGroupOrder(5001, inisiator, m01, "KANTIN77");

        // 3. INPUT ANGGOTA
        System.out.println("\n--- Tahap: Undang Teman ---");
        sesi.tambahAnggota(new anggotaGroup(701, inisiator)); 

        int idAnggotaCounter = 702;
        int idUserCounter = 102;
        
        while (true) {
            System.out.print("Ada teman yang Join? (Y/N): ");
            String jawab = input.nextLine();
            
            if (jawab.equalsIgnoreCase("N")) break;
            else if (jawab.equalsIgnoreCase("Y")) {
                System.out.print("Nama Teman: ");
                String namaTeman = input.nextLine();
                Mahasiswa temanBaru = new Mahasiswa(idUserCounter++, namaTeman, "08xx");
                anggotaGroup anggotaBaru = new anggotaGroup(idAnggotaCounter++, temanBaru);
                
                sesi.tambahAnggota(anggotaBaru); 
            }
        }

        // 4. PEMILIHAN MENU
        System.out.println("\n--- Tahap: Pemilihan Menu ---");
        System.out.println("1. Nasi Goreng (Rp15k) | 2. Ayam Geprek (Rp18k) | 3. Es Teh (Rp5k)\n");

        int idItemCounter = 901;

        for (anggotaGroup anggota : sesi.getDaftarAnggota()) {
            System.out.println(">> Giliran: " + anggota.getUser().getNamaLengkap());
            
            while (true) {
                System.out.print("Pilih Menu (1/2/3) atau '0' untuk selesai: ");
                int pilihan = Integer.parseInt(input.nextLine());
                
                if (pilihan == 0) {
                    anggota.setStatusSiap();
                    System.out.println();
                    break;
                }
                
                masterMenu menuDipilih = null;
                if (pilihan == 1) menuDipilih = mNasiGoreng;
                else if (pilihan == 2) menuDipilih = mAyamGeprek;
                else if (pilihan == 3) menuDipilih = mEsTeh;

                if (menuDipilih != null) {
                    System.out.print("Jumlah (Qty)                 : ");
                    int qty = Integer.parseInt(input.nextLine());
                    
                    System.out.print("Catatan pesanan (opsional)   : ");
                    String catatan = input.nextLine();
                    
                    keranjangIndividu pesanan = new keranjangIndividu(idItemCounter++, menuDipilih, qty, catatan);
                    anggota.tambahPesanan(pesanan);
                    
                    if (catatan.isEmpty()) {
                        System.out.println("-> " + qty + "x " + menuDipilih.getNamaMenu() + " masuk keranjang.\n");
                    } else {
                        System.out.println("-> " + qty + "x " + menuDipilih.getNamaMenu() + " (Catatan: " + catatan + ") masuk keranjang.\n");
                    }
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            }
        }

        // 5. PROSES CHECKOUT
        System.out.println("\n--- Tahap: Memproses Pesanan ---");
        System.out.print("Tekan ENTER untuk Checkout semua pesanan...");
        input.nextLine();
        
        pesananKolektif tiket = sesi.checkoutSesi();
        if (tiket != null) {
            tiket.prosesCheckout();
        }

        input.close();
    }
}