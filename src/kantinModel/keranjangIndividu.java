package kantinModel;

public class keranjangIndividu {
    private int itemId;
    private masterMenu menu; 
    private int qty;
    private String catatan;
    private int subtotalHarga;

    public keranjangIndividu(int itemId, masterMenu menu, int qty, String catatan) {
        this.itemId = itemId;
        this.menu = menu;
        
        if (qty <= 0) {
            System.out.println("Peringatan: Qty tidak valid! Diset default ke 1.");
            this.qty = 1;
        } else {
            this.qty = qty;
        }
        
        this.catatan = catatan;
        this.subtotalHarga = hitungSubtotal();
    }

    public int hitungSubtotal() {
        return menu.getHargaSatuan() * this.qty;
    }
}