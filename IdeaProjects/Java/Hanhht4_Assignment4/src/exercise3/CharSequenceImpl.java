package exercise3;

public class CharSequenceImpl implements CharSequence{

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public CharSequenceImpl() {
    }

    public CharSequenceImpl(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        return this.text.length();
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.text.subSequence(start, end);
    }
}
