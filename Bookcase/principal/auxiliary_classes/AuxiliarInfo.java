package auxiliary_classes;

import classes.Carreer;
import classes.Material;
import classes.Subject;
import classes.Year;

public class AuxiliarInfo {
    private Carreer carreer;
    private Subject subject;
    private Year year;
    private Material material;
    public AuxiliarInfo(Carreer carreer, Subject subject, Year year, Material material) {
        this.carreer = carreer;
        this.subject = subject;
        this.year = year;
        this.material = material;
    }
    public AuxiliarInfo()
    {

    }
    public Carreer getCarreer() {
        return carreer;
    }
    public void setCarreer(Carreer carreer) {
        this.carreer = carreer;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Year getYear() {
        return year;
    }
    public void setYear(Year year) {
        this.year = year;
    }
    public Material getMaterial() {
        return material;
    }
    public void setMaterial(Material material) {
        this.material = material;
    }

}
