package socialcode.model;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import java.util.Date;

@Entity
@Table(name = "Codes")
public class Code {

    @Id
    @GeneratedValue
    private int id;
    @Length.List({
            @Length(min = 1, message = "Can you make this condition ($title.length > 0) equal true ?"),
            @Length(max = 50, message = "($title.length <= 50) = false // make it true")
    })
    private String title;
    private String language;
    @Type(type = "text")
    @Length(min = 1 , message = "I can't see your code !!")
    private String code;
    private boolean onProfile;
    @Type(type = "text")
    private String input;
    @Type(type = "text")
    private String output;
    private String status;
    private boolean runnable;
    @ManyToOne(cascade = CascadeType.ALL)
    private Code parent;
    @OneToOne(cascade = CascadeType.ALL)
    private Post post;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;
    private Date created_at;
    private Date updated_at;

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


    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }


    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

}