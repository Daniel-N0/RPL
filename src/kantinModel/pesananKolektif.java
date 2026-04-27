package kantinModel;

import kantinInterfaces.prosesTransaksi;
import kantinEnums.statusDapur;
import java.util.Date;

public class pesananKolektif implements prosesTransaksi {
    private int pesananId;
    private sesiGroupOrder sesi; 
    private int totalTagihan;
    private statusDapur statusDapur;
    private Date waktuCheckout;

    public pesananKolektif(int pesananId, sesiGroupOrder sesi) {
        this.pesananId = pesananId;
        this.sesi = sesi;
        this.statusDapur = statusDapur.MENUNGGU_KONFIRMASI;
        this.waktuCheckout = new Date();
    }

    @Override
    public int hitungTotalTagihan() {
        int total = 0;
        for (anggotaGroup anggota : sesi.getDaftarAnggota()) {
            for (keranjangIndividu item : anggota.getDaftarKeranjang()) {
                total += item.hitungSubtotal();
            }
        }
        this.totalTagihan = total;
        return total;
    }

    @Override
    public void prosesCheckout() {
        System.out.println("TIKET PESANAN KOLEKTIF");
        System.out.println("Meja Kantin   : " + sesi.getMeja().getNomorMeja());
        System.out.println("Total Tagihan : Rp " + hitungTotalTagihan());
        System.out.println("Status Dapur  : " + statusDapur);
        updateStatusDapur(statusDapur.DIPROSES);
    }

    public void updateStatusDapur(statusDapur status) {
        this.statusDapur = status;
        System.out.println("Notifikasi: Pesanan Anda sedang " + statusDapur + "!");
    }
}