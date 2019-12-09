package com.example.furama.service;

import com.example.furama.model.HopDong;

public interface HopDongService {
    Iterable<HopDong> findAllByIdKhachHang(int id);
    void save(HopDong hopDong);
}
