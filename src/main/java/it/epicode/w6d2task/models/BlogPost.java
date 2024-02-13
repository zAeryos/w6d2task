package it.epicode.w6d2task.models;

import lombok.Data;

import java.util.Random;

@Data
public class BlogPost {
    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String  category;
    private String  title;
    private String  cover;
    private String  content;
    private int     readTime;
}
