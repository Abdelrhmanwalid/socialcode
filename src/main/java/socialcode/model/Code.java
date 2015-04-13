package socialcode.model;

import javax.persistence.*;

@Entity
@Table(name = "Codes")
public class Code {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String language;
    private String code;
    private boolean onProfile;
    private String input;
    private String output;
    private String status;
    private boolean runnable;
    @OneToOne
    private Code parent;
    @OneToOne
    private Post post;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Code getParent() {
        return parent;
    }

    public void setParent(Code parent) {
        this.parent = parent;
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

    public boolean isOnProfile() {
        return onProfile;
    }

    public void setOnProfile(boolean onProfile) {
        this.onProfile = onProfile;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}