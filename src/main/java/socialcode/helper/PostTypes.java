package socialcode.helper;

public enum PostTypes {
    TOUTRIAL("tutorial"), CODE("code");

    private String string;

    PostTypes(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
