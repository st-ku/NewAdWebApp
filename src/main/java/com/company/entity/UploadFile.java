package com.company.entity;

import javax.persistence.*;
import java.util.Base64;

@Entity
@Table(name = "FILES_UPLOAD")
public class UploadFile {
    private long id;
    private String fileName;
    @Lob
    @Column(name = "DATA")
    private byte[] data;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UPLOAD_ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Base64.getEncoder().encodeToString(data);
    }
}