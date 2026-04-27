package kantinModel;

public class masterMenu {
    private int menuId;
    private String namaMenu;
    private int hargaSatuan;
    private int stokTersedia;

    public masterMenu(int menuId, String namaMenu, int hargaSatuan, int stokTersedia) {
        this.menuId = menuId;
        this.namaMenu = namaMenu;
        this.hargaSatuan = hargaSatuan;
        this.stokTersedia = stokTersedia;
    }

    public boolean cekStok() { return stokTersedia > 0; }
    public void kurangiStok(int qty) { this.stokTersedia -= qty; }
    
    public String getNamaMenu() { return namaMenu; }
    public int getHargaSatuan() { return hargaSatuan; }
}