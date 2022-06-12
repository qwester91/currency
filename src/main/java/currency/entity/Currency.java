package currency.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="currency")
public class Currency {
    @Id
    @GeneratedValue(generator = "increment")
    long id;
    @Column
    String name;
    @Column
    String description;
    @Id
    String code;
    @Column(name = "create_time")
    LocalDateTime createTime;
    @Column(name = "update_time")
    LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
