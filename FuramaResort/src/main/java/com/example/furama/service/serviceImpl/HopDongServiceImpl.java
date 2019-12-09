package com.example.furama.service.serviceImpl;

import com.example.furama.model.HopDong;
import com.example.furama.repository.HopDongRepository;
import com.example.furama.service.HopDongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HopDongServiceImpl implements HopDongService {
    @Autowired
    HopDongRepository hopDongRepository;

    @Override
    public Iterable<HopDong> findAllByIdKhachHang(int id) {
        return hopDongRepository.findAllByIdKhachHang(id);
    }

    @Override
    public void save(HopDong hopDong) {
        hopDongRepository.save(hopDong);
    }
}
