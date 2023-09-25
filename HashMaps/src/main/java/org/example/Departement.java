package org.example;

public class Departement {

    private String dptid;
    private String dptname;

    public Departement(String di, String dn){
        this.dptid = di;
        this.dptname = dn;
    }

    public String getDptid() {
        return dptid;
    }

    public String getDptname() {
        return dptname;
    }

    public void setDptid(String dptid) {
        this.dptid = dptid;
    }

    public void setDptname(String dptname) {
        this.dptname = dptname;
    }

    @Override
    public String toString() {
        return "Departement{" + "id = " + dptid + ", name = " + dptname + '}';
    }

}
