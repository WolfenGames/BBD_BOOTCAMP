package za.co.bbd.eightball;

public class Options {
    private String[] _options = new String[] {
        "Hmm Fucked up you did",
        "I guess it will work",
        "Lord Geff wont be happy",
        "Lord Geralt of Rivia would be satisfied",
        "Michael is a piece of shit"
    };

    public int GetLength()
    {
        return _options.length;
    }

    public String getString(int x) {
        if (x <= this.GetLength() && x > 0)
        {
            return _options[x];
        }
        return _options[0];
    }
}