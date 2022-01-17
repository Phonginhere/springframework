package com.project.hocvien.repositories;

import com.project.hocvien.models.HocVien;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class HocVienRepository {
    private List<HocVien> hocViens = new ArrayList<HocVien>();
    public HocVienRepository(){
        hocViens.add(new HocVien("hva", "Nguyen Van A", "c1908i", 1.0f,2.0f,3.0f,4.0f));
        hocViens.add(new HocVien("hvb", "Nguyen Van B", "a1905z",
                1.0f,2.0f,3.0f,4.0f));
        hocViens.add((new HocVien("hvc", "Nguyen Van C", "a2002l",
                1.0f,2.0f,3.0f,4.0f)));
    }
    public List<HocVien> findAll(){
        return hocViens;
    }
    public HocVien findHocVienByName(String name){
        return hocViens.stream().filter(hocVien -> name.toLowerCase().equals(hocVien.getHo_va_ten().toLowerCase())).findAny().orElse(null);
    }
    public void addNew(HocVien hv){
        hocViens.add(hv);
    }
}
