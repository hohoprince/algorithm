package main;

import java.util.*;

class Student implements Comparable<Student> {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        if (this.korean == o.korean && this.english == o.english && this.math == o.math) {
            return this.name.compareTo(o.name);
        }
        if (this.korean == o.korean && this.english == o.english) {
            return Integer.compare(o.math, this.math);
        }
        if (this.korean == o.korean) {
            return Integer.compare(this.english, o.english);
        }
        return Integer.compare(o.korean, this.korean);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int kor = sc.nextInt();
            int eng = sc.nextInt();
            int math = sc.nextInt();

            studentList.add(new Student(name, kor, eng, math));
        }

        Collections.sort(studentList);

        for (int i = 0; i < n; i++) {
            System.out.println(studentList.get(i).getName());
        }

    }

}

/*
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90
 */

