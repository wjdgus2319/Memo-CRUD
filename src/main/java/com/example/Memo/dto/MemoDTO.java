package com.example.Memo.dto;

public class MemoDTO {
    private Long id;
    private String content;

    // 생성자
    public MemoDTO(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    // Getter, Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
