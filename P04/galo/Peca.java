abstract public class Peca {
protected:
  final char _player;
public:
  Peca(char player) {
    _player = player;
  }
  abstract String getPlayerName();

}
