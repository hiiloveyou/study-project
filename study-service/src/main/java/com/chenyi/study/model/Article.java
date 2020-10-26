package com.chenyi.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Article {
    private String title;
    private String content;
    private String url;
}
