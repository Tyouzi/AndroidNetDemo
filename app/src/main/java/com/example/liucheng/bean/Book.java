package com.example.liucheng.bean;

import java.util.List;

public class Book {

    @Override
    public String toString() {
        return "Book{" +
                "name='" + user + '\'' +
                ", status=" + status +
                ", data=" + data.toString() +
                '}';
    }

    /**
     * name : abs
     * data : [{"name":"abc","year":123},{"name":"cfv","year":456}]
     * status : 200
     */

    private String user;
    private int status;
    private List<DataBean> data;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "name='" + name + '\'' +
                    ", year=" + year +
                    '}';
        }

        /**
         * name : abc
         * year : 123
         */

        private String name;
        private int year;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }
    }
}
