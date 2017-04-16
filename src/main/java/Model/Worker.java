package Model;

import java.util.Date;

/**
 * 功能：json测试
 * Created by cgl on 2017/4/16 0016.
 */
public class Worker {
    private String name;
    private Integer id;
    private Date birthday;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Worker() {
    }

    public Worker(String name, Integer id, Date birthday) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
    }
}
