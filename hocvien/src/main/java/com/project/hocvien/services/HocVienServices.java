package com.project.hocvien.services;

import com.project.hocvien.models.HocVien;
import com.project.hocvien.repositories.HocVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HocVienServices {
    @Autowired
    private HocVienRepository hocVienRepository;
    public List<HocVien> findAll(){
        return hocVienRepository.findAll();
    }
    public HocVien findHocVienByName(String name){
        return hocVienRepository.findHocVienByName(name);
    }
    public void addNew(HocVien hv){
        hocVienRepository.addNew(hv);
    }
}
