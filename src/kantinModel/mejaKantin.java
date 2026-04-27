package kantinModel;

import kantinEnums.statusMeja;

public class mejaKantin {
    private int mejaId;
    private String nomorMeja;
    private int kapasitas;
    private statusMeja statusMeja;

    public mejaKantin(int mejaId, String nomorMeja, int kapasitas) {
        this.mejaId = mejaId;
        this.nomorMeja = nomorMeja;
        this.kapasitas = kapasitas;
        this.statusMeja = statusMeja.TERSEDIA;
    }

    public void ubahStatus(statusMeja status) {
        this.statusMeja = status;
    }

    public String getNomorMeja() { return nomorMeja; }
}