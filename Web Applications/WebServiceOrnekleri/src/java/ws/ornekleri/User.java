package ws.ornekleri;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    public String fn, ln;
    public int bd;
    
    public User(String fn, String ln, int bd) {
        this.fn = fn;
        this.ln = ln;
        this.bd = bd;
    }
    
    @XmlElement
    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

     @XmlElement
    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

     @XmlElement
    public int getBd() {
        return bd;
    }

    public void setBd(int bd) {
        this.bd = bd;
    }
}
