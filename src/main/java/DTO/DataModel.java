package DTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: liaowei
 * @date: 2022/2/18 12:22
 * @description: DataModel
 * 需要根据excel的排列修改。一一对应
 */
@Getter
@Setter
public class DataModel {
    public String description;
    public String name;
    public String notuse;
    public String required;

    public DataModel() {
    }
}
