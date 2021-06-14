import java.io.*;
import java.net.*;

class Packet implements Serializable {
    private static final long serialVersionUID = -5756298698047880134L;
    int score;
    Packet(int num) {
        score = num;
    }
}

class Server{
    DatagramSocket dSock;
    DatagramPacket packet;                                          //開啟順序有差 一定要先講好誰先啟動
    InetAddress address = InetAddress.getByName("192.168.137.22"); // 兩個玩家要連內網並輸入對方ipv4
    int port = 8086;
    Server() throws Exception{
        System.out.println("run");
        dSock = new DatagramSocket(8086);
    }
    public int recv_score() throws Exception{
        byte[] recvBuf = new byte[5000];
        packet = new DatagramPacket(recvBuf, recvBuf.length);
        dSock.receive(packet);
        ByteArrayInputStream byteStream = new ByteArrayInputStream(recvBuf);
        ObjectInputStream is = new ObjectInputStream(new BufferedInputStream(byteStream));
        address = packet.getAddress();
        port = packet.getPort();
        Packet object = (Packet) is.readObject();
        System.out.println("receive " + object.score);
        is.close();
        return object.score;
    }
    public void send_score(int score) throws Exception{
        ByteArrayOutputStream send_byteStream = new ByteArrayOutputStream(5000);
        ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(send_byteStream));
        Packet o = new Packet(score);
        os.flush();
        os.writeObject(o);
        os.flush();
        byte[] sendBuf = send_byteStream.toByteArray();
        packet = new DatagramPacket(sendBuf, sendBuf.length, address, port);
        dSock.send(packet);
        System.out.println("Send " + o.score);
        os.close();
    }
    public void close_server(){
        dSock.close();
    }
}