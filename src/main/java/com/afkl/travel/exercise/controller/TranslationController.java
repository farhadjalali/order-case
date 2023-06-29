package com.afkl.travel.exercise.controller;

import com.afkl.travel.exercise.entity.Translation;
import com.afkl.travel.exercise.entity.Translation;
import com.afkl.travel.exercise.exception.NotFoundException;
import com.afkl.travel.exercise.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel/translations")
public class TranslationController {

    private final TranslationRepository translationRepository;

    @Autowired
    public TranslationController(TranslationRepository translationRepository) {
        this.translationRepository = translationRepository;
    }

    @GetMapping("")
    public List<Translation> getTranslations() {
        return translationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Translation getTranslationById(@PathVariable("id") Integer id) throws NotFoundException {
        return translationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Translation not found with id: " + id));
    }

    // Other methods...

    @PostMapping("")
    public Translation createTranslation(@RequestBody Translation translation) {
        return translationRepository.save(translation);
    }

    @PutMapping("/{id}")
    public Translation updateTranslation(
            @PathVariable("id") Integer id,
            @RequestBody Translation translationDetails
    ) throws NotFoundException {
        Translation translation = translationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Translation not found with id: " + id));

        // Update the translation details
        translation.setName(translationDetails.getName());
        translation.setLocationId(translationDetails.getLocationId());
        translation.setLanguage(translationDetails.getLanguage());
        translation.setDescription(translationDetails.getDescription());

        return translationRepository.save(translation);
    }

    @DeleteMapping("/{id}")
    public void deleteTranslation(@PathVariable("id") Integer id) {
        Translation translation = translationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Translation not found with id: " + id));

        translationRepository.delete(translation);
    }
}
