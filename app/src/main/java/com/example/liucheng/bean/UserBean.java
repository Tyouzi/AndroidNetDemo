package com.example.liucheng.bean;

public class UserBean {

    @Override
    public String toString() {
        return "UserBean{" +
                "status=" + status +
                ", data=" + data.toString() +
                '}';
    }

    /**
     * status : 200
     * data : {"name":"name","age":10,"header":"errtty"}
     */

    private int status;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @Override
        public String toString() {
            return "DataBean{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", header='" + header + '\'' +
                    '}';
        }

        /**
         * name : name
         * age : 10
         * header : errtty
         */

        private String name;
        private int age;
        private String header;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }
    }
}
