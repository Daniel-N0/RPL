package kantinModel;

import kantinEnums.statusKeranjang;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class anggotaGroup {
    private int anggotaId;
    private Pengguna user; 
    private statusKeranjang statusKeranjang;
    private Date waktuJoin;
    private List<keranjangIndividu> daftarKeranjang; 

    public anggotaGroup(int anggotaId, Pengguna user) {
        this.anggotaId = anggotaId;
        this.user = user;
        this.statusKeranjang = statusKeranjang.MEMILIH;
        this.waktuJoin = new Date();
        this.daftarKeranjang = new ArrayList<>();
    }

    public void tambahPesanan(keranjangIndividu item) {
        daftarKeranjang.add(item);
    }

    public void setStatusSiap() {
        this.statusKeranjang = statusKeranjang.SIAP;
        System.out.println(user.getNamaLengkap() + " siap memesan.");
    }

    public List<keranjangIndividu> getDaftarKeranjang() { 
        return daftarKeranjang; 
    }

    public Pengguna getUser() {
        return user;
    }
}