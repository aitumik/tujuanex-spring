package com.aitumik.tujuanex.greetingservice;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="greetings")
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="language")
    private String language;

    @Column(name="text")
    private String text;

    @Column(name="published")
    private boolean published;

    Greeting() {}

    public Greeting(String language, String text,boolean published) {
        this.language = language;
        this.text = text;
        this.published = published;
    }

    public Long getId() {
        return this.id;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getText() {
        return this.text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isPublished() {
        return this.published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Greeting)) return false;
        Greeting greeting = (Greeting) o;
        return Objects.equals(id, greeting.id) && Objects.equals(language, greeting.language) && Objects.equals(text, greeting.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, text);
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
