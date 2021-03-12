package com.itchina.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date: 2021/3/12 15:11
 * @Desc: 定义日志实体类
 */
public class LoggerBO implements Serializable {

    private Long id;

    private String content;

    private String description;

    private String ip;

    private String module;

    private String username;

    private Date createAt;

    private Date updateAt;

    private Integer able;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getAble() {
        return able;
    }

    public void setAble(Integer able) {
        this.able = able;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", ip='" + ip + '\'' +
                ", module='" + module + '\'' +
                ", username='" + username + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", able=" + able +
                '}';
    }
}
