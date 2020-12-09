
package com.example.demo.controller;

import com.example.demo.dto.Teacher;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Scanner;  //For splitting input

@RestController
public class MainController {


    private int count = 1;
    private ArrayList<Teacher> list = new ArrayList<>();


    @PutMapping("/teachers")
    public ArrayList<Teacher> changeName(@RequestBody String names) {
        names = names.substring(1, names.length() - 1);
        Scanner sc = new Scanner(names);
        String oldName = null;
        String newName = null;
        if (sc.hasNext()) {
            oldName = sc.next();
        }

        if (sc.hasNext()) {
            newName = sc.next();
        }

        for(int i = 0; i < this.list.size(); ++i) {
            if (((Teacher)this.list.get(i)).getName().equals(oldName)) {
                ((Teacher)this.list.get(i)).setName(newName);
                System.out.println(oldName + " was changed to: " + newName);
            }
            else{
                System.out.println("Error: " + oldName + " does not exist.");
            }
        }

        return this.list;
    }

    @PutMapping("/teacherlink")
    public ArrayList<Teacher> changeLink(@RequestBody String input) {
        input = input.substring(1, input.length() - 1);
        Scanner sc = new Scanner(input);
        String name = null;
        String newLink = null;
        if (sc.hasNext()) {
            name = sc.next();
        }

        if (sc.hasNext()) {
            newLink = sc.next();
        }

        for(int i = 0; i < this.list.size(); ++i) {
            if (((Teacher)this.list.get(i)).getName().equals(name)) {
                ((Teacher)this.list.get(i)).setLink(newLink);
                System.out.println(name + " link was changed to: " + newLink);
            }
        }

        return this.list;
    }


    @PutMapping("/toggleteach")  // the JS function calls /toggleTeach?name=reqBody
    public ArrayList<Teacher> toggleStatus(@RequestBody String name) {
        // we get name. Ex: Tor
        //Find Tor and change his status
        //return list
        //We get here yay!
        System.out.println("Hello from toggle teach function. " + name);
        for(Teacher t: list){
            if(t.getName().equals(name)){
                t.setFree(!t.isFree());
            }
        }
        return list;

    }

    @DeleteMapping("/teachers")
    public ArrayList<Teacher> deleteTeacher(@RequestParam Integer id) {
        System.out.print("Delete called ");
        Boolean isFound = false;


        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                isFound = true;
                System.out.println(list.get(i).getName() + " was removed.");
                list.remove(i);

            }
        }
        if(!isFound){
            System.out.println("That ID doesn't exist! Tutor not found, aborting.");
        }

        return list;
    }

    @PostMapping("/teachers")
    public ArrayList<Teacher> addTeacher(@RequestBody Teacher teacher) {

        System.out.println("Added 1 tutor to the list. Total amount now is " + count);

        teacher.setId(++count);
        list.add(teacher);

        return list;
    }

    @GetMapping("/teacher")
    public Teacher getTeacher(@RequestParam Integer id) {
        System.out.print("Get single tutor called ");

        for (Teacher teacher : list) {
            if (teacher.getId() == id) {
                System.out.println(teacher.getName() + " was found.");
                return teacher;
            }
        }

        return null;
    }



    @GetMapping("/teachers")
    public ArrayList<Teacher> getAllTeachers() {
        System.out.println("Get request called. Accessed array " + list.toString());
        System.out.println(Thread.currentThread().getName());
        return list;
    }


}