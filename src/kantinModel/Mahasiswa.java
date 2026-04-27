package kantinModel;

import kantinEnums.Role;

public class Mahasiswa extends Pengguna {
    public Mahasiswa(int userId, String namaLengkap, String noHp) {
        super(userId, namaLengkap, Role.MAHASISWA, noHp);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Mahasiswa ID: " + userId + " | Nama: " + namaLengkap);
    }
}