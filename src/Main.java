public class Main {
    public static MainFrame PiJano;
    public static Controlls ps4;
    public static Server connect;
    public static void main(String[] args) throws Exception {
            connect = new Server();
            PiJano = new MainFrame();
            ps4 = new Controlls();
    }
}
