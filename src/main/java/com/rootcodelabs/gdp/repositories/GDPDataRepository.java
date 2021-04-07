package com.rootcodelabs.gdp.repositories;

import com.rootcodelabs.gdp.entities.GDPData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author - Nipuna Kumaranathunga
 * @description - Queries are used to minimized whole data objects loading to the memory
 */
@Repository
public interface GDPDataRepository extends JpaRepository<GDPData, Integer> {
    @Query(value="SELECT g.value FROM GDPData g WHERE g.year=:year AND LOWER(g.alpha3Code)=:alpha3Code")
    public Double getValueByYearAndAlpha3Code(@Param("year") Integer year, @Param("alpha3Code") String alpha3Code);
}
