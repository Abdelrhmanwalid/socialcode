package socialcode.model;

import javax.persistence.*;

@Entity
@Table(name = "Codes")
public class Code {

    @Id
    @GeneratedValue
    private int id;
    private String language;
    private String code;
    private String type;
    private String input;
    private String output;
    private boolean runnable;
    @OneToOne
    @JoinColumn(nullable = true)
    private Code parent_id;
    @OneToOne
    private Post post;

    public Code getParent_id() {
        return parent_id;
    }

    public void setParent_id(Code parent_id) {
        this.parent_id = parent_id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public boolean isRunnable() {
        return runnable;
    }

    public void setRunnable(boolean runnable) {
        this.runnable = runnable;
    }
}
