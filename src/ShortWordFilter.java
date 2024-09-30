public class ShortWordFilter implements Filter {

    String word;

    public ShortWordFilter(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public boolean accept(Object x) {
        x = getWord();
        String y = x.toString();
        if(y.length() < 5) {
            return true;
        } else {
            return false;
        }
    }
}
