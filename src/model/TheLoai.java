package model;

public class TheLoai {
    private int theLoai;
    private String tenTheLoai;

    public int getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(int theLoai) {
        this.theLoai = theLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public TheLoai() {
    }

    public TheLoai(int theLoai, String tenTheLoai) {
        this.theLoai = theLoai;
        this.tenTheLoai = tenTheLoai;
    }
    
    
}
