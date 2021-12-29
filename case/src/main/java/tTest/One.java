package tTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.*;
import java.util.*;

public class One {

    public static void main(String[] args) {
        List students = newStu();
        Iterator iterator = students.iterator();
        while (iterator.hasNext()){
            Student student = (Student) iterator.next();
            if (student.getAge() < 10){
                iterator.remove();
            }
        }
        bubbleSort(students);
    }

    /**
     * 创建20 个学生对象
     * @return
     */
    public static List newStu(){
        ArrayList<Student> students = new ArrayList<>(20);
        int count  = 0;
        while (true){
            int randomAge = (int) (Math.random() * 13 + 8);
            students.add(new Student(randomAge,"name" + randomAge));
            if (++count == 20){
                break;
            }
        }
        return students;
    }

    /**
     * 冒泡排序从大到小
     * @param students
     * @return
     */
    public static List bubbleSort(List students){
        Student[] studentArray = (Student[]) students.toArray(new Student[students.size()]);
        for (int i = 0; i < studentArray.length - 1; i++) {
            for (int j = 0; j < studentArray.length - 1 - i; j++) {
                if (studentArray[j].getAge() < studentArray[j + 1].getAge()){
                    Student minAgeStudentStore = studentArray[j];
                    studentArray[j] = studentArray[j +1];
                    studentArray[j + 1] = minAgeStudentStore;
                }
            }
        }
        return Arrays.asList(studentArray);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Student{
    private int age;
    private String name;
}


