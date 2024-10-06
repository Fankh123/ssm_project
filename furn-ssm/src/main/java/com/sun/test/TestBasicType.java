package com.sun.test;

public class TestBasicType {
    int id;
    String name;
    int age;
    public TestBasicType(int a,String b,int c){
        this.id=a;
        this.name=b;
        this.age=c;
    }

    @Override
    public String toString() {
        return "id: "+this.id+"\n"+"name: "+this.name+"\n"+"age: "+this.age;
    }
}
