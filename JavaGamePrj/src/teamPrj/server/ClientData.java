package teamPrj.server;
import java.io.Serializable;

public class ClientData implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -8285970549240031735L;
  int player;
  int x;
  int y;

  public void print() {
    System.out.printf("%d %d %d\n", player, x, y);
  }
}