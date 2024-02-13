package it.epicode.w6d2task.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.Random;

@Data
public class Author {
    private int id = new Random().nextInt(1, Integer.MAX_VALUE);
    private String      name;
    private String      surname;
    private String      email;
    private String      avatar;
    private LocalDate   birthday;

}
