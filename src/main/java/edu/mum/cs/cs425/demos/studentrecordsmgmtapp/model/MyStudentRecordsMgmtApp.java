package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyStudentRecordsMgmtApp {
    public static void main(String[] args) {
    Student    s1=new Student(110001, "Dave", LocalDate.of(1951,11,18));
     Student   s2=new Student(110002, "Anna", LocalDate.of(1990,12,07)/*12/07/1990*/);
     Student   s3= new Student(110003, "Erica", LocalDate.of(1974,1,31));/*01/31/1974*/
      Student  s4=new Student(110004, "Carlos", LocalDate.of(2009,8,22));/*08/22/2009*/
      Student  s5=new Student(110005,"Bob", LocalDate.of(1990,03,05));/*03/05/1990*/
Student[] students={s1,s2,s3,s4,s5};
        printListOfStudents(students);
        getListOfPlatinumAlumniStudents(students);
        int a[] = {1,2,3,4,5};
        int b[] = {19,9,11,0,12};
        System.out.println("*********seccond largest*************");
        System.out.println(findSecondLargest(a));
        System.out.println(findSecondLargest(b));

    }
    public static void printListOfStudents(Student[] students){
        List<Student>list= Arrays.asList(students);
        list.stream().sorted(Comparator.comparing(Student::getName)).forEach(i-> System.out.println(i));
    }
    public static void getListOfPlatinumAlumniStudents(Student[] students){
        List <Student>list=Arrays.asList(students);


        System.out.println("*********************Platinum Students**************");
        list.stream().filter(Student->Student.getDateOfAdmission().getYear()<=1991).sorted(Comparator.comparing(Student::getDateOfAdmission)).forEach(i-> System.out.println(i));
    }
    public static void printHelloWorld(int[] ints){
        for (int i:ints){
            if (i%5==0&&i%7==0){
                System.out.println("Hello World");
            }else if (i%5==0){
                System.out.println("Hello");
            }else if (i%7==0){
                System.out.println("World");
            }
        }
    }

    public static int findSecondLargest(int[] arr){
        int max1 = arr[0];
        int max2 = arr[1];
        for (int i = 2; i < arr.length; i++){
            if (arr[i] > max2)
            {
                max2 = arr[i];
            }

            if (max2 > max1)
            {
                int temp = max1;
                max1 = max2;
                max2 = temp;
            }
        }
        return max2;
    }
}
