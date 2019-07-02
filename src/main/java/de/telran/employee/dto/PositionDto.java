package de.telran.employee.dto;

public class PositionDto extends DtoWithId {

    public PositionDto() {
    }

    public PositionDto(Integer value, String display) {
        this.value = value;
        this.display = display;
    }

    private Integer value;
    private String display;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
