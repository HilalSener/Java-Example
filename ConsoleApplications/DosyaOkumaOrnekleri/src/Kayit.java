public class Kayit {

    public String un, pw, em;

    public Kayit(String un, String pw, String em) {
        this.un = un;
        this.pw = pw;
        this.em = em;
    }

    public Kayit(String str) {
        String tmp[] = str.split(";");
        this.un = tmp[0];
        this.pw = tmp[1];
        this.em = tmp[2];
    }

    public String toString() {
// ecivas 1234 (i.am@live.jp)
        return un + " " + pw + " (" + em + ")";
    }

}
