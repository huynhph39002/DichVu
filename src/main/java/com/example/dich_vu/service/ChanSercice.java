package com.example.dich_vu.service;

import com.example.dich_vu.entity.Chan;
import com.example.dich_vu.repos.ChanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChanSercice {
    @Autowired
    private ChanRepository chanRepository;

    public List<Chan> getAllChan() {
        return chanRepository.findAll();
    }

     public void saveChan(Chan chan) {
       chanRepository.save(chan);
    }
//public void saveChan(Chan chan) throws Exception {
//    // Kiểm tra trùng mã
//    if (isMaExists(chan.getMa())) {
//        throw new Exception("Mã " + chan.getMa() + " đã tồn tại.");
//    }
//    chanRepository.save(chan);
//}

    public Chan getChanById(Integer id) {
        return chanRepository.findById(id).orElse(null);
    }

    public void deleteChanById(Integer id) {
        chanRepository.deleteById(id);
    }
    // Phương thức kiểm tra trùng mã
    public boolean isMaExists(String ma) {
        return chanRepository.existsByMa(ma);  // Giả sử bạn có phương thức existsByMa trong repository
    }
}
