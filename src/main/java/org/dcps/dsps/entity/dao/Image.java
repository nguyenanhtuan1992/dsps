package org.dcps.dsps.entity.dao;

/**
 * Created by ptanh2 on 10/24/2016.
 */
public class Image {
    private Long id;
    private String name;
    private Byte[] content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte[] getContent() {
        return content;
    }

    public void setContent(Byte[] content) {
        this.content = content;
    }
}
