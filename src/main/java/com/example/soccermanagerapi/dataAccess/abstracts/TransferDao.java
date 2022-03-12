package com.example.soccermanagerapi.dataAccess.abstracts;

import com.example.soccermanagerapi.entities.concretes.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferDao extends JpaRepository<Transfer,Integer> {
    @Query("From Transfer where playerId =: playerId")
    Transfer getById(String playerId);

    @Query("From Transfer order by playerValue desc")
    Transfer getByTransferValue();

    @Query("From Transfer where transferedPrice =: transferedPrice")
    Transfer getByTransferedPrice(String transferedPrice);

    @Query("From Transfer between min and max")
    Transfer getByTransferedPriceBetween(Integer min, Integer max);
}

