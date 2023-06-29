package com.afkl.travel.exercise;

import com.afkl.travel.exercise.entity.Location;
import com.afkl.travel.exercise.entity.LocationType;
import com.afkl.travel.exercise.entity.Translation;
import com.afkl.travel.exercise.repository.LocationRepository;
import com.afkl.travel.exercise.repository.TranslationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Todo: what is component?
@Component
public class RepositoryCommandLineRunner implements CommandLineRunner {
    // Todo: what is this syntax?
    private static final Logger log = LoggerFactory.getLogger(RepositoryCommandLineRunner.class);

    // TODO: Why should not use field Autowired
    private final LocationRepository locationDAOService;
    private final TranslationRepository translationDAOService;

    @Autowired
    RepositoryCommandLineRunner(LocationRepository locationDAOService, TranslationRepository translationDAOService){
        this.locationDAOService = locationDAOService;
        this.translationDAOService = translationDAOService;
    }

    private void initializeDatabase(){
        locationDAOService.save(new Location(4614, "NL", LocationType.COUNTRY, 5.45, 52.3, null));
        locationDAOService.save(new Location(5366,"AMS", LocationType.CITY,4.78417,52.31667,4614));
        locationDAOService.save(new Location(6412,"AMS", LocationType.AIRPORT,4.76806,52.30833,5366));

        translationDAOService.save(new Translation(7131, 4614     , "EN"       , "Netherlands" , "Netherlands (NL)"));
        translationDAOService.save(new Translation(7132 , 4614     ,"NL"       ,"Nederland"   , "Nederland (NL)"));
        translationDAOService.save(new Translation(8635 , 5366     ,"EN"       ,"Amsterdam"   ,"Amsterdam (AMS)"));
        translationDAOService.save(new Translation(8636 , 5366     ,"NL"       ,"Amsterdam"   ,"Amsterdam (AMS)"));
        translationDAOService.save(new Translation(9970 , 6412     ,"NL"       ,"Schiphol"    ,"Amsterdam - Schiphol (AMS), Nederland)"));

        log.info("Database is initialized");
    }

    @Override
    public void run(String... arg0) throws Exception {

        log.info("Start My Application...");
        // EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnit");

        initializeDatabase();

//        System.out.println("\nfindAll()");
//        repository.findAll().forEach(x -> System.out.println(x));
//
//        System.out.println("\nfindById(1L)");
//        repository.findById(1l).ifPresent(x -> System.out.println(x));
//
//        System.out.println("\nfindByName('Node')");
//        repository.findByCode("Node").ifPresent(x -> System.out.println(x));

    }
}
