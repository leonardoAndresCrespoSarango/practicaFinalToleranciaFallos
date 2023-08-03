package ec.edu.ups.proyecto.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String cellphone;
    private String time;
    private String mac_version;
    private String version;

    public Usuario(String name, String address, String cellphone, String time, String mac_version, String version) {
        this.name = name;
        this.address = address;
        this.cellphone = cellphone;
        this.time = time;
        this.mac_version = mac_version;
        this.version = version;
    }

    public Usuario(int id, String name, String address, String cellphone, String time, String mac_version, String version) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellphone = cellphone;
        this.time = time;
        this.mac_version = mac_version;
        this.version = version;
    }

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMac_version() {
        return mac_version;
    }

    public void setMac_version(String mac_version) {
        this.mac_version = mac_version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
