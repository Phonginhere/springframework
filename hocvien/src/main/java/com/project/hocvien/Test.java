package com.project.hocvien;

import com.project.hocvien.models.HocVien;
import com.project.hocvien.services.HocVienServices;

import java.util.List;
import java.util.Scanner;

public class Test {
    private HocVienServices hocVienServices;
    public Test(HocVienServices hocVienServices){
        this.hocVienServices = hocVienServices;
    }
    public void testAll(){
        int choice = 0;

        while (choice != 4){
            System.out.println("Input 1-show all, 2-search name student, 3-insert student, 4-end");
            choice = (new Scanner(System.in)).nextInt();
            switch (choice){
                case 1:{
                    System.out.println("You are choosing: "+choice);
                    List<HocVien>hocViens = this.hocVienServices.findAll();
                    for(HocVien hocVien:hocViens){
                        System.out.println(hocVien.toString());
                    }
                    break;
                }

                case 2:{
                    System.out.println("You are choosing: "+choice);
                    System.out.println("Enter name to find: "); Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    HocVien hocVien = this.hocVienServices.findHocVienByName(name);
                    if(hocVien == null){
                        System.err.println("Cannot find this person");
                    }else{
                        System.out.println("Found: "+hocVien.toString());
                    }
                    break;
                }

                case 3:{
                    System.out.println("You are choosing: "+choice);
                    System.out.println("Please enter student information");
                    HocVien hocVien = HocVien.input();
                    this.hocVienServices.addNew(hocVien);
                }
                default:break;
            }
        }
        System.out.println("You are choosing: "+choice);
        System.out.println("Program exit, Good Bye");
    }
}
