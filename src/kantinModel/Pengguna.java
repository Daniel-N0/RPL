package kantinModel;

import kantinEnums.Role;

public abstract class Pengguna {
    protected int userId;
    protected String namaLengkap;
    protected Role role;
    protected String noHp;

    public Pengguna(int userId, String namaLengkap, Role role, String noHp) {
        this.userId = userId;
        this.namaLengkap = namaLengkap;
        this.role = role;
        this.noHp = noHp;
    }

    public abstract void tampilkanInfo();
    
    public String getNamaLengkap() { return namaLengkap; }
}