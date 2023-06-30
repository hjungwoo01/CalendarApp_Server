package com.hjungwoo01.calendarappserver.model.file;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(schema = "memos", name = "files")
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private long memoId;
    private String name;
    private String type;
    @Lob
    private byte[] data;
    public File() {
    }
    public File(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
    public String getId() {
        return id;
    }
    public long getMemoId() {
        return memoId;
    }
    public void setMemoId(long id) {
        this.memoId = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }
}