package com.example.furama.repository;

import com.example.furama.model.HopDong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopDongRepository extends JpaRepository<HopDong,Integer> {
        Iterable<HopDong> findAllByIdKhachHang(int id);
}
