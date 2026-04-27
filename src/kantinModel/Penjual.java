package kantinModel;

import kantinEnums.Role;

public class Penjual extends Pengguna {
    public Penjual(int userId, String namaLengkap, String noHp) {
        super(userId, namaLengkap, Role.PENJUAL, noHp);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Penjual: " + namaLengkap);
    }
}