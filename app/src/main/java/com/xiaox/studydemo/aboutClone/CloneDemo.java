package com.xiaox.studydemo.aboutClone;

/**
 * @version V1.0
 * @Title: Loan
 * @Description: 深拷贝和浅拷贝
 * @date 2019/5/15
 * @author:xiaox
 * @email:303378520@qq.com
 * @replace author:
 * @replace date:
 */
public class CloneDemo {

    public static void main(String[] args) {
        Person p1 = new Person("aaa", 666);
        Person p2 = (Person) p1.clone();

        System.out.println("person1和person2的name内存地址是否相同 =" + (p1.name == p2.name));//true
        System.out.println("person1和person2的内存地址是否相同 =" + (p1 == p2));//false

        Animal animal1=new Animal(new Person("aaa",666),999);
        Animal animal2=(Animal) animal1.clone();
        System.out.println("animal1和animal2的host内存地址是否相同:"+(animal1.host==animal2.host));//fasle
        System.out.println("animal1和animal2的age内存地址是否相同:"+(animal1.age==animal2.age));//true

    }

    /**
     * 对于基本的数据类型，都是值传递，不存在什么深拷贝浅拷贝!
     *
     * 浅拷贝（Shallow Copy）：
     *
     * ①对于数据类型是基本数据类型的成员变量，浅拷贝会直接进行值传递，也就是将该属性值复制一份给新的对象。
     * 因为是两份不同的数据，所以对其中一个对象的该成员变量值进行修改，不会影响另一个对象拷贝得到的数据。
     *
     * ②对于数据类型是引用数据类型的成员变量，比如说成员变量是某个数组、某个类的对象等，那么浅拷贝会进行引用传递，
     * 也就是只是将该成员变量的引用值（内存地址）复制一份给新的对象。因为实际上两个对象的该成员变量都指向同一个实例。
     * 在这种情况下，在一个对象中修改该成员变量会影响到另一个对象的该成员变量值。
     */

    static class Person implements Cloneable {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }

    static class Animal implements Cloneable {
        Person host;//主人
        int age;//年纪

        Animal(Person person, int age) {
            this.host = person;
            this.age = age;
        }

        @Override
        public Object clone() {
            try {
                Animal animal = (Animal) super.clone();
                //相对于浅拷贝而言，对于引用类型的修改，并不会影响到对应的copy对象的值。
                // 每一层的每个对象都进行浅拷贝=深拷贝。
                animal.host = (Person) host.clone();//深拷贝处理
                return animal;
            } catch (CloneNotSupportedException e) {
                return null;
            }
        }
    }

}
