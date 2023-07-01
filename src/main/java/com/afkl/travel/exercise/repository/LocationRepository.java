package com.afkl.travel.exercise.repository;

import com.afkl.travel.exercise.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query(value = "WITH RECURSIVE location_hierarchy(id, code, parent_id, type, longitude, latitude)  AS ( " +
            "            SELECT id, code, parent_id, type, longitude, latitude FROM Location WHERE code = :parentCode " +
            "            UNION ALL " +
            "            SELECT l.id, l.code, l.parent_id, l.type, l.longitude, l.latitude FROM Location l " +
            "            INNER JOIN location_hierarchy lh ON lh.id = l.parent_id " +
            ") " +
            "           SELECT * FROM location_hierarchy where type=:type", nativeQuery = true)
    List<Location> findRecursiveByTypeAndParentCode(String type, String parentCode);
}
