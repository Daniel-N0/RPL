package kantinModel;

import kantinEnums.statusMeja;
import kantinEnums.statusSesi;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class sesiGroupOrder {
    private int sesiId;
    private Pengguna inisiator; 
    private mejaKantin meja; 
    private String kodeUndangan;
    private statusSesi statusSesi;
    private Date waktuDibuat;
    private List<anggotaGroup> daftarAnggota; 

    public sesiGroupOrder(int sesiId, Pengguna inisiator, mejaKantin meja, String kode) {
        this.sesiId = sesiId;
        this.inisiator = inisiator;
        this.meja = meja;
        this.kodeUndangan = kode;
        this.statusSesi = statusSesi.OPEN;
        this.waktuDibuat = new Date();
        this.daftarAnggota = new ArrayList<>();
        buatSesi();
    }

    public void buatSesi() {
        meja.ubahStatus(statusMeja.DIRESERVASI);
        System.out.println("\n[Sesi " + sesiId + "] Dibuat oleh " + inisiator.getNamaLengkap() + " di Meja " + meja.getNomorMeja());
        System.out.println("Kode Undangan: " + kodeUndangan + "\n");
    }

    public void tambahAnggota(anggotaGroup anggotaBaru) {
        for (anggotaGroup a : daftarAnggota) {
            if (a.getUser().getNamaLengkap().equalsIgnoreCase(anggotaBaru.getUser().getNamaLengkap())) {
                System.out.println("[DITOLAK] " + anggotaBaru.getUser().getNamaLengkap() + " sudah berada di dalam Sesi ini!");
                return; 
            }
        }
        daftarAnggota.add(anggotaBaru);
        System.out.println(anggotaBaru.getUser().getNamaLengkap() + " berhasil bergabung ke sesi!");
    }

    public pesananKolektif checkoutSesi() {
        if (this.statusSesi == statusSesi.CHECKOUT) {
            System.out.println("GAGAL: Sesi ini sudah di-checkout sebelumnya!");
            return null;
        }
        this.statusSesi = statusSesi.CHECKOUT;
        return new pesananKolektif(8801, this); 
    }

    public List<anggotaGroup> getDaftarAnggota() { return daftarAnggota; }
    public mejaKantin getMeja() { return meja; }
}