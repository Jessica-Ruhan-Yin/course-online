package com.course.server.enums;

/**
 * @Description
 * @Author Jessica
 * @Version v
 * @Date 2021/9/11
 */
public enum FileUseEnum {

    COURSE("C", "课程"),
    TEACHER("T", "讲师");

    private String code;

    private String desc;

    FileUseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 根据code得到枚举类型
     */
    public static FileUseEnum getByCode(String code){
        for(FileUseEnum e: FileUseEnum.values()){
            if(code.equals(e.getCode())){
                return e;
            }
        }
        return  null;
    }
}