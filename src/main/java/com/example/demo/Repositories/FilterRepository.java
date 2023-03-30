package com.example.demo.Repositories;

import com.example.demo.Entities.FilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterRepository extends JpaRepository<FilterEntity, Integer> {
    FilterEntity findByTop(boolean top);
    FilterEntity findByPants(boolean pants);
    FilterEntity findByColors(String colors);
    FilterEntity findBySize(Integer size);
    FilterEntity findByHeaddress(boolean headdress);
    FilterEntity findByBottom(boolean bottom);
    FilterEntity findByShoes(boolean shoes);
    FilterEntity findByGender(boolean gender);
}
