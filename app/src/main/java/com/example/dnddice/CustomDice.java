package com.example.dnddice;

public class CustomDice {

    private int id;
    private String title;

    private String number;
    private String number2;
    private String type;
    private String type2;
    private String bonus;
    private String bonus2;

    public CustomDice(int id, String title, String number, String type, String bonus, String number2, String type2, String bonus2) {
        this.id = id;
        this.title = title;

        this.number = number;
        this.number2 = number2;
        this.type = type;
        this.type2 = type2;
        this.bonus = bonus;
        this.bonus2 = bonus2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getBonus2() {
        return bonus2;
    }

    public void setBonus2(String bonus2) {
        this.bonus2 = bonus2;
    }
}
